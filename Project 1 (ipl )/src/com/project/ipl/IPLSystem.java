package com.project.ipl;

import java.util.Map;
import java.util.HashMap;

public class IPLSystem {

	private Map<Integer, Team> teams;

	public IPLSystem() {
		teams = new HashMap<Integer, Team>();
	}

	// Add Team
	public void addTeam(Team team) {
		teams.put(team.getTeamId(), team);
		System.out.println("Team Added Successfully");
	}

	// Search Team
	public Team searchTeam(int teamId)
			throws TeamNotFoundException {

		Team team = teams.get(teamId);

		if (team == null) {
			throw new TeamNotFoundException(
					"Team ID " + teamId + " Not Found");
		}

		return team;
	}

	// Delete Team
	public void deleteTeam(int teamId)
			throws TeamNotFoundException {

		if (!teams.containsKey(teamId)) {
			throw new TeamNotFoundException(
					"Team ID " + teamId + " Not Found");
		}

		teams.remove(teamId);

		System.out.println("Team Deleted Successfully");
	}

	// List Teams
	public void listTeams() {

		if (teams.isEmpty()) {
			System.out.println("No Teams Available");
			return;
		}

		for (Team team : teams.values()) {
			System.out.println(team);
		}
	}

	// Add Player
	public void addPlayer(int teamId, Player player)
			throws TeamNotFoundException {

		Team team = searchTeam(teamId);

		team.addPlayer(player);

		System.out.println("Player Added Successfully");
	}

	// Search Player
	public Player searchPlayer(int teamId, int playerId)
			throws TeamNotFoundException,
			PlayerNotFoundException {

		Team team = searchTeam(teamId);

		for (Player p : team.getPlayers()) {

			if (p.getPlayerId() == playerId) {
				return p;
			}
		}

		throw new PlayerNotFoundException(
				"Player ID " + playerId + " Not Found");
	}

	// Delete Player
	public void deletePlayer(int teamId, int playerId)
			throws TeamNotFoundException,
			PlayerNotFoundException {

		Team team = searchTeam(teamId);

		Player player = searchPlayer(teamId, playerId);

		team.getPlayers().remove(player);

		System.out.println("Player Deleted Successfully");
	}

	// List Players
	public void listPlayers(int teamId)
			throws TeamNotFoundException {

		Team team = searchTeam(teamId);

		team.listPlayers();
	}
}

