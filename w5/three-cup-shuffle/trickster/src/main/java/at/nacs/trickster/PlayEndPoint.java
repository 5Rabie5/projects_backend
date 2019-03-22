package at.nacs.trickster;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/play")
@RequiredArgsConstructor
public class PlayEndPoint {
    private final PlayClient playClient;

    @GetMapping
    public String get(){
        playClient.removCoins();
        playClient.putCoin();
        return "The game has started!";
    }

}
