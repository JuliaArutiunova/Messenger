package by.it_academy.jd2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class StatisticDTO {

    private long activeSessionsCount;
    private long usersCount;
    private long messagesCount;

}
