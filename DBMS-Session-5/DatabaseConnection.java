package storeFrontApplication;
import java.sql.*;

public class DatabaseConnection {
    
    public static Connection getConnection()
    {
      Connection conn = null;
      try
      {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost/StoreFront";
        String userName="root";
        String password="password";
        conn = DriverManager.getConnection(url, userName, password);
      }
      catch (ClassNotFoundException e)
      {
        e.printStackTrace();
        System.exit(1);
      } catch (SQLException e) {
        e.printStackTrace();
    }
      return conn;
    }

}
