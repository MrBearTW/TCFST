public class TestRunnable implements Runnable {

    public static void main(String[] args) {
        TestRunnable r1 = new TestRunnable();
        Thread t1 = new Thread(r1,"Thread t1");
        t1.start();

        TestRunnable r2 = new TestRunnable();
        Thread t2 = new Thread(r2);
        t2.start();
        t2.setName("Thread t2");

    }
    
    public void run(){
        for(int i = 0 ;i<500;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
            try{Thread.sleep(1000);
            }
            catch(InterruptedException IE){

            }
        }
    }
}