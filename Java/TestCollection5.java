import java.util.*;

public class TestCollection5 {
    public static void main(String args[]){
        Properties ps =System.getProperties();

        //System.out.println(ps);      //See all element in system

        //System.out.println(ps.get("java.runtime.name"));
        //System.out.println(ps.get("java.vm.version"));


        for(Object key:ps.keySet()){
            System.out.println("Key=  "+key+"     ,Value=  "+ps.get(key));
        }
    }
}