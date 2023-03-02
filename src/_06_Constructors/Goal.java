package _06_Constructors;

public class Goal {
    private Team equipa;
    private Player jogador;
    private double tempo;

    public Goal(Team equipa, Player jogador, double tempo) {
        this.equipa = equipa;
        this.jogador = jogador;
        this.tempo = tempo;
    }

    public Team getEquipa() {
        return equipa;
    }

    public Player getJogador() {
        return jogador;
    }

    public double getTempo() {
        return tempo;
    }

    public void setEquipa(Team equipa) {
        this.equipa = equipa;
    }

    public void setJogador(Player jogador) {
        this.jogador = jogador;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }
}
