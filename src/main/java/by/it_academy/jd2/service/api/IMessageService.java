package by.it_academy.jd2.service.api;

import by.it_academy.jd2.dto.MessageDTO;
import by.it_academy.jd2.dto.ShowMessageDTO;

import java.util.List;

public interface IMessageService {
    void create(MessageDTO messageDTO);

    List<ShowMessageDTO> getIncomingMessages(String user);

    long getMessageCount();


}
