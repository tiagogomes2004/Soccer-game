package _06_Constructors;

public class League {
    public static void main(String[] args) {
        League liga = new League();
        Team[] teams = liga.createTeams();
        Game[] games = liga.createGames(teams);

        for (Game g : games) {
            g.playGame();
            System.out.println(g.getDescription());
        }
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
}
