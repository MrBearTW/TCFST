public class TestThread extends Thread{
    public static void main(String[] args) {
        TestThread t = new TestThread();
        //t.start();
        t.run();
        TestThread t2 = new TestThread();
        t2.start();        
    }
    public void run(){
        for(int i = 0 ;i<500;i++){
            System.out.print(Thread.currentThread().getName()+":");
            System.out.println(i);
        }

    }
}