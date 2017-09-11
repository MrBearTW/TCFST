import java.util.*;
public class TestDate {
    public static void main(String args[]) {
        Date  date  =        new         Date();
    //  類別  物件  指派   跟記憶體要空間  建構子
    // class object
        System.out.println(date.toString());

        String text = new String("Java");
		//類別 物件         建構子
		
		System.out.println(text.toUpperCase());
		System.out.println(text.toLowerCase());
		System.out.println(text.length());
		System.out.println(text.replace("J","L"));
        System.out.println(text);
        
        if(text.equals("Java") ){       //  ==  只能用在八種基本型態  String要用 equals來比較
			System.out.println("密碼正確");
		}
		else{
			System.out.println("密碼錯誤");
		}
    }  
}