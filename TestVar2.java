public class TestVar2{
    public static void main(String args[]){
        System.out.println(10/3);
        System.out.println(10/3.0);
        System.out.println((double)10/3);
        System.out.println((double)(10/3));
        System.out.println((float)10/3);
        System.out.println((float)(10/3));

        System.out.println((int)'A');   //65
        System.out.println('A'+1);      //66
        System.out.println((int)'B');   //66
        System.out.println((int)'?');   //63
        System.out.println((int)'a');   //97
        System.out.println((int)'b');   //98
        System.out.println((char)68);   //D
        System.out.println((char)68+1); //69
        System.out.println((char)69);   //E
    }
}