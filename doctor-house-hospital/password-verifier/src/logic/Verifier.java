package logic;

import conditions.Conditions;
import conditions.Verification;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.stream.Stream;

public class Verifier {

    private List<Verification> conditions = Conditions.asList();

    Boolean verifyPart1(String password) {

        return conditions.stream()
                .allMatch(e -> e.condition(password));
    }

    Boolean verifyPart2(String password) {

        long count = conditions.stream()
                .filter(e -> e.condition(password))
                .count();
        return count >= 3;
    }

    Boolean verifyPart3(String password) {

        return verifyPart2(password) &&
                conditions.get(3).condition(password);
    }
}
