public class TestString2 {
    public static void main(String args[]) {
        long bt= System.currentTimeMillis();
        String tmp = "";
/*
        for(int i=0;i<1000000;i++){
            tmp =tmp +1;
        }
*/
        StringBuffer sb = new StringBuffer("");
        for(int i=0;i<100000000;i++){
            sb.append(i);
        }
        long et= System.currentTimeMillis();
        System.out.println(et-bt);
    }
    
}