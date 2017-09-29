import java.util.*;

public class TestCollection3 {

    public static void main (String args[]) {
        Set<String> s = new HashSet<String>();

        s.add("Taron Egerton");
        s.add("John Cena");
        s.add("Mark Strong");
        s.add("Colin Firth");

        //s.add(9);        // only accept String

        for(String o : s){ 
            System.out.println(o.toUpperCase());
        }
    }
}
