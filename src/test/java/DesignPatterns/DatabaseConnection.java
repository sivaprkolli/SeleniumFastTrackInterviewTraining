package DesignPatterns;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private String connectionString;

    private DatabaseConnection(String connectionString){
        this.connectionString = connectionString;
    }

    public static DatabaseConnection getInstance(String connectionString){
        if (instance == null){
            instance = new DatabaseConnection(connectionString);
        }
        return instance;
    }

    public String getConnectionString(){
        return connectionString;
    }
}
