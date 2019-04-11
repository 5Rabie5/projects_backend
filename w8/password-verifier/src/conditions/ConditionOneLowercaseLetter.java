package conditions;

import java.util.stream.Stream;

public class ConditionOneLowercaseLetter implements Verification {

    @Override
    public Boolean condition(String password) {
      return password.chars().anyMatch(Character::isLowerCase);
//        return Stream.of(password.split(""))
//                //.map(e -> e.split(""))
//                //.flatMap(Stream::of)
//                .map(e -> e.charAt(0))
//                .anyMatch(Character::isLowerCase);
    }
}
