package _08_Iterating_Data;

public class League {
    public static void main(String[] args) {
        League liga = new League();
        Team[] teams = liga.createTeams();
        Game[] games = liga.createGames(teams);

        for (Game g : games) {
            g.playGame();
            System.out.println(g.getDescription());
        }

        liga.showBestTeam(teams);
    }

    public Team[] createTeams() {
        Player player1 = new Player("George Eliot");
        Player player2 = new Player("Graham Greene");
        Player player3 = new Player("Geoffrey Chaucer");
        Player[] jogadoresGreens = {player1, player2, player3};
        Team teamGreens = new Team("The Greens", jogadoresGreens);

        Player player4 = new Player("Robert Service");
        Player player5 = new Player("Robbie Burns");
        Player player6 = new Player("Rafael Sabatini");
        Player[] jogadoresReds = {player4, player5, player6};
        Team teamReds = new Team("The Reds", jogadoresReds);

        Team[] teamsCreated = {teamGreens, teamReds};

        return teamsCreated;
    }

    public Game[] createGames(Team[] theTeams) {
        Game jogo1 = new Game(theTeams[0], theTeams[1]);
        Game jogo2 = new Game(theTeams[1], theTeams[0]);
        Game jogo3 = new Game(theTeams[0], theTeams[1]);
        Game jogo4 = new Game(theTeams[1], theTeams[0]);
        Game[] games = {jogo1, jogo2, jogo3, jogo4};

        return games;
    }

    public void showBestTeam(Team[] theTeams) {
        Team bestTeam = new Team("everyone, because we should be nice to each other and have fun :)");
        int highestPoints = 0;
        int highestGoals = 0;
        System.out.println("Team Points");
        for (Team t : theTeams) {
            if (t.getPoints() > highestPoints) {
                bestTeam = t;
                highestPoints = t.getPoints();
            } else if (t.getPoints() == highestPoints) {
                if (t.getGoals() > bestTeam.getGoals()) {
                    bestTeam = t;
                    highestGoals = t.getGoals();
                }
            }
            System.out.println(t.getNome() + ":" + t.getPoints() + ":" + t.getGoals());
        }
        System.out.println("Winner of the League is " + bestTeam.getNome());
    }
}
