package Utility;

import _03_Random_Data.Game;
import _03_Random_Data.Goal;
import _03_Random_Data.Player;
import _03_Random_Data.Team;

import java.util.concurrent.ThreadLocalRandom;

public class GameUtils {
    public static void addGameGoals(Game game) {
        int tamanho = ThreadLocalRandom.current().nextInt(0, 6 + 1);
        Goal[] golos = new Goal[tamanho];

        for (int i = 0; i < tamanho; i++) {
            int indexTeam = ThreadLocalRandom.current().nextInt(0, 1 + 1);
            Team randomTeam;
            if (indexTeam == 0) {
                randomTeam = game.homeTeam;
            } else {
                randomTeam = game.awayTeam;
            }

            int indexJogador = ThreadLocalRandom.current().nextInt(0, randomTeam.jogadores.length);
            Player randomPlayer = randomTeam.jogadores[indexJogador];

            int tempoInicial = i > 0 ? (int) golos[i - 1].tempo : 0;
            double randomTempo = ThreadLocalRandom.current().nextInt(tempoInicial, 90 + 1);

            golos[i] = new Goal();
            golos[i].jogador = randomPlayer;
            golos[i].equipa = randomTeam;
            golos[i].tempo = randomTempo;
        }

        game.golos = golos;
    }
}
