public class Counter {
    private static int SN;
    private int number;

    Counter(){
        SN++;
        number = SN;
    }

    static int getSN(){
        return SN;
    }

    int getNumber(){
        return number;
    }


}