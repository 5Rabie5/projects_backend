package conditions;

import java.util.stream.Stream;

public class ConditionOneNumber implements Verification {

    @Override
    public Boolean condition(String password) {
        return Stream.of(password)
                .map(e -> e.split(""))
                .flatMap(Stream::of)
                .anyMatch(e -> e.matches("\\d"));
    }

    public ConditionOneNumber() {
    }
}
