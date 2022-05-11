package BankInfo;

import java.util.ArrayList;

public class Main implements ScannerFactory{
    private static BankAccount currentUser;
    private static ArrayList<BankAccount> bankAccountList = new ArrayList<>();

    public static void main(String[] args) {

        while (true) {
            System.out.println("Hello world! Welcome to the Bank of Banks!");
            System.out.println("Are you an existing customer? (-1 to exit)");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int choice = Integer.valueOf(scan.nextLine());
            if (choice == 1) {
                System.out.println("What is your name?");
                String name = scan.nextLine();
                for (BankAccount b : bankAccountList) {
                    if (b.getAccountHolder().equalsIgnoreCase(name)) {
                        currentUser = b;
                        mainMenu(b);
                    }
                }

            } else if (choice == 2) {
                System.out.println("Let's make a new account!");
                BankAccount newBank = new BankAccount();
                bankAccountList.add(newBank);
                newBank.setAccountNumber(bankAccountList.size());
                currentUser = newBank;
                mainMenu(newBank);
            } else if (choice == -1) {
                break;
            }
        }
    }

    public static void mainMenu(BankAccount bank) {
        while (true) {
            System.out.println("Hello " + bank.getAccountHolder() + "!");
            System.out.println("Welcome to the Main Menu, what would you like to do today?");
            System.out.println("1. To check account balance");
            System.out.println("2. To make a withdrawal");
            System.out.println("3. To make a deposit");
            System.out.println("4. To make a transfer to another account");
            System.out.println("5. To exit");
            int choice = Integer.valueOf(scan.nextLine());

            if (choice == 1) {
                System.out.println(currentUser);
            } else if (choice == 2) {
                System.out.println("How much would you like to withdraw?");
                double withdraw = Double.valueOf(scan.nextLine());
                currentUser.withdrawal(withdraw);
            } else if (choice == 3) {
                System.out.println("How much would you like to deposit?");
                double deposit = Double.valueOf(scan.nextLine());
                currentUser.deposit(deposit);
            } else if (choice == 4) {
                System.out.println("Please enter the account number to transfer to");
                int accountNum = Integer.valueOf(scan.nextLine()) - 1;
                if (accountNum < 0 || accountNum > bankAccountList.size()) {
                    System.out.println("No account found :(");
                } else {
                    System.out.println("How much would you like to transfer?");
                    double amount = Double.valueOf(scan.nextLine());
                    transfer(bankAccountList.get(accountNum), amount);
                }
            } else if (choice == 5) {
                break;
            }
        }
    }

    public static void transfer(BankAccount to, double amount) {
        if (currentUser.withdrawal(amount)) {
            to.deposit(amount);
        } else {
            System.out.println("Transaction failed");
        }

    }
}
