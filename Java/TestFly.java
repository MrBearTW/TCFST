public class TestFly{
    public static void main(String args[]){
        Fly f1 = new airPlane();
        Fly f2 = new superMan();
        f1.fly();
        f2.land();
    }
}
class airPlane implements Fly{
    public void fly(){       // muist be public
        System.out.println("airPlane Fly");
    }
    public void land(){
        System.out.println("airPlane Land");    
    }
}
class superMan implements Fly{
    public void fly(){
        System.out.println("superMan Fly");
    }
    public void land(){
        System.out.println("superMan Land");    
    }
}