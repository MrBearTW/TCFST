import java.util.*;

public class TestCollection2 {

    public static void main (String args[]) {
        List s = new ArrayList();

        s.add(9);
        s.add("JohnCena");
        s.add(4.0);
        s.add(87);
        
        //System.out.println(s);

        for(int i=0;i<s.size();i++){
            System.out.println(s.get(i));
        }

        /*
        Iterator it = s.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());           
        }
        */
    }
}
