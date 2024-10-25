package by.it_academy.jd2.storage;

import by.it_academy.jd2.entity.UserEntity;
import by.it_academy.jd2.storage.api.IUserStorage;


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



}
