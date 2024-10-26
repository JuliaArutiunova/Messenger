package by.it_academy.jd2.service.api;

import by.it_academy.jd2.dto.MessageDTO;
import by.it_academy.jd2.dto.MessageInfoDTO;

import java.util.List;

public interface IMessageService {
    void create(MessageDTO messageDTO);

    List<MessageInfoDTO> getIncomingMessages(String user);

    long getMessageCount();


}
