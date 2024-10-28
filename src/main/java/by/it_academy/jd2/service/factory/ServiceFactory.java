package by.it_academy.jd2.service.factory;

import by.it_academy.jd2.service.SessionService;
import by.it_academy.jd2.service.MessageService;
import by.it_academy.jd2.service.StatisticService;
import by.it_academy.jd2.service.UserService;
import by.it_academy.jd2.service.api.ISessionService;
import by.it_academy.jd2.service.api.IMessageService;
import by.it_academy.jd2.service.api.IStatisticService;
import by.it_academy.jd2.service.api.IUserService;
import by.it_academy.jd2.storage.factory.StorageFactory;

public class ServiceFactory {


    private static final IUserService userService = new UserService(
            StorageFactory.getUserStorage());

    private static final IMessageService messageService = new MessageService(
            StorageFactory.getMessageStorage(), userService);

    public static final ISessionService sessionService = new SessionService(
            StorageFactory.getSessionsStorage());

    private static final IStatisticService statisticService = new StatisticService(
            sessionService, userService, messageService);

    private ServiceFactory() {
    }

    public static IUserService getUserService() {
        return userService;
    }

    public static IMessageService getMessageService() {
        return messageService;
    }

    public static IStatisticService getStatisticService(){
        return statisticService;
    }

    public static ISessionService getSessionService(){
        return sessionService;
    }
}
