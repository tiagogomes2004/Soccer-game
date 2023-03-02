package _02_Using_Methods;

public class League {
    public static void main(String[] args) {
        Team[] teams = createTeams();
        Game[] games = createGames(teams);

        Goal golo1 = new Goal();
        golo1.equipa = games[0].homeTeam;
        golo1.jogador = games[0].homeTeam.jogadores[2];
        golo1.tempo = 55;
        games[0].golos = new Goal[]{golo1};
        System.out.println("Goal scored after " + (int) games[0].golos[0].tempo + " mins by " + games[0].golos[0].jogador.nome + " of " + games[0].golos[0].equipa.nome);
    }

    public static Team[] createTeams() {
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

    public static Game[] createGames(Team[] theTeams) {
        Game jogo1 = new Game();
        jogo1.homeTeam = theTeams[0];
        jogo1.awayTeam = theTeams[1];

        return new Game[]{jogo1};
    }
}
