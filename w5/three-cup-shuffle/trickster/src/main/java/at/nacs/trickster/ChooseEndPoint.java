package at.nacs.trickster;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/choose")
@RequiredArgsConstructor
public class ChooseEndPoint {
    private final ChooseClient chooseClient;
    @GetMapping("/{number}")
    public String get(@PathVariable Integer number){
      return chooseClient.check(number);
    }
}
