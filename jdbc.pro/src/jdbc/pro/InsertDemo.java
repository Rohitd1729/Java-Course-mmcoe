package jdbc.pro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertDemo {

    public static void main(String[] args) {

        try {

            Connection conn =
                    DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/elitebatch",
                            "root",
                            "Rohit@123");

            Statement st = conn.createStatement();

            String sql =
                    "INSERT INTO customer(name,email,phone,city) " +
                    "VALUES('Rohit','rohit@gmail.com','9876543210','Pune')";

            int rows = st.executeUpdate(sql);

            System.out.println(rows + " row inserted");

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}