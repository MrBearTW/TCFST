//java -cp .;C:\JavaSpace\* TestJDBC2
java -classpath .;C:\JavaSpace\Java\mysql-connector-java-5.1.44\mysql-connector-java-5.1.44-bin.jar TestJDBC1
Loading JDBC driver

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class TestJDBC2{
    public static void main(String args[]) throws SQLException{
        String url= "jdbc:mysql://localhost:3306/company?user=tcfst&password=12345678";
        Connection conn = DriverManager.getConnection(url);
    }
}