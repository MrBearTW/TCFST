public class TestVar3{
    public static void main(String[] args) {
        System.out.println(7+3);  //10
        System.out.println(7-3);  //4
        System.out.println(7*3);  //21
        System.out.println(7/3);  //2
        System.out.println(7%3);  //1   ���l��  �Ҧp�W�L360��

        System.out.println(7> 3);
        System.out.println(7>=3);
        System.out.println(7< 3);
        System.out.println(7<=3);
        System.out.println(7==3);
        System.out.println(7!=3);

        //�޿�B��
        int nu = 87;
        System.out.println(nu>85 && nu<90);
        System.out.println(nu>85 || nu<90);
        System.out.println(nu>85 & nu<90);
        System.out.println(nu>85 | nu<90);

        //�줸�B��
        System.out.println(8&7);
        System.out.println(8|7);
        System.out.println(9&4);
        System.out.println(9|4);

        System.out.println(9^6);  //1001 ^ 0110  =>  1111
        System.out.println(3^7);  //0011 ^ 0011  =>  0100

        System.out.println(~3);
        System.out.println(Integer.toBinaryString(~3));

        System.out.println(1 << 2);  //0001 -> 0100   ������  ��L��0
        System.out.println("000"+Integer.toBinaryString(1));
        System.out.println("0"+Integer.toBinaryString(1 << 2));
        System.out.println(15 >> 2);  //0111 -> 0001   �k����  ��L�ɭ쥻��0��1
        System.out.println(Integer.toBinaryString(15));
        System.out.println("00"+Integer.toBinaryString(15 >> 2));

        System.out.println(-9>>>2);  
        System.out.println(Integer.toBinaryString(-9));
        System.out.println("00"+Integer.toBinaryString(-9>>>2));
        // System.out.println(Integer.toBinaryString(-9>>>2));  �e���O�s�|����

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
&& || ���u���B��l
&& �@�̬�false�A�h����false
|| �@�̬�true �A�h����true
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