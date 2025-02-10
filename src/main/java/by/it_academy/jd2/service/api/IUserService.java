package by.it_academy.jd2.service.api;

import by.it_academy.jd2.dto.RegistrationDTO;
import by.it_academy.jd2.dto.UserInfoDTO;
import by.it_academy.jd2.dto.UserNameDTO;
import by.it_academy.jd2.entity.UserEntity;

import java.util.List;

public interface IUserService {
    void create(RegistrationDTO registrationDTO);

    UserInfoDTO getUserInfo(String login, String password);

    long getUsersCount();

    UserEntity getByLogin(String login);

    List<UserNameDTO> getUserNames();

}
