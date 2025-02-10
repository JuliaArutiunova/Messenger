package by.it_academy.jd2.storage.api;


import by.it_academy.jd2.dto.UserNameDTO;
import by.it_academy.jd2.entity.UserEntity;

import java.util.List;

public interface IUserStorage {
    void create(UserEntity user);

    UserEntity getUser(String login);

    long getUsersCount();

    List<UserNameDTO> getUserNames();

}
