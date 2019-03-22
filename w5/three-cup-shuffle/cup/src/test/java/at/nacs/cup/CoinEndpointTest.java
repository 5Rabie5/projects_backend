package at.nacs.cup;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.mock.mockito.SpyBeans;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class CoinEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;

    @SpyBean
    Cup cup;
    String url = "/coin";

    @Test
    void get() {
        assertThat(restTemplate.getForObject(url,Boolean.class)).isFalse();
    }

    @Test
    void put() {
        restTemplate.put(url,true,Cup.class);
        assertThat(restTemplate.getForObject(url,Boolean.class)).isTrue();
    }

    @Test
    void delete() {
        restTemplate.delete(url,false,Cup.class);
        assertThat(restTemplate.getForObject(url,Boolean.class)).isFalse();
    }
}