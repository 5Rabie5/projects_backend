package at.nacs.fengshuiapi.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Getter
@Setter
public class Profile {

    private LocalDate birthday;
    private String sign;
}
