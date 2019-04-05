package at.nacs.trickster;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class ChooseClient {
    private final RestTemplate restTemplate;
/*
*  @ PARM : NUMBER type Integer
*  return : String of anmem
* */
    public String check(Integer number) {
        String url = "http://localhost:900" + number + "/coin";
        Boolean respond = restTemplate.getForObject(url,Boolean.class);
        if (respond){
           return  "YOU WIN";
        }
        return  "TRY ONE MORE TIME";
    }
}
