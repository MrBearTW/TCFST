import java.io.*;

public class TestIO4{
    public static void main(String args[])throws FileNotFoundException,IOException{
        FileReader fr = new FileReader("C:\\JavaSpace\\Java\\kingsman.jpg");
        FileWriter fw = new FileWriter("C:\\JavaSpace\\Java\\kingsman4.jpg");

        int ch = -1;

        while((ch=fr.read())!=-1){
            System.out.println("ch= "+ch+"    char(ch)="+(char)ch+"  Binary="+Integer.toBinaryString(ch));
            fw.write(ch);
        }

        fr.close();
        fw.close();
    }
}

// scaner write into files