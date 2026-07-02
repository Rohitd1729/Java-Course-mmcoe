package com.ipl.main;

import com.ipl.model.Player;
import com.ipl.repository.MySQLPlayerRepository;

public class TestInsert {

    public static void main(String[] args) {

        MySQLPlayerRepository repo =
                new MySQLPlayerRepository();

        Player p =
                new Player(
                        101,
                        "Virat Kohli",
                        "RCB",
                        "Batsman",
                        18.0);

        repo.save(p);
    }
}