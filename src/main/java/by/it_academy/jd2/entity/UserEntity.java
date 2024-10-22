package by.it_academy.jd2.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    private String login;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private LocalDate birthday;

    @Column
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

}
