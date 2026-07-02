package com.ipl.repository;

import java.util.List;

import com.ipl.model.Player;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;


public class CSVPlayerRepository
        implements PlayerRepository {

	@Override
	public List<Player> loadPlayers() {

	    try {

	        return Files.lines(Paths.get("players.csv"))

	                .skip(1)

	                .map(line -> line.split(","))

	                .map(data -> new Player(
	                        Integer.parseInt(data[0]),
	                        data[1],
	                        data[2],
	                        data[3],
	                        Double.parseDouble(data[4])))

	                .collect(Collectors.toList());

	    } catch(IOException e) {

	        e.printStackTrace();
	        return List.of();
	    }
	}

	@Override
	public void savePlayers(
	        List<Player> players) {

	    try {

	        List<String> lines = players.stream()

	                .map(p ->
	                        p.getPlayerId() + "," +
	                        p.getPlayerName() + "," +
	                        p.getTeamName() + "," +
	                        p.getRole() + "," +
	                        p.getBidAmount())

	                .collect(Collectors.toList());

	        lines.add(0,
	                "playerId,playerName,teamName,role,bidAmount");

	        Files.write(
	                Paths.get("players.csv"),
	                lines);

	    } catch(IOException e) {

	        e.printStackTrace();
	    }
	}
}