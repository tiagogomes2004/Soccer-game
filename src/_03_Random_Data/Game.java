package _03_Random_Data;

import java.util.concurrent.ThreadLocalRandom;

public class Game {
    public Team homeTeam;
    public Team awayTeam;
    public Goal[] golos;

    public void playGame() {
        int tamanho = ThreadLocalRandom.current().nextInt(0, 6 + 1);
        Goal[] golos = new Goal[tamanho];

        for (int i = 0; i < tamanho; i++) {
            int indexTeam = ThreadLocalRandom.current().nextInt(0, 1 + 1);
            Team randomTeam;
            if (indexTeam == 0) {
                randomTeam = this.homeTeam;
            } else {
                randomTeam = this.awayTeam;
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

        this.golos = golos;
    }

    public String getDescription() {
        StringBuilder description = new StringBuilder();

        for (Goal golo : this.golos) {
            description.append("Goal scored after ")
                    .append(golo.tempo)
                    .append(" mins by ")
                    .append(golo.jogador.nome)
                    .append(" of ")
                    .append(golo.equipa.nome)
                    .append("\n");
        }

        return description.toString();
    }
}
