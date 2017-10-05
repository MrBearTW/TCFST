import java.io.*;

public class lazy{
    public static void main(String args[])throws FileNotFoundException,IOException{

        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\tcfst\\Desktop\\SantanderProductRecommendation\\lazzy3.csv"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\tcfst\\Desktop\\SantanderProductRecommendation\\lazzy4.csv"));

        String ln = null;


        while((ln=br.readLine())!=null){
            
            //String ln1 = "COUNT(DISTINCT"+ln+")"+",";  //lazzy1 --> 2
            String ln2 = "COUNT(DISTINCT "+ln+")"+",";  //lazzy3 --> 4
            
            //System.out.println(ln);
            bw.write(ln2,0,ln2.length());

            //bw.newLine();
        }

        br.close();
        bw.close();
    }
}