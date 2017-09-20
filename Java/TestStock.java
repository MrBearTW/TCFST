import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestStock {
    public static void main(String args[])throws Exception  {
        URL url = new URL("https://tw.stock.yahoo.com/q/q?s=" + args[0]);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
        String str = "";
        StringBuffer sb = new StringBuffer();
        while ( (str=br.readLine()) !=null) {
            //sb.append(str);
            if(str.contains("nowrap><b>"))
                System.out.println(str);
        }
        br.close();
        conn.disconnect();
        //System.out.print(sb.toString());
    }
    
}