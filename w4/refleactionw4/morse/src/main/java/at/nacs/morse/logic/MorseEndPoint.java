package at.nacs.morse.logic;

import at.nacs.morse.logic.Encoder;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/morse")
@RequiredArgsConstructor
public class MorseEndPoint {

    private final Encoder encoder;

    @PostMapping
    String post(@RequestBody String letter) {
        return encoder.encode(letter);
    }
}
