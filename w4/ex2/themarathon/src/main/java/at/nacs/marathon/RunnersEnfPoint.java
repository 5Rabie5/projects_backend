package at.nacs.marathon;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/runners")
@AllArgsConstructor
public class RunnersEnfPoint {
    private final RunnersList ruunersList;

    @GetMapping
    List<Runner> getrunnres() {
        return ruunersList.findAll();
    }

    @PostMapping
    Runner saveRunner(@RequestBody Runner runner) {
        ruunersList.add(runner);
        return runner;
    }

}
