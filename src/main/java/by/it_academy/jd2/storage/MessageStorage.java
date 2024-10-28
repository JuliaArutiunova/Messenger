package by.it_academy.jd2.storage;

import by.it_academy.jd2.entity.MessageEntity;
import by.it_academy.jd2.storage.api.IMessageStorage;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class MessageStorage implements IMessageStorage {

    private final HibernateManager hibernateManager;

    public MessageStorage(HibernateManager manager) {
        this.hibernateManager = manager;
    }


    @Override
    public void create(MessageEntity messageEntity) {
        hibernateManager.inTransaction(entityManager -> {
            entityManager.persist(messageEntity);
            return messageEntity;
        });

    }


    @Override
    public List<MessageEntity> getMessagesToUser(String login) {
        return hibernateManager.inTransaction(entityManager -> {
            List<MessageEntity> messages;

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<MessageEntity> criteriaQuery = criteriaBuilder.createQuery(MessageEntity.class);
            Root<MessageEntity> root = criteriaQuery.from(MessageEntity.class);
            criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("toUser").get("login"), login));

            messages = entityManager.createQuery(criteriaQuery).getResultList();
            return messages;
        });
    }

    @Override
    public long getMessageCount() {
        return (long) hibernateManager.inTransaction(entityManager -> entityManager
                .createNativeQuery("SELECT count(*) FROM app.message;")
                .getSingleResult());
    }
}
