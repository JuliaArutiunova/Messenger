package by.it_academy.jd2.storage.api;

import by.it_academy.jd2.entity.MessageEntity;

import java.util.List;

public interface IMessageStorage {
    void create(MessageEntity messageEntitySQL);

    List<MessageEntity> getMessagesFromUser(String from);

    List<MessageEntity> getMessagesToUser(String login);

    long getMessageCount();


}
