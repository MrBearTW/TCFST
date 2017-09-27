class BankAccount {
    private int balance = 5000;
    public int getBalance() {
        return balance;
    }
    public void withdraw(int amount) {
        balance = balance - amount;
    }
}

public class JayAndJolin implements Runnable {

    private BankAccount account = new BankAccount();

    public static void main (String [] args) {
        JayAndJolin  theJob = new JayAndJolin();
        Thread one = new Thread(theJob);
        Thread two = new Thread(theJob);
        one.setName("Jay");
        two.setName("Jolin");
        one.start();
        two.start();
    }

    public void run() {
        for(int x = 0; x < 500; x++) {
            makeWithdrawal(10);
            if(account.getBalance() < 0) {
                System.out.println("��L�Y�F!");
            }
        }
    }

    private synchronized void makeWithdrawal(int amount){    //synchronized
        if(account.getBalance() >= amount){
            System.out.println(Thread.currentThread().getName() + " �h����");
            try {
                System.out.println(Thread.currentThread().getName() + " �h��ı");
                Thread.sleep(100);
            } 
            catch(InterruptedException ex){ex.printStackTrace(); }
            System.out.println(Thread.currentThread().getName() + " �_��");
            account.withdraw(amount);
            System.out.println(Thread.currentThread().getName() + " ��������" + account.getBalance() );
        }
        else{
            System.out.println("��p�A�S������������ " + Thread.currentThread().getName());
        }
    }
}
