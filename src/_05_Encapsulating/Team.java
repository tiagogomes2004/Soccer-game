package _05_Encapsulating;

public class Team {
    private String nome;
    private Player[] jogadores;

    public Player[] getJogadores() {
        return jogadores;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setJogadores(Player[] jogadores) {
        this.jogadores = jogadores;
    }
}
