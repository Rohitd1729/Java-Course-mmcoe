package com.project.ipl;

public class Team {

	private String teamName;
	private Player[] players;

	public Team(String teamName, Player[] players) {
		this.teamName = teamName;
		this.players = players;
	}

	public String getTeamName() {
		return teamName;
	}

	public void displayPlayers() {

		System.out.println("\nTeam : " + teamName);
		System.out.println("---------------------------");

		for (Player player : players) {
			System.out.println(player);
		}
	}
}