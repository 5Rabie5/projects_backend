package at.nacs.ex6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BallerinaClassTest {
    @Autowired
    BallerinaClass ballerinaClass;

    @Test
    void getBallerina() {
        System.out.println(ballerinaClass.getBallerina().get(0));
        Assertions.assertEquals(3, ballerinaClass.getBallerina().size());
    }

    @ParameterizedTest
    @CsvSource({"0, ha, 5",
            "1, mimi, 4",
            "2, niee, 1"})
    void getBallerinaTest2(int Index,String name, Integer performance) {

        Assertions.assertEquals(name, ballerinaClass.getBallerina().get(Index).getName());
        Assertions.assertEquals(performance, ballerinaClass.getBallerina().get(Index).getPerformance());
    }
}
