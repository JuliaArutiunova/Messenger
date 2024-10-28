package by.it_academy.jd2.service;


import by.it_academy.jd2.dto.StatisticDTO;
import by.it_academy.jd2.service.api.ISessionService;
import by.it_academy.jd2.service.api.IMessageService;
import by.it_academy.jd2.service.api.IStatisticService;
import by.it_academy.jd2.service.api.IUserService;


public class StatisticService implements IStatisticService {

    private final ISessionService sessionService;
    private final IUserService userService;
    private final IMessageService messageService;

    public StatisticService(ISessionService sessionService, IUserService userService, IMessageService messageService) {
        this.sessionService = sessionService;
        this.userService = userService;
        this.messageService = messageService;
    }

    @Override
    public StatisticDTO getStatistic() {
        return StatisticDTO.builder()
                .activeSessionsCount(sessionService.getActiveSessionsCount())
                .usersCount(userService.getUsersCount())
                .messagesCount(messageService.getMessageCount())
                .build();
    }
}
