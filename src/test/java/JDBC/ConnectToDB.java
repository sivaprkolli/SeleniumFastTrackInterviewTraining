package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ConnectToDB {

        public static void main(String[] args) {
            String url = "jdbc:postgresql://localhost:5432/automation_db";
            String user = "postgres";
            String password = "Selenium@123";
            List<String> column = Arrays.asList("brand","model","year");
            List<String> users = Arrays.asList("email", "pwd");
            String table = "credentials";
            try (Connection conn = DriverManager.getConnection(url, user, password);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT * FROM "+table)) {



                Iterator<String> iterator = column.listIterator();

                while (rs.next()) {
                    for(String col: users)
                    System.out.println("Data: " + rs.getString(col));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



