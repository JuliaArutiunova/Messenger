package by.it_academy.jd2.dto;

import by.it_academy.jd2.entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDTO {
    private String login;
    private String name;
    private UserRole role;

}
