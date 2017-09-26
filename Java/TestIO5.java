import java.io.*;

public class TestIO5{
    public static void main(String args[])throws FileNotFoundException,IOException{
        //FileReader fr = new FileReader("C:\\JavaSpace\\Java\\testIO.txt");
        BufferedReader br = new BufferedReader(new FileReader("C:\\JavaSpace\\Java\\testIO.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\JavaSpace\\Java\\testIO5.txt"));

        String ln = null;

        while((ln=br.readLine())!=null){
            System.out.print("ln= "+ln+"  ");
            bw.write(ln,0,ln.length());
            //bw.write(ln,1,ln.length()-1);     //https://docs.oracle.com/javase/7/docs/api/java/io/BufferedWriter.html#write(java.lang.String,%20int,%20int)
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}

// read the whole line in 

//+"    char(ln)="+(char)ln+"  Binary="+Integer.toBinaryString(ln)