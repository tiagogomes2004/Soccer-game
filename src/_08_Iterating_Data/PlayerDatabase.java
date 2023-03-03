package _08_Iterating_Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.concurrent.ThreadLocalRandom;

public class PlayerDatabase {
    private final ArrayList<Player> players = new ArrayList<Player>();
    private static final String nomes = "David de Gea,Jack Butland,Tom Heaton,Lisandro Martinez,Raphael Varane,Harry Maquire,Victor Lindelof,Phil Jones,Teden Mengi,Luke Shaw,Tyrell Malacia,Brandon Williams,Diogo Dalot,Aaron Wan-Bissaka";

    public PlayerDatabase() {
        StringTokenizer tokens = new StringTokenizer(nomes, ",");
        while (tokens.hasMoreTokens()) {
            players.add(new Player(tokens.nextToken()));
        }
    }

    public Player[] getTeam(int numeroPlayers) {
        Player[] team = new Player[numeroPlayers];

        int i = 0;
        do {
            int playerIndex = ThreadLocalRandom.current().nextInt(0, players.size());
            Player escolhido = players.get(playerIndex);
            if (!Arrays.asList(team).contains(escolhido)) {
                team[i] = escolhido;
                i++;
            }
        } while (i < numeroPlayers);

        return team;
    }
}
