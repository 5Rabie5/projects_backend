package at.nacs.ex6;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ConfigurationProperties("sauna")
public class Sauna {
    private int availableSeats;
    private int temperature;


}
