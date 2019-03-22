package at.nacs.food;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/food")
@RequiredArgsConstructor
public class FoodEndpoint {
    private final OurStore ourStore;

    @GetMapping
    public List<String> get(){
        return ourStore.getFruits();
    }

    @PostMapping
    public String post(@RequestBody String fruit){
        ourStore.add(fruit);
        return fruit;
    }
}
