package DesignPatterns;

public class DatabaseFactory {
    private static DatabaseFactory factoryInstance;

    private DatabaseFactory(){}

    public static DatabaseFactory getInstance(){
        if (factoryInstance == null){
            factoryInstance = new DatabaseFactory();
        }
        return factoryInstance;
    }

    public DatabaseConnection createConnection(String dbType){
        switch (dbType){
            case "SQL":
                return DatabaseConnection.getInstance("SQL Connection String");
            case "NoSQL":
                return DatabaseConnection.getInstance("NoSQL Connection String");
            default:
                throw new IllegalArgumentException("Provide right db");
        }
    }
}
