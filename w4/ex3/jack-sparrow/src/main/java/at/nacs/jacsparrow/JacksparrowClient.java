package at.nacs.jacsparrow;

import at.nacs.jacsparrow.domain.DeadMansChest;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
//@Component
//@NoArgsConstructor
//@AllArgsConstructor
public class JacksparrowClient {

    private final RestTemplate restTemplate;

    @Value("${jacksparrowclient.server.url}")
    private String url;

    public String getDeadManLocation() {
        return restTemplate.getForObject(url, String.class);
    }
//    public String getDeadMansChest() {
//        System.out.println("I got dutchmans url, here it is: " + dutchmanUrl );
//        return restTemplate.getForObject("http://localhost:9002/deadmanschest", String.class);
//    }

    public DeadMansChest getDeadMansChest(String dutchmanURL) {
    System.out.println("I got dutchmans url, here it is: " + dutchmanURL );
        return restTemplate.getForObject(dutchmanURL, DeadMansChest.class);
    }
}
