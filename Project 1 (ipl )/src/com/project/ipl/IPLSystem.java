package com.project.ipl;

import java.util.Scanner;

public class IPLSystem {

	public static void main(String[] args) {

		Player[] rcbPlayers = {
				new Player("Virat Kohli", 21),
				new Player("Phil Salt", 11.5),
				new Player("Rajat Patidar", 14)
		};

		Player[] miPlayers = {
				new Player("Rohit Sharma", 16),
				new Player("Jasprit Bumrah", 18),
				new Player("Suryakumar Yadav", 17)
		};

		Player[] cskPlayers = {
				new Player("MS Dhoni", 12),
				new Player("Ruturaj Gaikwad", 14),
				new Player("Ravindra Jadeja", 16)
		};

		Player[] kkrPlayers = {
				new Player("Ajinkya Rahane", 10),
				new Player("Andre Russell", 15),
				new Player("Sunil Narine", 14)
		};

		Player[] srhPlayers = {
				new Player("Pat Cummins", 18),
				new Player("Travis Head", 15),
				new Player("Abhishek Sharma", 12)
		};

		Team[] teams = {
				new Team("RCB", rcbPlayers),
				new Team("MI", miPlayers),
				new Team("CSK", cskPlayers),
				new Team("KKR", kkrPlayers),
				new Team("SRH", srhPlayers)
		};

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Team Name : ");
		String searchTeam = sc.nextLine();

		boolean found = false;

		for (Team team : teams) {

			if (team.getTeamName().equalsIgnoreCase(searchTeam)) {

				team.displayPlayers();
				found = true;
				break;
			}
		}

		if (!found) {
			System.out.println("Team not found!");
		}

		sc.close();
	}
}