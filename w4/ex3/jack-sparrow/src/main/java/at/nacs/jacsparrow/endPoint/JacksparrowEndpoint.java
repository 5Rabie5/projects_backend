package at.nacs.jacsparrow.endPoint;

import at.nacs.jacsparrow.JacksparrowClient;
import at.nacs.jacsparrow.domain.DeadMansChest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deadmanschest")
@RequiredArgsConstructor
public class JacksparrowEndpoint {

    private final JacksparrowClient client;

    @GetMapping
    public DeadMansChest getTheChest(){
        String dutchmanURL = client.getDeadManLocation();
        return client.getDeadMansChest(dutchmanURL);

    }
}
