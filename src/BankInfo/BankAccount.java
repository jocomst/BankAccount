package BankInfo;

import com.sun.security.jgss.GSSUtil;

public class BankAccount implements ScannerFactory {
    private double balance;
    private String accountHolder;
    private int accountNumber;

    public BankAccount(double balance, String accountHolder, int accountNumber){
        this.balance = balance;
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
    }

    public BankAccount() {
        String[] results = this.bankIntro();
        this.accountHolder = results[0];
        this.balance = Double.valueOf(results[1]);
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String[] bankIntro() {
        System.out.println("What is the name for the account?");
        String name = scan.nextLine();
        System.out.println("What is the beginning balance for the account?");
        String balance = scan.nextLine();
        return new String[]{name, balance};
    }
    public void deposit(double money) {
        this.balance += money;
    }

    public boolean withdrawal(double money) {
        if (this.balance >= money) {
            this.balance -= money;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String toString() {
        return this.accountHolder + "'s Account Balance: " + this.balance;
    }


}
