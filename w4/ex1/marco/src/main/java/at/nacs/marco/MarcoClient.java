package at.nacs.marco;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class MarcoClient {

    private final RestTemplate restTemplate;

    @Value("${polo.server.url}")
    private String url;

    public String getAnswer(String message) {

       String answerFromPolo =restTemplate.postForObject(url, message, String.class);
        return answerFromPolo;
    }
}
