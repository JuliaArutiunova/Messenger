package by.it_academy.jd2.service.util;

import by.it_academy.jd2.dto.MessageDTO;
import by.it_academy.jd2.dto.RegistrationDTO;
import by.it_academy.jd2.entity.UserEntity;
import by.it_academy.jd2.service.api.IUserService;
import by.it_academy.jd2.storage.api.IUserStorage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Validator {


    private static final LocalDate minimumBirthDate = LocalDate.parse("1900-01-01");




    public static List<Throwable> validateRegistration(RegistrationDTO registrationDTO, IUserStorage userStorage) {
        List<Throwable> errors = new ArrayList<>();

        if (registrationDTO.getUserName().isBlank()) {
            errors.add(new IllegalArgumentException("Имя пользователя не введено"));
        }

        LocalDate birthDay = registrationDTO.getBirthDate();
        if (birthDay.isBefore(minimumBirthDate) ||
                birthDay.isAfter(LocalDate.now())) {
            errors.add(new IllegalArgumentException("Некорректная дата рождения"));
        }

        if (registrationDTO.getLogin().isBlank()) {
            errors.add(new IllegalArgumentException("Логин не введен"));
        } else if (userStorage.getUser(registrationDTO.getLogin()) != null) {
            errors.add(new IllegalArgumentException("Такой логин уже существует, придумайте другой"));
        }

        if (registrationDTO.getPassword().isBlank()) {
            errors.add(new IllegalArgumentException("Пароль не введен"));
        } else if (registrationDTO.getConfirmPsw().isBlank()) {
            errors.add(new IllegalArgumentException("Не введено подтверждение пароля"));
        } else if (!registrationDTO.getPassword().equals(registrationDTO.getConfirmPsw())) {
            errors.add(new IllegalArgumentException("Пароль не подтверждён"));
        }

        return errors;
    }


    public static void validateMessage(MessageDTO dto, IUserService userService) {
        if(userService.getByLogin(dto.getFrom()) == null){
            throw new IllegalArgumentException("Отправителя не существует");
        } else if (dto.getTo().isBlank()) {
            throw new IllegalArgumentException("Получатель не введен");
        } else if (userService.getByLogin(dto.getTo()) == null) {
            throw new IllegalArgumentException("Получателя не существует");
        }

        if (dto.getText().isBlank()) {
            throw new IllegalArgumentException("Пустое сообщение");
        }
    }


    public static UserEntity validateUser(String login, String password, IUserStorage userStorage) {
        if (login.isBlank()) {
            throw new IllegalArgumentException("Логин не введен");
        } else if (userStorage.getUser(login) == null) {
            throw new IllegalArgumentException("Пользователя с таким логином не существует");
        }

        if (password.isBlank()) {
            throw new IllegalArgumentException("Пароль не введен");
        }

        UserEntity user = userStorage.getUser(login);

        if (!user.getPassword().equals(password)) {
            throw new IllegalArgumentException("Неверный пароль");
        }

        return user;
    }

}
