package at.nacs.ex2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AmazingHelloWorld {

    private final Hello hello;
    private final World word;
    public String say(){
        return hello.getMsg()+" "+word.getMsg();
    }
}
