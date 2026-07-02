package com.ipl.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

    private static final String URL =
            "jdbc:mysql://localhost:3306/ipl_db";

    private static final String USER =
            "root";

    private static final String PASSWORD =
            "Rohit@123";

    public static Connection getConnection() {

        try {

            return DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD);

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }
}