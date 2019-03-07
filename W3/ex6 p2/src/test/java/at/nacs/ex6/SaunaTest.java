package at.nacs.ex6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SaunaTest {
    @Autowired
    Sauna sauna;

    @Test
    void getSauna() {
        Assertions.assertEquals(5,sauna.getAvailableSeats());
    }
}