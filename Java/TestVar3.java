public class TestVar3{
    public static void main(String[] args) {
        System.out.println(7+3);  //10
        System.out.println(7-3);  //4
        System.out.println(7*3);  //21
        System.out.println(7/3);  //2
        System.out.println(7%3);  //1   取餘數  例如超過360度

        System.out.println(7> 3);
        System.out.println(7>=3);
        System.out.println(7< 3);
        System.out.println(7<=3);
        System.out.println(7==3);
        System.out.println(7!=3);

        //邏輯運算
        int nu = 87;
        System.out.println(nu>85 && nu<90);
        System.out.println(nu>85 || nu<90);
        System.out.println(nu>85 & nu<90);
        System.out.println(nu>85 | nu<90);

        //位元運算
        System.out.println(8&7);
        System.out.println(8|7);
        System.out.println(9&4);
        System.out.println(9|4);

        System.out.println(9^6);  //1001 ^ 0110  =>  1111
        System.out.println(3^7);  //0011 ^ 0011  =>  0100

        System.out.println(~3);
        System.out.println(Integer.toBinaryString(~3));

        System.out.println(1 << 2);  //0001 -> 0100   左移後  其他補0
        System.out.println("000"+Integer.toBinaryString(1));
        System.out.println("0"+Integer.toBinaryString(1 << 2));
        System.out.println(15 >> 2);  //0111 -> 0001   右移後  其他補原本的0或1
        System.out.println(Integer.toBinaryString(15));
        System.out.println("00"+Integer.toBinaryString(15 >> 2));

        System.out.println(-9>>>2);  
        System.out.println(Integer.toBinaryString(-9));
        System.out.println("00"+Integer.toBinaryString(-9>>>2));
        // System.out.println(Integer.toBinaryString(-9>>>2));  前面是零會不見

        int a=3;
        int b=7;
        System.out.println(a++ > 3 && --b < 7);
        System.out.println(a);
        System.out.println(b);

        a=3;
        b=7;
        System.out.println(++a > 3 || b-- < 7);
        System.out.println(a);
        System.out.println(b);    
/*
&& || 為短路運算子
&& 一者為false，則全為false
|| 一者為true ，則全為true
*/
        a=3;
        b=7;
        System.out.println(a++ > 3 & --b < 7);
        System.out.println(a);
        System.out.println(b);

        a=3;
        b=7;
        System.out.println(++a > 3 | b-- < 7);
        System.out.println(a);
        System.out.println(b);
    }
}