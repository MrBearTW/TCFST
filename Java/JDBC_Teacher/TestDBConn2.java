//java -cp .;C:\JavaSpace\* TestDBConn

//java -cp .;* TestDBConn

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.io.IOException;
import java.sql.SQLException;

public class TestDBConn2 {
    public static void main(String args[]) throws IOException, SQLException, ClassNotFoundException {
        DBSource db = new SimpleDBSource();
        Connection conn = db.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("Select * From ���u��ƪ�");
        System.out.println("���u�s��\t�m�W\t�a�}");
        while (rs.next()) {
            System.out.print(rs.getInt("���u�s��") + "\t\t");
            System.out.print(rs.getString("�m�W") + "\t");
            System.out.println(rs.getString("�a�}"));
        }
        db.closeConnection(conn);

    }
}