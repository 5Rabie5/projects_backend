package at.nacs.marco;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import static org.assertj.core.api.Assertions.assertThat;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class MarcoClientTest {
    @Autowired
    MarcoClient marcoClient;
    @Autowired
    RestTemplate restTemplate;

    @Test
    void sayMsg() {
//        String acual = marcoClint.sayMsg();
//        String expected = "messge : Marco sent";
//        Assertions.assertThat(acual).isEqualTo(expected);
    }
}