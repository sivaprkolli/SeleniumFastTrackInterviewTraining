package JDBC;

import java.sql.*;
import java.util.*;

public class DBUtils {
    private Connection connection;

    public static void main(String[] args) {
        DBUtils dbUtil = new DBUtils();
        String url = "jdbc:postgresql://localhost:5432/automation_db";
        String user = "postgres";
        String password = "Selenium@123";


        List<String> users = Arrays.asList("email", "passwd");
        String table = "userData";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM " + table)) {
            while (rs.next()) {
                for (String col : users)
                    System.out.println("Data: " + rs.getString(col));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        dbUtil.connect(url, user, password);
        dbUtil.getQueryResult("SELECT * FROM userData");
        dbUtil.closeConnection();
    }

    public Connection connect(String dbURL, String username, String password) {
        try {
            connection = DriverManager.getConnection(dbURL, username, password);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return resultSet;
    }

    public List<Map<String, Object>> getQueryResult(String query) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (rs.next()) {
                Map<String, Object> rowMap = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    rowMap.put(metaData.getColumnLabel(i), rs.getObject(i));
                }
                resultList.add(rowMap);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(resultList);
        return resultList;
    }
}


