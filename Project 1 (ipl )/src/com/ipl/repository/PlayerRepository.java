package com.ipl.repository;

import java.util.List;

import com.ipl.model.Player;

public interface PlayerRepository {

    List<Player> loadPlayers();

    void savePlayers(List<Player> players);
}