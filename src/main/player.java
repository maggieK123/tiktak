package main;
/*
Player class. Each player has a name, number of games won, number of games lost, and the status of current game ("X" or "O").
 */
public class player {
    private String name;
    private int wins;
    private int losses;
    private String status; // X or O

    public player(String name, int wins, int losses, String status){
        this.name = name;
        this.wins = wins;
        this.losses = losses;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public String getStatus() {
        return status;
    }

    public void setWins() {
        this.wins += 1;
    }

    public void setLosses() {
        this.losses += 1;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
