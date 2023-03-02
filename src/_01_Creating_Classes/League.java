package _01_Creating_Classes;

public class League {
    public static void main(String[] args) {
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

        Game jogo1 = new Game();
        jogo1.homeTeam = teamGreens;
        jogo1.awayTeam = teamReds;
        Goal golo1 = new Goal();
        golo1.equipa = jogo1.homeTeam;
        golo1.jogador = jogo1.homeTeam.jogadores[2];
        golo1.tempo = 55;
        jogo1.golos = new Goal[]{golo1};

        System.out.println("Goal scored after " + (int) jogo1.golos[0].tempo + " mins by " + jogo1.golos[0].jogador.nome + " of " + jogo1.golos[0].equipa.nome);

        for (Player p : teamReds.jogadores) {
            if (p.nome.contains("Sab")) {
                System.out.println("Found " + p.nome);
                System.out.println("Last name is " + p.nome.substring(p.nome.indexOf(' ') + 1));
            }
        }

        for (Player p : teamGreens.jogadores) {
            System.out.println(p.nome.substring(p.nome.indexOf(' ') + 1) + ", " + p.nome.substring(0, p.nome.indexOf(' ')));
        }
    }
}
