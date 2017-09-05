public class TestVar{
    public static void main(String args[]){
        byte   b = 11;//-128~127
        short  s = 22;//-32768~32767
        int    i = Integer.MAX_VALUE;//-2147483648~2147483647
        long   l = Long.MAX_VALUE;
        System.out.println(b);
        System.out.println(s);
        System.out.println(i+1);
        System.out.println(l);
        
        float  f = 1.0f;//java遇到小數預設就是64位元的double,後面加f或F強迫為float
        double d = 2.0d;
        float  f2 = Float.MAX_VALUE;
        float  f3 = Float.MAX_VALUE;
        double d2 = Double.MIN_VALUE;
        double d3 = Double.MIN_VALUE;
        System.out.println(f);
        System.out.println(d);
        System.out.println(f2);
        System.out.println(d2);
        System.out.println(f3);
        System.out.println(d3);

        char    ch   = 'A';  //是''  不是""
        boolean bool = false;
        System.out.println(ch);
        System.out.println(bool);
    }
}