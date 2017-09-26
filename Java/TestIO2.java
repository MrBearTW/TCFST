import java.io.*;


public class TestIO2{
    public static void main(String args[]){
        File file = new File("C:\\");
        File[] fs = file.listFiles();
        
        System.out.println("files filess filesss");
        for(File f:fs){
            if(f.isFile() && f.getName().contains(".txt")){
                System.out.println(f.getName());
            }
        }

        System.out.println("Folder");
        for(File f:fs){
            if(f.isDirectory()){
                System.out.println(f);
            }
        }
    }
}

// find all in you computer