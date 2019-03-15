package at.nacs.encoder.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/encode")
@RequiredArgsConstructor
public class EncoderEndPoint {

    private final EncoderClient encoderClient;

    @PostMapping
    public String post(@RequestBody String message) {
        return encoderClient.getEncodedMessage(message);
    }

}
