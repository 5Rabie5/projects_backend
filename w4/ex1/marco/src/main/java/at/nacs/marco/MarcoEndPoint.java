package at.nacs.marco;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/say")
@RequiredArgsConstructor
public class MarcoEndPoint {

    private final MarcoClient marcoClient;

    @GetMapping("/{message}")
    public String getMsg(@PathVariable String message) {
        return marcoClient.getAnswer(message);
    }
}
