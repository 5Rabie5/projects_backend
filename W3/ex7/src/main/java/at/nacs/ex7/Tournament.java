package at.nacs.ex7;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.LinkedList;


@Component
@RequiredArgsConstructor
public class Tournament {
    final BasketballTeamLoder basketballTeamLoder;

    void playRound() {
        showTeamsNames();
        playing();
    }

    private void playing() {
        LinkedList<BasketballTeam> teams = basketballTeamLoder.getBasketballTeams();
        while (teams.size() > 1) {

            Collections.shuffle(teams);
            BasketballTeam team1 = teams.poll();
            BasketballTeam team2 = teams.poll();
            System.out.println(team1.getName() + "plays vs " + team2.getName());
            System.out.println("and " + team2.getName() + " wins this match!");
            teams.add(team2);
        }
        BasketballTeam winner = teams.poll();
        System.out.println("The tournament's winning team is " + winner.getName() + " !!");
    }

    private void showTeamsNames() {
        System.out.println("-------------------------------------\n" +
                "Welcome to the street basketball tournament!\n" +
                "These are the teams who signed up:\n");
        basketballTeamLoder.getBasketballTeams().forEach(e -> System.out.println(
                "Team: " + e.getName() + ". | Players: " + e.getPlayers()));
        System.out.println("-------------------------------------");
    }
}
//Gettin' Wiggy With It. plays vs Better Call Gasol.
//And Better Call Gasol. wins this match!