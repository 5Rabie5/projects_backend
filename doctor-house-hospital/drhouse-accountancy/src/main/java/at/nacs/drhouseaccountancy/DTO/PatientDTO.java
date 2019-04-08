package at.nacs.drhouseaccountancy.DTO;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class PatientDTO {

    private String id;
    private String name;
    private String symptoms;
    private String diagnosis;
    private String treatment;
    private String medicine;
}
