package by.it_academy.jd2.storage.factory;

import by.it_academy.jd2.storage.HibernateManager;
import by.it_academy.jd2.storage.MessageStorage;
import by.it_academy.jd2.storage.UserStorage;
import by.it_academy.jd2.storage.api.IMessageStorage;
import by.it_academy.jd2.storage.api.IUserStorage;

public class StorageFactory {


    public static final HibernateManager hibernateManager = new HibernateManager();

    public static final IUserStorage userStorage= new UserStorage(hibernateManager);
    public static final IMessageStorage messageStorage = new MessageStorage(hibernateManager);


    private StorageFactory() {
    }

    public static IUserStorage getUserStorageSQL() {
        return userStorage;
    }

    public static IMessageStorage getMessageStorageSQL() {
        return messageStorage;
    }

}
