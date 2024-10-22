package by.it_academy.jd2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class RegistrationDTO {
    private String userName;
    private LocalDate birthDate;
    private String login;
    private String password;
    private String confirmPsw;

}
