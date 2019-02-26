package at.nacs.ex2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AmazingHelloWorldTest {

    @Autowired
    AmazingHelloWorld amazingHelloWorld;

    @Test
    void say() {
        String result = amazingHelloWorld.say();

        String expected = "Hello World";
        Assertions.assertEquals(expected, result);
    }
}