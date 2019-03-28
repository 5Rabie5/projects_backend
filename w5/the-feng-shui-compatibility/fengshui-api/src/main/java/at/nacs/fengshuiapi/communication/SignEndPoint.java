package at.nacs.fengshuiapi.communication;

import at.nacs.fengshuiapi.domain.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/sign")
@RequiredArgsConstructor
public class SignEndPoint {
private final SignClient signClient;

@GetMapping("/{birthday}")
    public Profile get(@PathVariable LocalDate birthday){
    return signClient.getSign(birthday);
}
}
