package jdbc.pro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedDemo {

    public static void main(String[] args) {

        String sql =
                "INSERT INTO customer VALUES (?, ?, ?, ?, ? )";

        try {

            Connection conn =
                    JdbcFactory.getConnection();

            PreparedStatement stmt =
                    conn.prepareStatement(sql);

            
            stmt.setInt(1,
                    Integer.parseInt(args[0]));

            stmt.setString(2,
                    args[1]);

            stmt.setString(3,
                    args[2]);

            stmt.setString(4,
                    args[3]);

            stmt.setString(5,
                    args[4]);


            int rows =
                    stmt.executeUpdate();

            System.out.println(
                    rows + " record inserted"
            );

            conn.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}