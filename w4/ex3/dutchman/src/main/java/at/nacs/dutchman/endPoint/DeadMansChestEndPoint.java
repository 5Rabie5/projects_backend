package at.nacs.dutchman.endPoint;

import at.nacs.dutchman.domain.DeadMansChest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deadmanschest")
@AllArgsConstructor
public class DeadMansChestEndPoint {
    private final DeadMansChest deadMansChest;

    @GetMapping
    DeadMansChest get() {
        return deadMansChest;
    }
}
