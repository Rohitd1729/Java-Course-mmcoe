package com.project.ipl;

import java.util.LinkedList;

public class Team {

	private int teamId;
	private String teamName;
	private double budget;

	private LinkedList<Player> players;

	public Team(int teamId, String teamName, double budget) {

		this.teamId = teamId;
		this.teamName = teamName;
		this.budget = budget;

		players = new LinkedList<Player>();
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public LinkedList<Player> getPlayers() {
		return players;
	}

	// Add Player
	public void addPlayer(Player p) {
		players.add(p);
	}

	// List Players
	public void listPlayers() {

		if(players.isEmpty()) {
			System.out.println("No Players Found");
			return;
		}

		for(Player p : players) {
			System.out.println(p);
		}
	}

	@Override
	public String toString() {

		return "Team ID : " + teamId +
			   ", Team Name : " + teamName +
			   ", Budget : ₹" + budget + " Cr";
	}
}