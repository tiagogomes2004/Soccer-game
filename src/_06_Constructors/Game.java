package _06_Constructors;

import java.util.concurrent.ThreadLocalRandom;

public class Game {
    private Team homeTeam;
    private Team awayTeam;
    private Goal[] golos;

    public Game(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public Goal[] getGolos() {
        return golos;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public void setGolos(Goal[] golos) {
        this.golos = golos;
    }

    public void playGame() {
        int tamanho = ThreadLocalRandom.current().nextInt(0, 6 + 1);
        Goal[] golos = new Goal[tamanho];

        for (int i = 0; i < tamanho; i++) {
            int indexTeam = ThreadLocalRandom.current().nextInt(0, 1 + 1);
            Team randomTeam;
            if (indexTeam == 0) {
                randomTeam = this.getHomeTeam();
            } else {
                randomTeam = this.getAwayTeam();
            }

            int indexJogador = ThreadLocalRandom.current().nextInt(0, randomTeam.getJogadores().length);
            Player randomPlayer = randomTeam.getJogadores()[indexJogador];

            int tempoInicial = i > 0 ? (int) golos[i - 1].getTempo() : 0;
            double randomTempo = ThreadLocalRandom.current().nextInt(tempoInicial, 90 + 1);

            golos[i] = new Goal(randomTeam, randomPlayer, randomTempo);
        }

        this.setGolos(golos);
    }

    public void playGame(int max) {
        int tamanho = ThreadLocalRandom.current().nextInt(0, max + 1);
        Goal[] golos = new Goal[tamanho];

        for (int i = 0; i < tamanho; i++) {
            int indexTeam = ThreadLocalRandom.current().nextInt(0, 1 + 1);
            Team randomTeam;
            if (indexTeam == 0) {
                randomTeam = this.getHomeTeam();
            } else {
                randomTeam = this.getAwayTeam();
            }

            int indexJogador = ThreadLocalRandom.current().nextInt(0, randomTeam.getJogadores().length);
            Player randomPlayer = randomTeam.getJogadores()[indexJogador];

            int tempoInicial = i > 0 ? (int) golos[i - 1].getTempo() : 0;
            double randomTempo = ThreadLocalRandom.current().nextInt(tempoInicial, 90 + 1);

            golos[i] = new Goal(randomTeam, randomPlayer, randomTempo);
        }

        this.setGolos(golos);
    }

    public String getDescription() {
        StringBuilder description = new StringBuilder();

        for (int i = 0; i < this.golos.length; i++) {
            description.append("Goal scored after ")
                    .append(this.getGolos()[i].getTempo())
                    .append(" mins by ")
                    .append(this.getGolos()[i].getJogador().getNome())
                    .append(" of ")
                    .append(this.getGolos()[i].getEquipa().getNome())
                    .append("\n");
        }

        return description.toString();
    }
}
