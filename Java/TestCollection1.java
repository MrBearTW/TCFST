import java.util.*;

public class TestCollection1 {

    public static void main (String args[]) {
        //Set s = new HashSet();
        //List s = new ArrayList();    //got order & can repeat
        LinkedList s = new LinkedList();

        s.add(9);
        s.add("JohnCena");
        s.add(4.0);
        s.add(true);
        s.add(9);         //no use
        
        //System.out.println(s);

        s.addFirst(9487);   //only use in LinkedList

        for(Object o : s){    //use "object" to combine "int double string boolean" 
            System.out.println(o);
        }

        //Iterator it = s.iterator();
        //while (it.hasNext()) {
        //    System.out.println(it.next());    
        //}
    }
}
/*
Note is unsafe
*/