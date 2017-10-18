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
        ResultSet rs = stmt.executeQuery("Select * From 員工資料表");
        System.out.println("員工編號\t姓名\t地址");
        while (rs.next()) {
            System.out.print(rs.getInt("員工編號") + "\t\t");
            System.out.print(rs.getString("姓名") + "\t");
            System.out.println(rs.getString("地址"));
        }
        db.closeConnection(conn);

    }
}