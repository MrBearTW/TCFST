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
        //************** 異動資料 ******************************
        //******************************************************
        //stmt.executeUpdate("Insert into 員工資料表 values(18,'王小明','男','新竹市清華大學',20000,2)");
        //stmt.executeUpdate("Delete From 員工資料表 Where 員工編號=18");        
        //******************************************************
        
        
        //******************************************************
        //************** 查詢資料 ******************************
        //******************************************************
        
        ResultSet rs = stmt.executeQuery("Select * From 員工資料表");
        System.out.println("員工編號\t姓名\t地址");
        while(rs.next()){
            System.out.print(rs.getInt("員工編號")+"\t");
            System.out.print(rs.getString("姓名")+"\t");
            System.out.println(rs.getString("地址"));
        }    
        //******************************************************
        
        db.closeConnection(conn);
        
        
        Stock stock = new Stock();
        String[] stocks = {"1101","1102","1103","1104","1109","1110","3008","6024","2330","2317"};
        
        for(String s:stocks) {
        	System.out.println("股票代號："+s+"，股票價格"+stock.getValue(s));
        	//Thread.sleep(1000);
        }
    }
}