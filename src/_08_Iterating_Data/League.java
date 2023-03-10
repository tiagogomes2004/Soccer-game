package _08_Iterating_Data;

public class League {
    public static void main(String[] args) {
        League liga = new League();
        Team[] theTeams = liga.createTeams("The Robins,The Crows,The Swallows", 3);
        Game[] games = liga.createGames(theTeams);

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

        for (int i = 0; i < theTeams.length; i++) {
            if (i == theTeams.length - 1) {
                jogos[i] = new Game(theTeams[i], theTeams[0]);
            } else {
                jogos[i] = new Game(theTeams[i], theTeams[i + 1]);
            }
        }

        for (int i = theTeams.length - 1; i >= 0; i--) {
            if (i == 0) {
                jogos[theTeams.length + i] = new Game(theTeams[0], theTeams[theTeams.length - 1]);
            } else {
                jogos[theTeams.length + i] = new Game(theTeams[i], theTeams[i - 1]);
            }
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
}
