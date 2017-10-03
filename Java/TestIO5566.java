import java.io.*;

public class TestIO5566{
    public static void main(String args[])throws FileNotFoundException,IOException{

        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\tcfst\\Desktop\\SantanderProductRecommendation\\ccccc.csv"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\tcfst\\Desktop\\SantanderProductRecommendation\\ccccc2.csv"));

        String ln = null;

        while((ln=br.readLine())!=null){

            String[] commas = ln.split(",");
            System.out.println("Number of commas: " + (commas.length - 1));
            


            //System.out.println(ln);
            //bw.write(ln,0,ln.length());
            //bw.newLine();
        }

        br.close();
        bw.close();
    }
}