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