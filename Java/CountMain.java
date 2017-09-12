public class CountMain{
    public static void main(String args[]) {
        Counter c1 =new Counter();
        Counter c2 =new Counter();
        Counter c3 =new Counter();

        System.out.println(c1.getSN()+" "+c3.getNumber());
        System.out.println(c2.getSN()+" "+c2.getNumber());
        System.out.println(c3.getSN()+" "+c3.getNumber());
        
        //add "static" before "getSN" at class Counter
        //can call getSN by Counter.getSN()
        System.out.println(Counter.getSN());
        
    }
    
}