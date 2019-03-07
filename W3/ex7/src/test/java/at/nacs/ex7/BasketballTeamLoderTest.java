package at.nacs.ex7;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BasketballTeamLoderTest {
    @Autowired
    BasketballTeamLoder basketballTeamLoder;

    @Test
    void getBasketballTeams() {
        System.out.println(basketballTeamLoder.getBasketballTeams().peek());
    }
}