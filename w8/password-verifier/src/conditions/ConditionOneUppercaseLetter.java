package conditions;

import java.util.stream.Stream;

public class ConditionOneUppercaseLetter implements Verification {

    @Override
    public Boolean condition(String password) {
        return Stream.of(password)
                .map(e -> e.split(""))
                .flatMap(Stream::of)
                .map(e -> e.charAt(0))
                .anyMatch(Character::isUpperCase);
    }
}
