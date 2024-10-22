package by.it_academy.jd2.service.validation.api;

import by.it_academy.jd2.dto.MessageDTO;
import by.it_academy.jd2.dto.RegistrationDTO;
import by.it_academy.jd2.entity.UserEntity;

import java.util.List;

public interface IFormValidator {

    List<Throwable> validateRegistration(RegistrationDTO registrationDTO);
    void validateMessage(MessageDTO dto);

    UserEntity validateUser(String login, String password);
}
