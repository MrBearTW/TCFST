import java.util.*;
public class TestScan{
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("*[國小有學過加法嗎？]*");
		System.out.print("請輸入第一個數字：");
        int num1 = scan.nextInt();
		System.out.print("請輸入第二個數字：");
        int num2 = scan.nextInt();
        System.out.print("加起來是：");
        System.out.println(num1+num2);
    }
}