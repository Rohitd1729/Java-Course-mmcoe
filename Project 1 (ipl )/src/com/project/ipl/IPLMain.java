package com.project.ipl;

import java.util.Scanner;

public class IPLMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		IPLSystem ipl = new IPLSystem();

		int choice;

		do {

			System.out.println("\n===== IPL MANAGEMENT SYSTEM =====");
			System.out.println("1. Add Team");
			System.out.println("2. Search Team");
			System.out.println("3. Delete Team");
			System.out.println("4. List Teams");
			System.out.println("5. Add Player");
			System.out.println("6. Search Player");
			System.out.println("7. Delete Player");
			System.out.println("8. List Players");
			System.out.println("9. Exit");

			System.out.print("Enter Choice : ");
			choice = sc.nextInt();

			try {

				switch (choice) {

				case 1:

					System.out.print("Enter Team ID : ");
					int teamId = sc.nextInt();

					sc.nextLine();

					System.out.print("Enter Team Name : ");
					String teamName = sc.nextLine();

					System.out.print("Enter Budget : ");
					double budget = sc.nextDouble();

					Team team = new Team(teamId, teamName, budget);

					ipl.addTeam(team);

					break;

				case 2:

					System.out.print("Enter Team ID : ");
					teamId = sc.nextInt();

					System.out.println(
							ipl.searchTeam(teamId));

					break;

				case 3:

					System.out.print("Enter Team ID : ");
					teamId = sc.nextInt();

					ipl.deleteTeam(teamId);

					break;

				case 4:

					ipl.listTeams();

					break;

				case 5:

					System.out.print("Enter Team ID : ");
					teamId = sc.nextInt();

					System.out.print("Enter Player ID : ");
					int playerId = sc.nextInt();

					sc.nextLine();

					System.out.print("Enter Player Name : ");
					String playerName = sc.nextLine();

					System.out.print("Enter Bid Amount : ");
					double bidAmount = sc.nextDouble();

					Player player =
							new Player(playerId,
									playerName,
									bidAmount);

					ipl.addPlayer(teamId, player);

					break;

				case 6:

					System.out.print("Enter Team ID : ");
					teamId = sc.nextInt();

					System.out.print("Enter Player ID : ");
					playerId = sc.nextInt();

					System.out.println(
							ipl.searchPlayer(
									teamId,
									playerId));

					break;

				case 7:

					System.out.print("Enter Team ID : ");
					teamId = sc.nextInt();

					System.out.print("Enter Player ID : ");
					playerId = sc.nextInt();

					ipl.deletePlayer(
							teamId,
							playerId);

					break;

				case 8:

					System.out.print("Enter Team ID : ");
					teamId = sc.nextInt();

					ipl.listPlayers(teamId);

					break;

				case 9:

					System.out.println(
							"Thank You");

					break;

				default:

					System.out.println(
							"Invalid Choice");

				}

			}
			catch (Exception e) {

				System.out.println(
						e.getMessage());
			}

		} while (choice != 9);

		sc.close();
	}
}