package at.nacs.polo2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PoloEndPointTest {

    @Autowired
    TestRestTemplate restTemplate;

    String url = "http://localhost:9001/polo";

    @ParameterizedTest
    @CsvSource({
            "Marco, Polo",
            "Polo, What?",
            "What?, What?"
    })
    void post(String message, String expected) {
        String actual = restTemplate.postForObject(url, message, String.class);
        assertThat(actual).isEqualTo(expected);
    }
}