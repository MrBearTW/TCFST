import java.util.*;
public class TestDate {
    public static void main(String args[]) {
        Date  date  =        new         Date();
    //  ���O  ����  ����   ��O����n�Ŷ�  �غc�l
    // class object
        System.out.println(date.toString());

        String text = new String("Java");
		//���O ����         �غc�l
		
		System.out.println(text.toUpperCase());
		System.out.println(text.toLowerCase());
		System.out.println(text.length());
		System.out.println(text.replace("J","L"));
        System.out.println(text);
        
        if(text.equals("Java") ){       //  ==  �u��Φb�K�ذ򥻫��A  String�n�� equals�Ӥ��
			System.out.println("�K�X���T");
		}
		else{
			System.out.println("�K�X���~");
		}
    }  
}