import java.sql.*;

public class DbHelper {
    private String userName = "postgres";
    private String password = "123hasan456bolat";
    private String dbUrl = "jdbc:postgresql://localhost:5432/market";
    
    public Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(dbUrl,userName,password);
    }
    
    public void showErrorMessage(SQLException exception)
    {
        System.out.println("Error code: " + exception.getErrorCode());
        System.out.println("Error: " + exception.getMessage());

    }
}
