package at.nacs.marathon;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;

@Component
public class RunnersList {
    Set<Runner> ruunersList = new HashSet<>();

    public void add(Runner runner) {
        ruunersList.add(runner);
    }
   public List<Runner> findAll(){
        return new ArrayList<>(ruunersList);
    }
}
