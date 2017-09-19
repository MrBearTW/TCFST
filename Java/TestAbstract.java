public class TestAbstract {
    public  static void main(String args[]) {
        Mobile m1 = new Apple();
        Mobile m2 = new hTC();
        m1.unlock();
        m2.unlock();
    }
}
abstract class Mobile{
    void conn(){
        System.out.println("connatect");
    }
    void disconn(){
        System.out.println("disconn");
    }
    abstract void unlock();
}
class Apple extends Mobile{
    void unlock(){
        System.out.println("Apple unlock");
    }
}
class hTC extends Mobile{
    void unlock(){
        System.out.println("hTC Byebye");
    }
}