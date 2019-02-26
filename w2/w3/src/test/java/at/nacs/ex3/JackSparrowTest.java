package at.nacs.ex3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class JackSparrowTest {

    @Autowired
    JackSparrow jackSparrow;

    @Test
    void findCursedCoin() {
        String message = jackSparrow.findCursedCoin();
        Assertions.assertEquals("I found the CursedCoin!", message);
    }
}