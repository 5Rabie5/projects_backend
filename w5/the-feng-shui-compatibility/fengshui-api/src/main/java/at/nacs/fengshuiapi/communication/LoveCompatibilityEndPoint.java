package at.nacs.fengshuiapi.communication;


import at.nacs.fengshuiapi.domain.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/compatibility/love")
@RequiredArgsConstructor
public class LoveCompatibilityEndPoint {

    private final SignClient signClient;

    @GetMapping("/{birthday1}/{birthday2}")
    public String getloveCompatibility(@PathVariable LocalDate birthday1, @PathVariable LocalDate birthday2) {
        return signClient.getLoveCompatibility(birthday1, birthday2);
    }
}
