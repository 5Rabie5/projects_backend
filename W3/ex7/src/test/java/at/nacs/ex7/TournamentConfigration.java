package at.nacs.ex7;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TournamentConfigration {

    @Bean
    ApplicationRunner applicationRunner(Tournament tournament){
        return args -> {
          tournament.playRound();
        };

    }
}
