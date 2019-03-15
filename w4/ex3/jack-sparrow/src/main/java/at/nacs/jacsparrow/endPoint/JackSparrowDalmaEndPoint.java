package at.nacs.jacsparrow.endPoint;

import at.nacs.jacsparrow.JacksparrowClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class JackSparrowDalmaEndPoint {

    private final JacksparrowClient jacksparrowClient;

    @GetMapping("/dutchman")
    String get() {
        return jacksparrowClient.getDeadManLocation();
    }

}
