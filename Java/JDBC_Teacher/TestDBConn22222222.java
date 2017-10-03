//java -cp .;C:\JavaSpace\* TestDBConn2

//java -cp .;* TestDBConn2

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.io.IOException;
import java.sql.SQLException;
public class TestDBConn2{
    public static void main(String args[]) throws Exception{
        DBSource db = new SimpleDBSource();
        Connection conn = db.getConnection();
        Statement stmt = conn.createStatement();
        //******************************************************
        //************** ���ʸ�� ******************************
        //******************************************************
        //stmt.executeUpdate("Insert into ���u��ƪ� values(18,'���p��','�k','�s�˥��M�ؤj��',20000,2)");
        //stmt.executeUpdate("Delete From ���u��ƪ� Where ���u�s��=18");
        
        //******************************************************
        
        
        //******************************************************
        //************** �d�߸�� ******************************
        //******************************************************
        
        ResultSet rs = stmt.executeQuery("Select * From ���u��ƪ�");
        System.out.println("���u�s��\t�m�W\t�a�}");
        while(rs.next()){
            System.out.print(rs.getInt("���u�s��")+"\t");
            System.out.print(rs.getString("�m�W")+"\t");
            System.out.println(rs.getString("�a�}"));
        }   
        //******************************************************
        
        db.closeConnection(conn);
        
        
        Stock stock = new Stock();
        String[] stocks = {"1101","1102","1103","1104","1109","1110"};
        
        for(String s:stocks) {
        	System.out.println("�Ѳ��N���G"+s+"�A�Ѳ�����"+stock.getValue(s));
        	//Thread.sleep(1000);
        }
    }
}