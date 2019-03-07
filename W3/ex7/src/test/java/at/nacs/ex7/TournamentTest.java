package at.nacs.ex7;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TournamentTest {
@Autowired
Tournament tournament;
    @Test
    void playRound() {
        tournament.playRound();
    }
}