package at.nacs.ex6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.DayOfWeek;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DaysTest {
    @Autowired
    Days days;

    @Test
    void getDayCountTest() {
        Assertions.assertEquals(7, days.getDays().size());
    }
    @ParameterizedTest
    @ValueSource(strings = {"sunday", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday"})
    void testIndividualDays(String name) {
        List<DayOfWeek> actual = days.getDays();
        assertTrue(actual.contains(DayOfWeek.valueOf(name.toUpperCase())));
    }
}