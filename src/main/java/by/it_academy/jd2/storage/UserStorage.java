package by.it_academy.jd2.storage;

import by.it_academy.jd2.dto.UserNameDTO;
import by.it_academy.jd2.entity.UserEntity;
import by.it_academy.jd2.storage.api.IUserStorage;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;


public class UserStorage implements IUserStorage {
    private final HibernateManager hibernateManager;

    public UserStorage(HibernateManager manager) {

        this.hibernateManager = manager;

    }

    @Override
    public void create(UserEntity user) {

        hibernateManager.inTransaction(entityManager -> {
            entityManager.persist(user);
            return user;
        });

    }

    @Override
    public UserEntity getUser(String login) {
        return hibernateManager.inTransaction(entityManager -> entityManager.find(UserEntity.class, login));
    }

    @Override
    public long getUsersCount() {
        return (long) hibernateManager.inTransaction(entityManager -> entityManager
                .createNativeQuery("SELECT count(*) FROM app.user;")
                .getSingleResult());
    }

    @Override
    public List<UserNameDTO> getUserNames() {
        return hibernateManager.inTransaction(entityManager -> {
                    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
                    CriteriaQuery<UserNameDTO> criteriaQuery = criteriaBuilder.createQuery(UserNameDTO.class);
                    Root<UserEntity> root = criteriaQuery.from(UserEntity.class);
                    criteriaQuery.
                            select(criteriaBuilder.construct(UserNameDTO.class, root.get("login"), root.get("name")));
                    return entityManager.createQuery(criteriaQuery).getResultList();
                }
        );


    }
}
