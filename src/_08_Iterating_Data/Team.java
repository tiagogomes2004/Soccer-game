package _08_Iterating_Data;

public class Team {
    private String nome;
    private Player[] jogadores;
    private int points;
    private int goals;

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

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public void incPointsTotal (int points) {
        this.points += points;
    }

    public void incGoalsTotal(int goals) {
        this.goals += goals;
    }
}
