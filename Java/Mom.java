// http://192.168.168.209:8080/
public class Mom extends Thread{
    public static void main(String args[]){
        Mom m = new Mom();
        m.start();
    }
    public void run(){
        System.out.println("�ǳƭX�Ī���...");
        try{Thread.sleep(500);}catch(Exception e){}
        System.out.println("�o�{�S���X��...");
        try{Thread.sleep(500);}catch(Exception e){}
        System.out.println("�Ш�l�R�X��...");
        try{Thread.sleep(500);}catch(Exception e){}
        Son s = new Son();
        s.start();
        //s.join();
        //try{s.join();}catch(Exception e){}
        s.join();
        System.out.println("����R�X��...");
        try{Thread.sleep(500);}catch(Exception e){}
        System.out.println("�����X�Ī���...");
        try{Thread.sleep(500);}catch(Exception e){}
    }
}
class Son extends Thread{
    public void run(){
        System.out.println("\t�R�X��...");
        try{Thread.sleep(500);}catch(Exception e){}
        System.out.println("\t�R��X��...");
        try{Thread.sleep(500);}catch(Exception e){}
    }
}