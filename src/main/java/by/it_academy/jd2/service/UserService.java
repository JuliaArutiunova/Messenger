package by.it_academy.jd2.service;


import by.it_academy.jd2.dto.RegistrationDTO;
import by.it_academy.jd2.dto.UserDTO;
import by.it_academy.jd2.entity.UserEntity;
import by.it_academy.jd2.entity.UserRole;
import by.it_academy.jd2.exception.RegistrationException;
import by.it_academy.jd2.service.api.IUserService;
import by.it_academy.jd2.service.validation.FormValidator;
import by.it_academy.jd2.service.validation.api.IFormValidator;
import by.it_academy.jd2.storage.api.IUserStorage;


import java.time.LocalDateTime;
import java.util.List;

public class UserService implements IUserService {

    private final IUserStorage userStorage;

    private final IFormValidator formValidator;

    public UserService(IUserStorage userStorage) {
        this.userStorage = userStorage;
        this.formValidator = new FormValidator(this);

    }


    @Override
    public void create(RegistrationDTO registrationDTO) {

        List<Throwable> errors = formValidator.validateRegistration(registrationDTO);

        if (!errors.isEmpty()) {
            throw new RegistrationException(errors);
        }

        userStorage.create(UserEntity.builder()
                .name(registrationDTO.getUserName())
                .birthday(registrationDTO.getBirthDate())
                .login(registrationDTO.getLogin())
                .password(registrationDTO.getPassword())
                .registrationDate(LocalDateTime.now())
                .role(UserRole.USER)
                .build());

    }

    @Override
    public UserDTO validateUser(String login, String password) {

        UserEntity user = formValidator.validateUser(login, password);

        return UserDTO.builder()
                .name(user.getName())
                .login(user.getLogin())
                .role(user.getRole())
                .build();
    }

    @Override
    public boolean isExist(String login) {
        return userStorage.isExistLogin(login);
    }

    @Override
    public UserEntity getUser(String login) {
        return userStorage.getUser(login);
    }

    @Override
    public long getUsersCount() {
        return userStorage.getUsersCount();
    }


}
