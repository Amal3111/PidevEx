package utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDatabase {
    private final String URL="jdbc:mysql://localhost:3306/3a9";
    private final String	USER="root";
    private final String PASSWORD="";
    private static MyDatabase instance;
    //req sql
    private Connection connection;

    private MyDatabase(){
        //acceder a une methode statitque du drivermanger
        //getconnection exception

        try {
            connection= DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("connected!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static MyDatabase getInstance(){
        if(instance==null){
            instance=new MyDatabase();
        }
        return instance;
    }
    public Connection getConnection(){
        return connection;
    }
}
