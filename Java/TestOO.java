public class TestOO{
    public static void main(String args[]){
        Object o = new String("Hello");
        System.out.println(o);
        System.out.println(o.toString());

        String s = (String)o;
        System.out.println(s);
        System.out.println(s.toUpperCase());

        Integer i = new Integer(10);
        Double d = new Double(1.0);
        test(s);
        test(i);
        test(d);
        Boolean bool = new Boolean(true);
        test(bool);
    }

    static void test(Object o){
    //    System.out.println("test Polymorphism is called");

        if(o instanceof String){
            System.out.println("test Polymorphism is String");
        }
        else if(o instanceof Integer){
            System.out.println("test Polymorphism is Integer");
        }
        else if(o instanceof Double){
            System.out.println("test Polymorphism is Double");
        }
        else{
            System.out.println("test Polymorphism is not support this type");
        }
    }
}