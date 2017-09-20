import java.util.*;

public class TestCollection1 {

    public static void main (String args[]) {
        Set s = new HashSet();

        s.add(9);
        s.add("JohnCena");
        s.add(4.0);
        s.add(87);
        
        //System.out.println(s);

        Iterator it = s.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            
        }
    }
}
/*
Note is unsafe
*/