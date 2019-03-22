package at.nacs.fengshuiapi.communication;

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


    public String get(LocalDate birthday) {
        String token = "e3Yx5c46bmc7Af741A3a83EddzbY0b1f8A62555Z";
        String url = "https://fengshui-api.com/api/v1/findChineseSignOfYear?token=" + token
                + "&year=" + birthday.getYear() + "&month=" + birthday.getMonthValue() + "&day=" + birthday.getDayOfMonth()+"&gender=0";
        return restTemplate.getForObject(url, String.class);
    }
}
