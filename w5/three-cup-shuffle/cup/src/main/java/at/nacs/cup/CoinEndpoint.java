package at.nacs.cup;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coin")
@RequiredArgsConstructor
public class CoinEndpoint {

    private final Cup cup;

    @GetMapping
    public Boolean get() {
        return cup.isCoin();
    }

    @PutMapping
    public void put() {
        cup.setCoin(true);
    }

    @DeleteMapping
    public void delete() {
        cup.setCoin(false);
    }

}
