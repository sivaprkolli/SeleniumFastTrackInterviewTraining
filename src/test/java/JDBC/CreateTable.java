package JDBC;

import java.sql.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CreateTable {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/automation_db";
        String user = "postgres";
        String password = "Selenium@123";
        Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("CREATE TABLE car (\n" +
                     "  brand VARCHAR(255),\n" +
                     "  model VARCHAR(255),\n" +
                     "  year INT\n" +
                     ");");
    }
}
