package conditions;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Conditions {

    public static List<Verification> asList() {

        return Stream.of(
                new ConditionLargerThan8(), new ConditionNotNull(),
                new ConditionOneUppercaseLetter(), new ConditionOneLowercaseLetter(),
                new ConditionOneNumber())
                .collect(Collectors.toList());
    }
}
