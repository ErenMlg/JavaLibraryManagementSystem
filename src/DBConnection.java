import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    static Connection connection = null;
    static Statement statement = null;

    private DBConnection() {
        try {
            connection = DriverManager.getConnection(dblURL, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static final String userName = "avnadmin";
    static final String password = "AVNS_DdLKwU__nchEZuVhCv3";
    static final String dblURL = "jdbc:mysql://library-management-library-management-system.a.aivencloud.com:25580/library_management_system";

    public static Connection getDBConnection() {
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(dblURL, userName, password);
            }
        } catch (SQLException exception) {
            System.out.println("Error : " + exception.getMessage() + "\nError Code : " + exception.getErrorCode());
        }
        return connection;
    }

    public static Statement getStatement() {
        try {
            if (connection != null) {
                statement = connection.createStatement();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statement;
    }
}
