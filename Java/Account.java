public class Account{
    //NO main ,NO go
    //field
    private String accountNumber;
    private int balance;

    //constructor
    Account(String an,int b){
        this.accountNumber = an;
        this.balance = b;
        
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
}