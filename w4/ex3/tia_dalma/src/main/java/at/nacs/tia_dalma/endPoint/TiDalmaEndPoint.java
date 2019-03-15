package at.nacs.tia_dalma.endPoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dutchman")
public class TiDalmaEndPoint {

    @GetMapping
    String get(){
        return "http://localhost:9002/deadmanschest";
    }
}
