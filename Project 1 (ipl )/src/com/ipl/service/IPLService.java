package com.ipl.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.ipl.model.Player;

public class IPLService {

    private List<Player> players;

    public IPLService() {
        loadPlayers();
    }

    private void loadPlayers() {

        try {

            players = Files.lines(Paths.get("players.csv"))

                    .skip(1)

                    .map(line -> line.split(","))

                    .map(data -> new Player(
                            Integer.parseInt(data[0]),
                            data[1],
                            data[2],
                            data[3],
                            Double.parseDouble(data[4])))

                    .collect(Collectors.toList());

            System.out.println(players.size()
                    + " Players Loaded Successfully");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayAllPlayers() {

        players.forEach(System.out::println);
    }

    public Player searchPlayerById(int id) {

        return players.stream()

                .filter(p ->
                        p.getPlayerId() == id)

                .findFirst()

                .orElse(null);
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
                                Player::getBidAmount))

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

        System.out.println(
                "Player Added Successfully");
    }
    public void deletePlayer(int playerId) {

        boolean removed = players.removeIf(
                p -> p.getPlayerId() == playerId);

        if (removed)
            System.out.println("Player Deleted");
        else
            System.out.println("Player Not Found");
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
                                .reversed())

                .limit(5)

                .forEach(System.out::println);
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
}