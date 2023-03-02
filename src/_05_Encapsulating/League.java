package _05_Encapsulating;

public class League {
    public static void main(String[] args) {
        League liga = new League();
        Team[] teams = liga.createTeams();
        Game[] games = liga.createGames(teams);

        games[0].playGame();
        System.out.println(games[0].getDescription());
    }

    public Team[] createTeams() {
        Player player1 = new Player();
        player1.setNome("George Eliot");
        Player player2 = new Player();
        player2.setNome("Graham Greene");
        Player player3 = new Player();
        player3.setNome("Geoffrey Chaucer");
        Player[] jogadoresGreens = {player1, player2, player3};
        Team teamGreens = new Team();
        teamGreens.setNome("The Greens");
        teamGreens.setJogadores(jogadoresGreens);

        Player player4 = new Player();
        player4.setNome("Robert Service");
        Player player5 = new Player();
        player5.setNome("Robbie Burns");
        Player player6 = new Player();
        player6.setNome("Rafael Sabatini");
        Player[] jogadoresReds = {player4, player5, player6};
        Team teamReds = new Team();
        teamReds.setNome("The Reds");
        teamReds.setJogadores(jogadoresReds);

        Team[] teamsCreated = {teamGreens, teamReds};

        return teamsCreated;
    }

    public Game[] createGames(Team[] theTeams) {
        Game jogo1 = new Game();
        jogo1.setHomeTeam(theTeams[0]);
        jogo1.setAwayTeam(theTeams[1]);
        Game[] games = {jogo1};

        return games;
    }
}
