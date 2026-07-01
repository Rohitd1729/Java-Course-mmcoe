package com.ipl.model;

public class Player {

    private int playerId;
    private String playerName;
    private String teamName;
    private String role;
    private double bidAmount;

    public Player(int playerId, String playerName,
                  String teamName, String role,
                  double bidAmount) {

        this.playerId = playerId;
        this.playerName = playerName;
        this.teamName = teamName;
        this.role = role;
        this.bidAmount = bidAmount;
    }

    public int getPlayerId() {
        return playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getRole() {
        return role;
    }

    public double getBidAmount() {
        return bidAmount;
    }

    @Override
    public String toString() {
        return "Player [playerId=" + playerId
                + ", playerName=" + playerName
                + ", teamName=" + teamName
                + ", role=" + role
                + ", bidAmount=" + bidAmount + "]";
    }
}