package by.it_academy.jd2.service.validation;

import by.it_academy.jd2.dto.MessageDTO;
import by.it_academy.jd2.dto.RegistrationDTO;
import by.it_academy.jd2.entity.UserEntity;
import by.it_academy.jd2.service.api.IUserService;
import by.it_academy.jd2.service.validation.api.IFormValidator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FormValidator implements IFormValidator {
    private final IUserService userService;

    private final LocalDate minimumBirthDate = LocalDate.parse("1900-01-01");


    public FormValidator(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public List<Throwable> validateRegistration(RegistrationDTO registrationDTO) {
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
        } else if (userService.isExist(registrationDTO.getLogin())) {
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

    @Override
    public void validateMessage(MessageDTO dto) {
        if (dto.getTo().isBlank()) {
            throw new IllegalArgumentException("Получатель не введен");
        } else if (!userService.isExist(dto.getTo())) {
            throw new IllegalArgumentException("Получателя не существует");
        }

        if (dto.getText().isBlank()) {
            throw new IllegalArgumentException("Пустое сообщение");
        }
    }

    @Override
    public UserEntity validateUser(String login, String password) {
        if (!userService.isExist(login)) {
            throw new IllegalArgumentException("Пользователя с таким логином не существует");
        }
        UserEntity user = userService.getUser(login);

        if (!user.getPassword().equals(password)) {
            throw new IllegalArgumentException("Неверный пароль");
        }

        return user;
    }

}
