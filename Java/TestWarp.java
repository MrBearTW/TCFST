public class TestWarp{
	public static void main(String args[]){
        int i=10;
        Integer I1 = new Integer(i);
        Integer I2 = new Integer(20);
        System.out.println(i/3); 
        System.out.println((double)i/3);
        System.out.println(I1.doubleValue()/3);
        System.out.println(I1.compareTo(I2));

        Integer I3 = 128;
        Integer I4 = 128;
        System.out.println(I3 == I4);
        //自動裝箱時對於值從-128到127之間的值，它們被裝箱為Integer物件後，會存在記憶體之中被重用
	}
}