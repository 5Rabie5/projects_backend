package at.nacs.morse.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Getter
@Setter
@ConfigurationProperties("letter")
public class MorseAlphabet {

    private Map<String, String> morsealphabet;
}
