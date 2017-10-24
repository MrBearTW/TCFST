import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

public interface DBSource{
    public Connection getConnection() throws SQLException;
    public void creatTable(Connection conn,String table)throws SQLException;
    public void modifyTable(Connection conn,String table,Map<String,String> map)throws SQLException;
    public void closeConnection(Connection conn) throws SQLException;
}