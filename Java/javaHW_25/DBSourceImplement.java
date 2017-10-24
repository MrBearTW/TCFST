import java.io.*;
import java.sql.*;
import java.util.*;

public class DBSourceImplement implements DBSource{
    Properties props;
    String url;
    String user;
    String passwd;
    
    public DBSourceImplement() throws IOException,ClassNotFoundException{
        this("jdbc.properties");
    }
    
    public DBSourceImplement(String config) throws IOException,ClassNotFoundException{
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
    public void creatTable(Connection conn,String table)throws SQLException{
    	 Statement stmt = conn.createStatement();
    	 StringBuffer strbu = new StringBuffer();
    	 strbu
    	 .append("CREATE TABLE IF NOT EXISTS ")
    	 .append(table)
    	 .append("(number VARCHAR(6),price VARCHAR(12), PRIMARY KEY (number))")
    	 .append("ENGINE=InnoDB DEFAULT CHARSET=utf8");   	 
    	 stmt.executeUpdate(strbu.toString());   	
    };
    public void modifyTable(Connection conn,String table,Map<String,String> map)throws SQLException{
    	Statement stmt = conn.createStatement();
   	 	for(String str: map.keySet()){
   	 		String existNumber = "select count(number) as flag from "+table+" where number="+str;   
   	 	    ResultSet rs =stmt.executeQuery(existNumber);
   	 	    rs.next();
   	 		if(rs.getInt("flag")==0) {   	 			
		 		String insRow = "insert into "+table+" (number,price) values(?,?)";
		 		PreparedStatement preparedStmt = conn.prepareStatement(insRow);
			    preparedStmt.setString (1, str);
			    preparedStmt.setString (2, map.get(str));	
			    preparedStmt.executeUpdate();
   	 		}else {
	   	 		String updRow = "update "+table+" set price=? where number=?";
	   	 		PreparedStatement preparedStmt = conn.prepareStatement(updRow);			   
			    preparedStmt.setString (1, map.get(str));	   	   	 
			    preparedStmt.setString (2, str);
			    preparedStmt.executeUpdate();   	 			
   	 		}
   	 	}    
    };
}