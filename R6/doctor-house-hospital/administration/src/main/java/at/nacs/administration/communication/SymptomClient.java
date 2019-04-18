package at.nacs.administration.communication;

import at.nacs.administration.view.model.Symptom;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class SymptomClient {
  private final RestTemplate restTemplate;
  @Value("${symptoms.server.url}")
  private String url;

  public Symptom[] getAll() {
    return restTemplate.getForObject(url, Symptom[].class);
  }
}

