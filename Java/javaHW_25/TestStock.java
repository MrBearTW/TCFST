import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestStock {
	public static void main(String args[]) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		String[] stocks = { "1101", "1102", "1103", "1104", "1110", "6024", "2330", "3008", "6214" };
		for (String stockNumber : stocks) {
			URL url = new URL("https://tw.stock.yahoo.com/q/q?s=" + stockNumber);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			StringBuffer sb = new StringBuffer();
			String str = "";
			while ((str = br.readLine()) != null) {
				sb.append(str);
				if (str.contains("</b></td>"))
					break;
			}
			int x = sb.indexOf("nowrap><b>") + "nowrap><b>".length();
			int y = sb.indexOf("</b></td>");
			System.out.println(stockNumber + ":" + sb.substring(x, y));
			map.put(stockNumber, sb.substring(x, y));
			br.close();
			conn.disconnect();
		}
		DBSource db = new DBSourceImplement();
		Connection conn = db.getConnection();
		String table = "stocks";
		db.creatTable(conn, table);
		db.modifyTable(conn, table, map);
		db.closeConnection(conn);
	}

}

//執行的時候要帶jar檔的位置給他 java -cp .;C:\JavaSpace\Java\mysql-connector-java-5.1.44\mysql-connector-java-5.1.44-bin.jar TestStock