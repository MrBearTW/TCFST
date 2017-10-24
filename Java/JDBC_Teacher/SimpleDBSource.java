import java.io.*;
import java.sql.*;
import java.util.*;

public class SimpleDBSource implements DBSource{
    Properties props;
    String url;
    String user;
    String passwd;
    
    public SimpleDBSource() throws IOException,ClassNotFoundException{
        this("jdbc.properties");
    }
    
    public SimpleDBSource(String config) throws IOException,ClassNotFoundException{
        props = new Properties();
        props.load(new FileInputStream(config));
        url = props.getProperty("db.url");
        user = props.getProperty("db.user");
        passwd = props.getProperty("db.passwd");        
        Class.forName(props.getProperty("db.driver"));
    }
    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url,user,passwd);
    }
    public void closeConnection(Connection conn) throws SQLException{
        conn.close();
    }
    
}