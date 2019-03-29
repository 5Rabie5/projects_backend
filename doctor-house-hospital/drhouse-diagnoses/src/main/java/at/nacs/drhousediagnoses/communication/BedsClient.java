package at.nacs.drhousediagnoses.communication;

import at.nacs.drhousediagnoses.domain.Patient;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class BedsClient {

   @Value("${beds.server.url}")
    private String url;

    private final RestTemplate restTemplate;

    public Patient forward(Patient patient) {
        restTemplate.postForObject(url,patient,Patient.class);
        return patient;
    }
}
