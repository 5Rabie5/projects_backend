package at.nacs.polo2;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/polo")
public class PoloEndPoint {

    @PostMapping
    String post(@RequestBody String message) {
        if (message.equals("Marco")) {
            return "Polo";
        }
        return "What?";
    }

}

