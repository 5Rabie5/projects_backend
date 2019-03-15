package at.nacs.morse.logic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = NONE)
class EncoderTest {
@Autowired
Encoder encoder;
    @Test
    void encodeFound() {
        Assertions.assertThat(encoder.encode("T")).isEqualTo("-");
    }
    @Test
    void encodeNotFound() {
        Assertions.assertThat(encoder.encode("?")).isNull();
    }
}