package at.nacs.fengshuiapi.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Data
public class Profile {

    private String status;
    private String result;
}
