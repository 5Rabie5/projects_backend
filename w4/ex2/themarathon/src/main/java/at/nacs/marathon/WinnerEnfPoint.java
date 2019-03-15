package at.nacs.marathon;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/winner")
@AllArgsConstructor
public class WinnerEnfPoint {

    private final RunnersList ruunersList;
    @GetMapping
    String  getwinner() {
        return  ruunersList.findAll().stream()
                .min(Comparator.comparing(Runner::getTime)).get().getName();

    }
}
