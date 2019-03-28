package at.nacs.drhouseadmission.communication;

import at.nacs.drhouseadmission.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class DiagnosesClient {

    private final RestTemplate restTemplate;

//    @Value("${diagnoses.server.url}")
//    private String url;

    public Patient forward(Patient patient) {
        restTemplate.postForObject("http://localhost:9002/patients", patient, Patient.class);
        return patient;
    }
}
