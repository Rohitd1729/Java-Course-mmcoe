package com.ipl.main;

import java.sql.Connection;

import com.ipl.model.Player;
import com.ipl.repository.MySQLPlayerRepository;
import com.ipl.util.DBUtil;

public class TestConnection {

    public static void main(String[] args) {

        Connection con =
                DBUtil.getConnection();

        if(con != null) {

            System.out.println(
                    "Database Connected");
        }
        
        MySQLPlayerRepository repo =
                new MySQLPlayerRepository();

        Player p =
                new Player(
                        101,
                        "Virat Kohli",
                        "India",
                        "Captain",
                        25.0);

        repo.update(p);
    }
}