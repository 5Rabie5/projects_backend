package at.nacs.ex7;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
@ConfigurationProperties("team")
@Getter
@Setter
public class BasketballTeamLoder {
    private LinkedList<BasketballTeam> basketballTeams;
}
