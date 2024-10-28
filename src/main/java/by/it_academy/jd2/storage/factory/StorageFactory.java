package by.it_academy.jd2.storage.factory;

import by.it_academy.jd2.storage.HibernateManager;
import by.it_academy.jd2.storage.MessageStorage;
import by.it_academy.jd2.storage.SessionsStorage;
import by.it_academy.jd2.storage.UserStorage;
import by.it_academy.jd2.storage.api.IMessageStorage;
import by.it_academy.jd2.storage.api.ISessionsStorage;
import by.it_academy.jd2.storage.api.IUserStorage;

public class StorageFactory {


    public static final HibernateManager hibernateManager = new HibernateManager();

    public static final IUserStorage userStorage= new UserStorage(hibernateManager);
    public static final IMessageStorage messageStorage = new MessageStorage(hibernateManager);

    public static final ISessionsStorage sessionsStorage = new SessionsStorage();


    private StorageFactory() {
    }

    public static IUserStorage getUserStorage() {
        return userStorage;
    }

    public static IMessageStorage getMessageStorage() {
        return messageStorage;
    }

    public static ISessionsStorage getSessionsStorage(){
        return sessionsStorage;
    }

}
