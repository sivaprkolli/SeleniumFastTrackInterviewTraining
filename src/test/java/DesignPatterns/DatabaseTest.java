package DesignPatterns;

import org.testng.annotations.Test;

public class DatabaseTest {
    DatabaseFactory databaseFactory;
    DatabaseConnection databaseConnection;
    @Test
    public void verifyPatterns(){
        databaseFactory = DatabaseFactory.getInstance();

        databaseConnection = databaseFactory.createConnection("SQL");
        System.out.println(databaseConnection.getConnectionString());

        databaseConnection = databaseFactory.createConnection("NoSQL");
        System.out.println(databaseConnection.getConnectionString());


    }
}
