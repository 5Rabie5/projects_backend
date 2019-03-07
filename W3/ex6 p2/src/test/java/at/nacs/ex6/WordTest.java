package at.nacs.ex6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WordTest {

    @Autowired
    Word word;
    @Test
    void getText() {
        Assertions.assertEquals("fantastic",word.getText());
    }
}