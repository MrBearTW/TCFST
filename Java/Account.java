public class Account{    //NO main ,Can not be executed

    //field
    private String accountNumber;
    private int balance;
    static int serialNumber=912;

    //constructor
    Account(String an,int b){
        this.accountNumber = an;
        this.balance = b;
        this.serialNumber++;
    }

    //method
    void withdraw(int m){
        balance=balance-m;
    }
    void deposit(int m){
        balance=balance+m;
    }
    int getBalance(){
        return balance;
    }
    String getAccountNumber(){
        return accountNumber;
    }

    int getSerialNumber(){
        return serialNumber;
    }
}