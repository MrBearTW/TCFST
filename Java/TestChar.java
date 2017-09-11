public class TestChar{
    public static void main(String args[]){
        char ch1 = 'A';
        char ch2 = '\'';  // \ Escape

        System.out.println(ch1);
        System.out.println(ch2);
        System.out.println((int)ch2);
        System.out.println(Integer.toBinaryString(ch2));
    }
}