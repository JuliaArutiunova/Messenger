package by.it_academy.jd2.service.factory;

import by.it_academy.jd2.service.MessageService;
import by.it_academy.jd2.service.UserService;
import by.it_academy.jd2.service.api.IMessageService;
import by.it_academy.jd2.service.api.IUserService;
import by.it_academy.jd2.storage.factory.StorageFactory;

public class ServiceFactory {


    private static final IUserService userService = new UserService(
            StorageFactory.getUserStorage());

    private static final IMessageService messageService = new MessageService(
            StorageFactory.getMessageStorage(), userService);


    private ServiceFactory() {
    }

    public static IUserService getUserService(){
        return userService;
    }
    public static IMessageService getMessageService(){
        return messageService;
    }
}
