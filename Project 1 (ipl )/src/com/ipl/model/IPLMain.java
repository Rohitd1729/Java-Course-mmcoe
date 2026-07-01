package com.ipl.model;

import java.util.Scanner;

import com.ipl.model.Player;
import com.ipl.service.IPLService;

public class IPLMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		IPLService service = new IPLService();

		int choice;

		do {

			System.out.println("\n========== IPL MANAGEMENT ==========");

			System.out.println("1. Display All Players");
			System.out.println("2. Search Player By ID");
			System.out.println("3. Search Player By Name");
			System.out.println("4. Add Player");
			System.out.println("5. Delete Player");
			System.out.println("6. Display All Batsmen");
			System.out.println("7. Display All Bowlers");
			System.out.println("8. Filter By Team");
			System.out.println("9. Filter By Role");
			System.out.println("10. Players Above Amount");
			System.out.println("11. Sort By Bid Amount");
			System.out.println("12. Most Expensive Player");
			System.out.println("13. Display All Teams");
			System.out.println("14. Display Team Members");
			System.out.println("15. Team Wise Player Count");
			System.out.println("16. Team Wise Average Bid");
			System.out.println("17. Exit");

			System.out.print("Enter Choice : ");
			choice = sc.nextInt();

			sc.nextLine();

			switch (choice) {

			case 1:

				service.displayAllPlayers();
				break;

			case 2:

				System.out.print("Enter Player ID : ");
				int id = sc.nextInt();

				Player player =
						service.searchPlayerById(id);

				if (player != null)
					System.out.println(player);
				else
					System.out.println("Player Not Found");

				break;

			case 3:

				System.out.print("Enter Player Name : ");
				String name = sc.nextLine();

				service.searchPlayerByName(name);

				break;

			case 4:

				System.out.print("Enter Player ID : ");
				int playerId = sc.nextInt();

				sc.nextLine();

				System.out.print("Enter Player Name : ");
				String playerName = sc.nextLine();

				System.out.print("Enter Team Name : ");
				String teamName = sc.nextLine();

				System.out.print("Enter Role : ");
				String role = sc.nextLine();

				System.out.print("Enter Bid Amount : ");
				double bidAmount = sc.nextDouble();

				Player p = new Player(
						playerId,
						playerName,
						teamName,
						role,
						bidAmount);

				service.addPlayer(p);

				break;

			case 5:

				System.out.print("Enter Player ID : ");
				playerId = sc.nextInt();

				service.deletePlayer(playerId);

				break;

			case 6:

				service.displayBatsmen();

				break;

			case 7:

				service.displayBowlers();

				break;

			case 8:

				System.out.print("Enter Team Name : ");
				String team = sc.nextLine();

				service.filterByTeam(team);

				break;

			case 9:

				System.out.print("Enter Role : ");
				role = sc.nextLine();

				service.filterByRole(role);

				break;

			case 10:

				System.out.print("Enter Amount : ");
				double amount = sc.nextDouble();

				service.playersAboveAmount(amount);

				break;

			case 11:

				service.sortByBidAmount();

				break;

			case 12:

				service.mostExpensivePlayer();

				break;

			case 13:

				service.displayAllTeams();

				break;

			case 14:

				System.out.print("Enter Team Name : ");
				team = sc.nextLine();

				service.displayTeamMembers(team);

				break;

			case 15:

				service.teamWiseCount();

				break;

			case 16:

				service.teamWiseAverageBid();

				break;

			case 17:

				System.out.println("Thank You");
				break;

			default:

				System.out.println("Invalid Choice");
			}

		} while (choice != 17);

		sc.close();
	}
}