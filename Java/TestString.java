public class TestString {
    public static void main(String args[]) {
        String str1 = "Hello";      //str1 str2 link together in  String pool
        String str2 = "Hello";
        String str3 = new String("Hello");
        String str4 = new String("Hello");

        System.out.println(str1==str2);
        System.out.println(str3==str4);
        System.out.println(str1==str3);
        System.out.println(str1==str4);
        System.out.println(str1.equals(str3));  //use equals to compare two strings
        
    }
    
}