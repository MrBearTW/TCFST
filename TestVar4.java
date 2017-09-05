public class TestVar4 {
    public static void main(String args[]) {
        int i=5;
        int j=5;
        System.out.println(i++);  //先取值，再加一
        System.out.println(i);
        System.out.println(++j);  //先加一，再取值       
        System.out.println(j);

        int m=5;
        int n=5;
        System.out.println(m--);
        System.out.println(m);
        System.out.println(--n);
        System.out.println(n);
        
        int x=5;
        int y=5;
        System.out.println(x++ + --y + y-- + ++x);  //  5 + 4 + 4 + 7 

    }
    
}