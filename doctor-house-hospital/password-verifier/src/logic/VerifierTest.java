package logic;

import conditions.Conditions;
import conditions.Verification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VerifierTest {
    List<Verification> conditions = Conditions.asList();
    Verifier verifier = new Verifier();

    @Test
    void verifyPart1True() {

        String password = "3tWds?te3";
        assertTrue(verifier.verifyPart1(password));
    }

    @Test
    void verifyPart1false() {

        String password = "3twds?te3";
        assertFalse(verifier.verifyPart1(password));
    }

    @Test
    void verifyPart2True() {
        String password = "3twds?te3";
        assertTrue(verifier.verifyPart2(password));
    }

    @Test
    void verifyPart2False() {
        String password = "wds?te";
        assertFalse(verifier.verifyPart2(password));
    }

    @Test
    void verifyPart3True() {
        String password = "3twds?te3";
        assertTrue(verifier.verifyPart3(password));
    }

    @Test
    void verifyPart3False() {
        String password = "AS34SD?SSSSS3";
        assertFalse(verifier.verifyPart3(password));
    }
}