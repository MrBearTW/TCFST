public class TestException4 {
    public static void main(String[] args) throws Exception{
        System.out.println("Salary:"+getBalance(-5566));           
    }

    static int getBalance(int n) throws Exception{
        //...
        if(n<0){
            throw new Exception("Salary should not <0");
        }
        return n;
    }
}