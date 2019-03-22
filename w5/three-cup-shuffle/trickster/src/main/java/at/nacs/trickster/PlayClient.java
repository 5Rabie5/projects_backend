package at.nacs.trickster;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PlayClient {
    private final RestTemplate restTemplate;

    List<String> ports = Arrays.asList("9001", "9002", "9003");

    public void removCoins() {
        String url = "http://localhost:" + randomPort() + "/coin";
        ports.stream()
                .map(e -> "http://localhost:" + e + "/coin")
                .forEach(e -> restTemplate.delete(e, false, Cup.class));
    }

    public void putCoin() {
        String url = "http://localhost:" + randomPort() + "/coin";
        restTemplate.put(url, true, Cup.class);
    }


    private String randomPort() {
        Collections.shuffle(ports);
        return ports.get(0);
    }
}
