package at.nacs.ex2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component

public class Hello {
    public String getMsg(){
        return "Hello";
    }
}
