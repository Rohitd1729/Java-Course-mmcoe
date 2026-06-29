package com.project.ipl;

public class Player {

	private int playerId;
	private String playerName;
	private double bidAmount;

	public Player(int playerId, String playerName, double bidAmount) {
		this.playerId = playerId;
		this.playerName = playerName;
		this.bidAmount = bidAmount;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public double getBidAmount() {
		return bidAmount;
	}

	public void setBidAmount(double bidAmount) {
		this.bidAmount = bidAmount;
	}

	@Override
	public String toString() {
		return "Player ID : " + playerId +
			   ", Name : " + playerName +
			   ", Bid Amount : ₹" + bidAmount + " Cr";
	}
}