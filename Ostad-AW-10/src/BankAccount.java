class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Withdrawal amount exceeds balance or is invalid.");
        }
    }

    public double getBalance() {
        return balance;
    }
}

class SavingsAccount extends BankAccount {
    private static final double WITHDRAWAL_LIMIT = 1000;
    private static final double WITHDRAWAL_FEE = 2.50;

    public SavingsAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > WITHDRAWAL_LIMIT) {
            System.out.println("Withdrawal exceeds the limit for Savings Account.");
        } else {
            super.withdraw(amount + WITHDRAWAL_FEE);
            System.out.println("Fee charged: " + WITHDRAWAL_FEE);
        }
    }
}

class CheckingAccount extends BankAccount {
    private static final double WITHDRAWAL_FEE = 1.00;

    public CheckingAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount + WITHDRAWAL_FEE);
        System.out.println("Fee charged: " + WITHDRAWAL_FEE);
    }
}

public class Main {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount(1000);
        CheckingAccount checking = new CheckingAccount(1000);

        System.out.println("Savings Account Balance: " + savings.getBalance());
        savings.deposit(200);
        savings.withdraw(300);
        System.out.println("Savings Account Balance: " + savings.getBalance());

        System.out.println("\nChecking Account Balance: " + checking.getBalance());
        checking.deposit(500);
        checking.withdraw(200);
        System.out.println("Checking Account Balance: " + checking.getBalance());
    }
}
