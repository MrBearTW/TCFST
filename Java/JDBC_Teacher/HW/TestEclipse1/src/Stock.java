import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Stock{
    public String getValue(String stockNumber) throws Exception{
        URL url = new URL("https://tw.stock.yahoo.com/q/q?s="+stockNumber);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader
                                    (conn.getInputStream(),"UTF-8"));
        String str = "";
        StringBuffer sb = new StringBuffer();
        while( (str=br.readLine()) != null){
            sb.append(str);
            if(str.contains("</b></td>"))
                break;
        }
        
        int x = sb.indexOf("nowrap><b>")+ "nowrap><b>".length();
        int y = sb.indexOf("</b></td>");
        //System.out.println(sb.substring(x,y));
        br.close();
        conn.disconnect();   
        return sb.substring(x,y);
    }
}