import java.util.*;

class Account {
    private String accountHolder;
    private double balance;
    private List<String> transactionHistory;

    // Constructor
    public Account(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: " + balance);
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: " + amount);
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Invalid amount!");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else if (amount <= 0) {
            System.out.println("Invalid amount!");
        } else {
            balance -= amount;
            transactionHistory.add("Withdrawn: " + amount);
            System.out.println("Withdrawal successful!");
        }
    }

    // Check balance
    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    // Show transaction history
    public void showTransactions() {
        System.out.println("\n--- Transaction History ---");
        for (String t : transactionHistory) {
            System.out.println(t);
        }
    }
}

public class BankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();

        System.out.print("Enter initial balance: ");
        double initialBalance = sc.nextDouble();

        Account acc = new Account(name, initialBalance);

        int choice;

        do {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double dep = sc.nextDouble();
                    acc.deposit(dep);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double wd = sc.nextDouble();
                    acc.withdraw(wd);
                    break;

                case 3:
                    acc.checkBalance();
                    break;

                case 4:
                    acc.showTransactions();
                    break;

                case 5:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}