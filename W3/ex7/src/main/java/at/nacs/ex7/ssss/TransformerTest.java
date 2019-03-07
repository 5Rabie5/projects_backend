package at.nacs.ex7.ssss;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
public class TransformerTest {
    @Autowired
    Transformer moves;

   @ParameterizedTest
   @CsvSource({"2, thumb touches back",
           "3, little finger grab",
           "5, tickles over palm",
           "6, bro knock",
           "9, thousand knuckles"
   })
    public void getMoves(Integer digit,String move) {
        Assertions.assertTrue(moves.getMoves().keySet().contains(digit));
        Assertions.assertTrue(moves.getMoves().values().contains(move));
    }


    @Test
    public void transform() {

        List<String> result = moves.transform(195);
        List<String> expected = Arrays.asList("thousand knuckles","tickles over palm");

       Assertions.assertEquals(expected,result);
    }

}
