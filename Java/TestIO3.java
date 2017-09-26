import java.io.*;

public class TestIO3{
    public static void main(String args[])throws FileNotFoundException,IOException{
        FileInputStream fis = new FileInputStream("C:\\JavaSpace\\Java\\kingsman.jpg");
        FileOutputStream fos = new FileOutputStream("C:\\JavaSpace\\Java\\kingsman3.jpg");

        int ch = -1;

        while((ch=fis.read())!=-1){
            System.out.println("ch= "+ch+"    char(ch)="+(char)ch+"  Binary="+Integer.toBinaryString(ch));
            fos.write(ch);
        }
    }
}
