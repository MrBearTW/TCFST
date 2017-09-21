public class TestObj{
    public static void main(String args[]) {
        TestObj obj =new TestObj();

        System.out.println(obj.toString());
        System.out.println(obj.hashCode());

        Integer i = new Integer(10);
        String s = new Str("HIHIHIHI");
        System.out.println(i.toString());
        System.out.println(s.toString());

    }

    public String toString(){
        return "test class";     //override toString
    }
}