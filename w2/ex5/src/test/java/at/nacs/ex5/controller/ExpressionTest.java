package at.nacs.ex5.controller;

import at.nacs.ex5.model.Expression;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class ExpressionTest {

    @Autowired
    Expressions expressions;

    @Test
    void fromSucceeds() {
        String input = "1.62 @ 3.14";

        Expression expression = expressions.from(input);

        assertEquals(1.62, expression.getNumber1());
        assertEquals("@", expression.getSymbol());
        assertEquals(3.14, expression.getNumber2());
    }

    @ParameterizedTest
    @CsvSource({
            "1",
            "1 @",
            "1 2 @ 3"
    })
    void fromFailsBecauseOfWrongNumberOfElements(String input) {
        assertThrows(IllegalArgumentException.class, () -> expressions.from(input));
    }
}