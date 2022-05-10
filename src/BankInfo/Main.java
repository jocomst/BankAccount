package BankInfo;

public class Main {
    public static void main(String[] args) {
        BankAccount bank = new BankAccount(500, "John Comstock");
        bank.deposit(100);
        System.out.println(bank);

        BankAccount larryBank = new BankAccount(5000, "Larry");
        BankAccount maryBank = new BankAccount(300, "Mary");
        larryBank.withdrawal(100);
        maryBank.deposit(100);

        System.out.println(larryBank);
        System.out.println(maryBank);

        Product gasoline = new Product(4.09, 12, "gallon of gas");
        gasoline.printProduct();
        gasoline.totalCost();
    }
}
