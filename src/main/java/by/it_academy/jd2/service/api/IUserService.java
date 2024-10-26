package by.it_academy.jd2.service.api;

import by.it_academy.jd2.dto.RegistrationDTO;
import by.it_academy.jd2.dto.UserInfoDTO;
import by.it_academy.jd2.entity.UserEntity;

public interface IUserService {
    void create(RegistrationDTO registrationDTO);

    UserInfoDTO getUserInfo(String login, String password);

    long getUsersCount();

    UserEntity getByLogin(String login);

}
