package by.it_academy.jd2.service;

import by.it_academy.jd2.dto.MessageDTO;
import by.it_academy.jd2.dto.ShowMessageDTO;
import by.it_academy.jd2.entity.MessageEntity;
import by.it_academy.jd2.entity.UserEntity;
import by.it_academy.jd2.service.api.IMessageService;
import by.it_academy.jd2.service.api.IUserService;
import by.it_academy.jd2.service.validation.FormValidator;
import by.it_academy.jd2.service.validation.api.IFormValidator;
import by.it_academy.jd2.storage.api.IMessageStorage;

import java.util.ArrayList;
import java.util.List;

public class MessageService implements IMessageService {

    private IMessageStorage messageStorage;
    private IUserService userService;
    private IFormValidator formValidator;

    public MessageService(IMessageStorage messageStorage,
                          IUserService userService) {
        this.messageStorage = messageStorage;
        this.userService = userService;
        this.formValidator = new FormValidator(userService);
    }

    @Override
    public void create(MessageDTO messageDTO) {

        formValidator.validateMessage(messageDTO);

        UserEntity fromUser = userService.getUser(messageDTO.getFrom());
        UserEntity toUser = userService.getUser(messageDTO.getTo());

        messageStorage.create(MessageEntity.builder()
                .setFromUser(fromUser)
                .setToUser(toUser)
                .setSendingTime(messageDTO.getTime())
                .setText(messageDTO.getText())
                .build());

    }

    @Override
    public List<ShowMessageDTO> getIncomingMessages(String user) {
        List<ShowMessageDTO> messageDTOS = new ArrayList<>();
        messageStorage.getMessagesToUser(user)
                .forEach(messageEntity -> messageDTOS.add(
                        ShowMessageDTO.builder()
                                .name(messageEntity.getFromUser().getName())
                                .text(messageEntity.getText())
                                .time(messageEntity.getSendingTime())
                                .build()));
        return messageDTOS;
    }



    @Override
    public long getMessageCount() {
        return messageStorage.getMessageCount();
    }

}
