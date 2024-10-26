package by.it_academy.jd2.service;

import by.it_academy.jd2.dto.MessageDTO;
import by.it_academy.jd2.dto.MessageInfoDTO;
import by.it_academy.jd2.entity.MessageEntity;
import by.it_academy.jd2.entity.UserEntity;
import by.it_academy.jd2.service.api.IMessageService;
import by.it_academy.jd2.service.api.IUserService;
import by.it_academy.jd2.service.util.Validator;
import by.it_academy.jd2.storage.api.IMessageStorage;

import java.util.ArrayList;
import java.util.List;

public class MessageService implements IMessageService {

    private IMessageStorage messageStorage;
    private IUserService userService;


    public MessageService(IMessageStorage messageStorage,
                          IUserService userService) {
        this.messageStorage = messageStorage;
        this.userService = userService;
    }

    @Override
    public void create(MessageDTO messageDTO) {

        Validator.validateMessage(messageDTO, userService);

        UserEntity fromUser = userService.getByLogin(messageDTO.getFrom());
        UserEntity toUser = userService.getByLogin(messageDTO.getTo());

        messageStorage.create(MessageEntity.builder()
                .setFromUser(fromUser)
                .setToUser(toUser)
                .setSendingTime(messageDTO.getTime())
                .setText(messageDTO.getText())
                .build());

    }

    @Override
    public List<MessageInfoDTO> getIncomingMessages(String user) {
        List<MessageInfoDTO> messageDTOS = new ArrayList<>();
        messageStorage.getMessagesToUser(user)
                .forEach(messageEntity -> messageDTOS.add(
                        MessageInfoDTO.builder()
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
