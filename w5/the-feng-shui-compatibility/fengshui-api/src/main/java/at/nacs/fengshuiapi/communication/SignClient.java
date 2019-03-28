package at.nacs.fengshuiapi.communication;

import at.nacs.fengshuiapi.domain.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
@RestController
@RequiredArgsConstructor
public class SignClient {

    private final RestTemplate restTemplate;
    String token = "e3Yx5c46bmc7Af741A3a83EddzbY0b1f8A62555Z";

    public Profile getSign(LocalDate birthday) {

        String geeting = "findChineseSignOfYear";
        String url = "https://fengshui-api.com/api/v1/" + geeting + "?token=" + token
                + "&year=" + birthday.getYear() + "&month=" + birthday.getMonthValue() +
                "&day=" + birthday.getDayOfMonth();
        return restTemplate.getForObject(url, Profile.class);
    }


    public String getLoveCompatibility(LocalDate birthday1, LocalDate birthday2) {
        String geeting = "findBusinessCompatibility";
        String url = "https://fengshui-api.com/api/v1/" + geeting + "?token=" + token
                + "&year=" + birthday1.getYear() + "&month=" + birthday1.getMonthValue() +
                "&day=" + birthday1.getDayOfMonth()
                + "/&year=" + birthday2.getYear() + "&month=" + birthday2.getMonthValue() +
                "&day=" + birthday2.getDayOfMonth();
        return restTemplate.getForObject(url, String.class);
    }
}
