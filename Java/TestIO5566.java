import java.io.*;

public class TestIO5566{
    public static void main(String args[])throws FileNotFoundException,IOException{

        //BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\tcfst\\Desktop\\SantanderProductRecommendation\\ccccc.csv"));
        //BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\tcfst\\Desktop\\SantanderProductRecommendation\\ccccc2.csv"));
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\user\\Desktop\\TCFST\\ccccc.csv"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\user\\Desktop\\TCFST\\ccccc2.csv"));

        String ln = null;
        int x = 1;

        while((ln=br.readLine())!=null){
            
            String[] commas = ln.split(",");

            if((commas.length - 1)!=47){
            System.out.println(x+"  Number of commas: " + (commas.length - 1));
            //System.out.println(ln);
            String ln1 = ln.substring("\"", "\"");  //index
            System.out.println(ln1);

            }
            x = x+1;

            //System.out.println(ln);
            //bw.write(ln,0,ln.length());
            //bw.newLine();
        }

        br.close();
        bw.close();
    }
}