package by.it_academy.jd2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MessageInfoDTO {
    private String name;
    private String text;
    private LocalDateTime time;
}
