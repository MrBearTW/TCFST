import java.util.*;

public class TestCollection4 {
    public static void main(String args[]){
        Map m = new HashMap();

        m.put("Lang","JAVA");
        m.put("ver",18.3);
        m.put("name","Colin Firth");

        System.out.println(m);

        Object m1 = m.get("name");
        System.out.println(m1);
        System.out.println(m.get("name"));

        /*
        //Set ks = m.keySet();
        //Iterator it =ks.iterator();
        Iterator it = m.keySet().iterator();   //up two become one
        while(it.hasNext()){
            Object o = it.next();
            System.out.println("Key="+o+",Value="+m.get(o));
        }
            */
        for(Object key:m.keySet()){
            System.out.println("Key="+key+",Value="+m.get(key));
        
        }
    }
}