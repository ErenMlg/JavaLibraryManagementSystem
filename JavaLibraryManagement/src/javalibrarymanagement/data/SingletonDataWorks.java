package javalibrarymanagement.data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SingletonDataWorks {
    private static Connection connection = null;
    private static Statement statement = null;
    private static final String userName = "avnadmin";
    private static final String password = "AVNS_DdLKwU__nchEZuVhCv3";
    private static final String dblURL = "jdbc:mysql://library-management-library-management-system.a.aivencloud.com:25580/library_management_system";

    static {
        try {
            connection = DriverManager.getConnection(dblURL, userName, password);
            statement = connection.createStatement();
            System.out.println("database connected");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static Connection getConnection(){
        return connection;
    }

    public static Statement getStatement(){
        if(statement == null){
            try{
                statement = connection.createStatement();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return statement;
    }
}

