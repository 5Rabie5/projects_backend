package at.nacs.morse;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class MorseEndPointTest {
@Autowired
    TestRestTemplate restTemplate;
private String morseEndPoint="/morse";
    @Test
    void post() {
        Assertions.assertThat(restTemplate.postForObject(morseEndPoint,"A",String.class)).isEqualTo(".-");
    }
}