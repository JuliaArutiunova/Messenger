package by.it_academy.jd2.service;


import by.it_academy.jd2.dto.RegistrationDTO;
import by.it_academy.jd2.dto.UserDTO;
import by.it_academy.jd2.entity.UserEntity;
import by.it_academy.jd2.entity.UserRole;
import by.it_academy.jd2.exception.RegistrationException;
import by.it_academy.jd2.service.api.IUserService;
import by.it_academy.jd2.service.util.Validator;
import by.it_academy.jd2.storage.api.IUserStorage;


import java.time.LocalDateTime;
import java.util.List;

public class UserService implements IUserService {

    private final IUserStorage userStorage;


    public UserService(IUserStorage userStorage) {
        this.userStorage = userStorage;


    }


    @Override
    public void create(RegistrationDTO registrationDTO) {

        List<Throwable> errors = Validator.validateRegistration(registrationDTO, userStorage);

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

        UserEntity user = Validator.validateUser(login, password, userStorage);

        return UserDTO.builder()
                .name(user.getName())
                .login(user.getLogin())
                .role(user.getRole())
                .build();
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
