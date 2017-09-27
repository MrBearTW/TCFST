public class TestThread extends Thread{
    public static void main(String[] args) {
        TestThread t = new TestThread("T1");
        t.start();
        //t.run();    //use"run"will be  main
        TestThread t2 = new TestThread("T2");
        t2.start();

        //main is another thread
        /*
        for(int i = 0 ;i<500;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
        */
    }

    //gave thread a name
    TestThread(String name){
        super(name);
    }

    public void run(){
        for(int i = 0 ;i<500;i++){
            System.out.println(Thread.currentThread().getName()+":"+i+"    "+Thread.currentThread().getId());
            //System.out.println(i);
        }

    }
}