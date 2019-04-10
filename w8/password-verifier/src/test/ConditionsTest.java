package test;

import conditions.Conditions;
import conditions.Verification;
import logic.Verifier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class ConditionsTest {
    Verifier verifier = new Verifier();
    private List<Verification> conditions = Conditions.asList();


    @ParameterizedTest
    @CsvSource({
            "ConditionLargerThan8,0,123456789,1234567",
            "ConditionNotNull,1,eeww32ddd,",
            "ConditionOneUppercaseLetter,2,Abcdefg,abcdefg",
            "ConditionOneLowercaseLetter,3,aBCDEFG,ABCDEFG",
            "ConditionOneNumber,4,2aaaaaaaaa,aaaaaaaaaa"
    })
    void verifySucceeds(String condtionName, int index, String correctPassword, String wrongPassword) {

        Predicate<String> verifyCorrectPassword = password -> conditions.get(index).condition(correctPassword);
        Assertions.assertTrue(verifyCorrectPassword.test(correctPassword));

        Predicate<String> verifyWrongPassword = password -> conditions.get(index).condition(wrongPassword);
        Assertions.assertFalse(verifyWrongPassword.test(wrongPassword));
    }
}