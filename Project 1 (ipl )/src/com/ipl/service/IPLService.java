package com.ipl.service;
import com.ipl.exception.PlayerNotFoundException;


import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.ipl.model.Player;
import com.ipl.repository.CSVPlayerRepository;
import com.ipl.repository.PlayerRepository;
public class IPLService {
	private PlayerRepository repository;

    private List<Player> players;

    public IPLService() {

        repository =
                new CSVPlayerRepository();

        players =
                repository.loadPlayers();

        System.out.println(
                players.size()
                + " Players Loaded Successfully");
    }
    
    
    
    

    public void displayAllPlayers() {

        players.forEach(System.out::println);
    }

    public Player searchPlayerById(int id)
            throws PlayerNotFoundException {

        return players.stream().filter(p -> p.getPlayerId() == id).findFirst().orElseThrow(() ->new PlayerNotFoundException("Player with ID "
                                + id
                                + " not found"));
    }

    public void displayBatsmen() {

        players.stream()

                .filter(p ->
                        p.getRole()
                         .equalsIgnoreCase("Batsman"))

                .forEach(System.out::println);
    }

    public void displayBowlers() {

        players.stream()

                .filter(p ->
                        p.getRole()
                         .equalsIgnoreCase("Bowler"))

                .forEach(System.out::println);
    }

    public void playersAboveAmount(double amount) {

        players.stream()

                .filter(p ->
                        p.getBidAmount() > amount)

                .forEach(System.out::println);
    }

    public void sortByBidAmount() {

        players.stream()

                .sorted(
                        Comparator.comparingDouble(
                                Player::getBidAmount).reversed())

                .forEach(System.out::println);
    }

    public void mostExpensivePlayer() {

        Player player = players.stream()

                .max(
                        Comparator.comparingDouble(
                                Player::getBidAmount))

                .orElse(null);

        System.out.println(player);
    }

    public void teamWiseCount() {

        Map<String, Long> result =

                players.stream()

                        .collect(
                                Collectors.groupingBy(
                                        Player::getTeamName,
                                        Collectors.counting()));

        result.forEach(
                (team, count) ->
                        System.out.println(
                                team + " = " + count));
    }

    public void teamWiseAverageBid() {

        Map<String, Double> result =

                players.stream()

                        .collect(
                                Collectors.groupingBy(
                                        Player::getTeamName,
                                        Collectors.averagingDouble(
                                                Player::getBidAmount)));

        result.forEach(
                (team, avg) ->
                        System.out.println(
                                team + " = " + avg));
    }
    public void searchPlayerByName(String name) {

        players.stream()

                .filter(p ->
                        p.getPlayerName()
                         .equalsIgnoreCase(name))

                .forEach(System.out::println);
    }
    public void addPlayer(Player player) {

        players.add(player);
        repository.savePlayers(players);

        System.out.println(
                "Player Added Successfully");
    }
    public void deletePlayer(int playerId)
            throws PlayerNotFoundException {

        Player p =
                searchPlayerById(playerId);

        players.remove(p);
        repository.savePlayers(players);

        System.out.println(
                "Player Deleted");
    }
    public void filterByTeam(String team) {

        players.stream()

                .filter(p ->
                        p.getTeamName()
                         .equalsIgnoreCase(team))

                .forEach(System.out::println);
    }
    public void filterByRole(String role) {

        players.stream()

                .filter(p ->
                        p.getRole()
                         .equalsIgnoreCase(role))

                .forEach(System.out::println);
    }
    public void displayAllTeams() {

        players.stream()

                .map(Player::getTeamName)

                .distinct()

                .sorted()

                .forEach(System.out::println);
    }
    public void displayTeamMembers(
            String teamName) {

        players.stream()

                .filter(p ->
                        p.getTeamName()
                         .equalsIgnoreCase(teamName))

                .forEach(System.out::println);
    }
    public void cheapestPlayer() {

        Player player = players.stream()

                .min(
                        Comparator.comparingDouble(
                                Player::getBidAmount))

                .orElse(null);

        System.out.println(player);
    }
    public void topFivePlayers() {

        players.stream()

                .sorted(
                        Comparator.comparingDouble(
                                Player::getBidAmount)
                                .reversed()).limit(5).forEach(System.out::println);
    }
    public void teamWisePlayers() {

        players.stream()

                .collect(
                        Collectors.groupingBy(
                                Player::getTeamName))

                .forEach((team, plist) -> {

                    System.out.println(
                            "\nTeam : " + team);

                    plist.forEach(
                            System.out::println);
                });
    }
    
    public boolean updatePlayer(int playerId,
            String teamName,
            String role,
            double bidAmount) {
			
			for(Player p : players) {
			
			if(p.getPlayerId() == playerId) {
			
				p.setTeamName(teamName);
				p.setRole(role);
				p.setBidAmount(bidAmount);
			
				repository.savePlayers(players);
			return true;
	}
	}
			
			return false;
		}
}