public class TestVar4 {
    public static void main(String args[]) {
        int i=5;
        int j=5;
        System.out.println(i++);  //�����ȡA�A�[�@
        System.out.println(i);
        System.out.println(++j);  //���[�@�A�A����       
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