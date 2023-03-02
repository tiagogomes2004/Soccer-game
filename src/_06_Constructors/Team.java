package _06_Constructors;

public class Team {
    private String nome;
    private Player[] jogadores;

    public Team(String nome) {
        this.nome = nome;
    }

    public Team(String nome, Player[] jogadores) {
        this.nome = nome;
        this.jogadores = jogadores;
    }

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
