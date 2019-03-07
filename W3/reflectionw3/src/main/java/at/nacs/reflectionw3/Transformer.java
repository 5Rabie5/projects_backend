package at.nacs.reflectionw3;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

@Component
@ConfigurationProperties("handshake")
public class Transformer {
    @Getter
    @Setter
    private Map<Integer, String> moves;

    public List<String> transform(Integer digits) {
        return Stream.of(digits)
                .map(Object::toString)
                .map(e -> e.split(""))
                .flatMap(Stream::of)
                .map(this::findMove)
                .filter(Objects::nonNull)
                .collect(toList());
    }

    private String findMove(String digit) {
        return moves.get(Integer.valueOf(digit));
    }
}
