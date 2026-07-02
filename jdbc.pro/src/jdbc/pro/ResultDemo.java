package jdbc.pro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultDemo {

    public static void main(String[] args) {

        try {

            Connection conn =
                    DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/elitebatch",
                            "root",
                            "Rohit@123");

            Statement st =
                    conn.createStatement();

            String sql =
                    "SELECT * FROM customer";

            ResultSet rs =
                    st.executeQuery(sql);

            while(rs.next()) {

                System.out.println(
                        rs.getInt("id")
                        + " "
                        + rs.getString("name")
                        + " "
                        + rs.getString("city")
                );
            }

            conn.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}