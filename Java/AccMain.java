public class AccMain {
    public static void main(String args[]) {
        Account acc = new Account("9487-8989174",1000);
        Account acc2 = new Account("5566-1111111",5656);
        //acc.accountNumber="9487-8989174";
        //acc.balance=1000;

        acc.withdraw(17);
        acc.deposit(77);
        acc.serialNumber();

        System.out.println(acc.getAccountNumber());
        System.out.println(acc.getBalance());
        System.out.println(acc.getSerialNumber());    
        
        System.out.println(acc2.getAccountNumber());
        System.out.println(acc2.getBalance());
        System.out.println(acc2.getSerialNumber());
    }   
}