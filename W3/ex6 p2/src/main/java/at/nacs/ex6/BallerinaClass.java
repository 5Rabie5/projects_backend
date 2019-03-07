package at.nacs.ex6;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties("dancer")
@Getter
@Setter
public class BallerinaClass {
    private List<Ballerina> ballerina;
}
