package at.nacs.ex6;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.util.List;

@Component

public class Days {
    @Getter
    @Value("${days.day}")
    private List<DayOfWeek> days;
}
