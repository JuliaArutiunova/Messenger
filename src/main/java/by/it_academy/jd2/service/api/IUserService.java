package by.it_academy.jd2.service.api;

import by.it_academy.jd2.dto.RegistrationDTO;
import by.it_academy.jd2.dto.UserDTO;
import by.it_academy.jd2.entity.UserEntity;

public interface IUserService {
    void create(RegistrationDTO registrationDTO);

    UserDTO getUserInfo(String login, String password);

    long getUsersCount();

    UserEntity getByLogin(String login);

}
