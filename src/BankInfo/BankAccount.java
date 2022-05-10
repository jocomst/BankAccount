package BankInfo;

public class BankAccount {
    private double balance;
    private String accountHolder;

    public BankAccount(double balance, String accountHolder) {
        this.balance = balance;
        this.accountHolder = accountHolder;
    }

    public void deposit(double money) {
        this.balance += money;
    }

    public void withdrawal(double money) {
        this.balance -= money;
    }

    @Override
    public String toString() {
        return this.accountHolder + "'s Account Balance: " + this.balance;
    }


}
