package _04_Overloading;

public class League {
    public static void main(String[] args) {
        League liga = new League();
        Team[] teams = liga.createTeams();
        Game[] games = liga.createGames(teams);

        games[0].playGame(10);
        System.out.println(games[0].getDescription());
    }

    public Team[] createTeams() {
        Player player1 = new Player();
        player1.nome = "George Eliot";
        Player player2 = new Player();
        player2.nome = "Graham Greene";
        Player player3 = new Player();
        player3.nome = "Geoffrey Chaucer";
        Player[] jogadoresGreens = {player1, player2, player3};
        Team teamGreens = new Team();
        teamGreens.nome = "The Greens";
        teamGreens.jogadores = jogadoresGreens;

        Player player4 = new Player();
        player4.nome = "Robert Service";
        Player player5 = new Player();
        player5.nome = "Robbie Burns";
        Player player6 = new Player();
        player6.nome = "Rafael Sabatini";
        Player[] jogadoresReds = {player4, player5, player6};
        Team teamReds = new Team();
        teamReds.nome = "The Reds";
        teamReds.jogadores = jogadoresReds;

        return new Team[]{teamGreens, teamReds};
    }

    public Game[] createGames(Team[] theTeams) {
        Game jogo1 = new Game();
        jogo1.homeTeam = theTeams[0];
        jogo1.awayTeam = theTeams[1];

        return new Game[]{jogo1};
    }
}
