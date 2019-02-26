package at.nacs.ex2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
@RequiredArgsConstructor
@Component
public class World {
    public String getMsg(){
        return "World";
            }

}
