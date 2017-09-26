import java.util.*;

public class TestCollection31 {

    public static void main (String args[]) {
        Set<Integer> s= new HashSet<Integer>();   //use whipper function

        s.add(9);
        s.add(4);
        s.add(8);
        //s.add("Colin Firth");

        for(Integer o : s){ 
            System.out.println(o);
        }
    }
}
