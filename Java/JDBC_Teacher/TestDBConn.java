//java -cp .;C:\JavaSpace\* TestDBConn

import java.sql.Connection;
import java.io.IOException;
import java.sql.SQLException;
public class TestDBConn{
    public static void main(String args[]) throws IOException, SQLException,ClassNotFoundException{
        DBSource db = new SimpleDBSource();
        Connection conn = db.getConnection();
        
        if(!conn.isClosed()){
            System.out.println("AAA��Ʈw�s���w�g�}��...");
        }
        
        db.closeConnection(conn);
        if( conn.isClosed()){
            System.out.println("BBB��Ʈw�s���w�g����...");
        }
        
    }
}