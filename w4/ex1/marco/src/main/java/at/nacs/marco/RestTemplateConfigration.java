package at.nacs.marco;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfigration {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
