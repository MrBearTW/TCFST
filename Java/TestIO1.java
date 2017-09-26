import java.io.*;

public class TestIO1{
    public static void main(String args[]){
        //File file = new File("C:\\JavaSpace\\Java\\testIO.txt");
        File file = new File("C:\\Users\\user\\Documents\\GitHub\\TCFST\\Java\\testIO.txt");
        System.out.println("Read:"+file.canRead());
        System.out.println("Write:"+file.canWrite());
        System.out.println("Size:"+file.getTotalSpace());
        System.out.println("Size:"+file.length());
    }
}

//  https://docs.oracle.com/javase/7/docs/api/java/io/File.html