package by.it_academy.jd2.dto;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@Builder
public class MessageDTO {
    private String from;
    private String to;
    private String text;
    private LocalDateTime time;

}
