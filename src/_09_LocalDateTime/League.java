package _09_LocalDateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class League {
    public static void main(String[] args) {
        League liga = new League();
        Team[] theTeams = liga.createTeams("The Robins,The Crows,The Swallows", 3);
        Game[] games = liga.createGames(theTeams);

        System.out.println(liga.getLeagueAnnouncement(games));

        for (Game g : games) {
            g.playGame();
            System.out.println(g.getDescription());
        }

        liga.showBestTeam(theTeams);
    }

    public Team[] createTeams(String createTeams, int teamSize) {
        PlayerDatabase playerDatabase = new PlayerDatabase();
        Team[] theTeams = new Team[teamSize];

        String[] teamNames = createTeams.split(",");

        for (int i = 0; i < teamNames.length; i++) {
            Player[] jogadores = playerDatabase.getTeam(3);
            Team team = new Team(teamNames[i], jogadores);

            theTeams[i] = team;
        }

        return theTeams;
    }

    public Game[] createGames(Team[] theTeams) {
        Game[] jogos = new Game[theTeams.length * 2];

        LocalDateTime theDateTime = LocalDateTime.now();
        for (int i = 0; i < theTeams.length; i++) {
            if (i == theTeams.length - 1) {
                jogos[i] = new Game(theTeams[i], theTeams[0], theDateTime);
            } else {
                jogos[i] = new Game(theTeams[i], theTeams[i + 1], theDateTime);
            }
            theDateTime = theDateTime.plusDays(7);
        }

        for (int i = theTeams.length - 1; i >= 0; i--) {
            if (i == 0) {
                jogos[jogos.length - 1 - i] = new Game(theTeams[0], theTeams[theTeams.length - 1], theDateTime);
            } else {
                jogos[jogos.length - 1 - i] = new Game(theTeams[i], theTeams[i - 1], theDateTime);
            }
            theDateTime = theDateTime.plusDays(7);
        }

        return jogos;
    }

    public void showBestTeam(Team[] theTeams) {
        Team bestTeam = new Team("everyone, because we should be nice to each other and have fun :)");
        System.out.println("Team Points");
        for (Team t : theTeams) {
            if (t.getPoints() > bestTeam.getPoints()) {
                bestTeam = t;
            } else if (t.getPoints() == bestTeam.getPoints()) {
                if (t.getGoals() > bestTeam.getGoals()) {
                    bestTeam = t;
                }
            }
            System.out.println(t.getNome() + ":" + t.getPoints() + ":" + t.getGoals());
        }
        System.out.println("Winner of the League is " + bestTeam.getNome());
    }

    public String getLeagueAnnouncement(Game[] theGames) {
        LocalDate firstGame = theGames[0].getTheDateTime().toLocalDate();
        LocalDate lastGame = theGames[theGames.length - 1].getTheDateTime().toLocalDate();

        Period leagueDuration = Period.between(firstGame, lastGame);

        return "The League is scheduled to run for " + leagueDuration.getMonths() + " month(s), and " + leagueDuration.getDays() + " day(s)";
    }
}
