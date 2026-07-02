package com.ipl.repository;

import java.util.List;

import com.ipl.model.Player;

public interface PlayerRepository {

    List<Player> findAll();

    void save(Player player);

    void update(Player player);

    void delete(int playerId);
}