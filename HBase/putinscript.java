import java.io.*;

public class putinscript{
    public static void main(String args[])throws FileNotFoundException,IOException{

        BufferedReader br = new BufferedReader(new FileReader("C:\\2FCTEACHER\\share\\HBase\\ExchangeRate201707141441.csv"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\2FCTEACHER\\share\\HBase\\lazzpeople.txt"));

        String ln = null;


        while((ln=br.readLine())!=null){
            
            //String ln1 = "COUNT(DISTINCT"+ln+")"+",";  //lazzy1 --> 2
            //String ln2 = "COUNT(DISTINCT "+ln+")"+",";  //lazzy3 --> 4
            
            System.out.println(ln);
            //bw.write(ln2,0,ln2.length());

            //bw.newLine();
        }

        br.close();
        bw.close();
    }
}