/**
 * Exercise 13: Polymorphism - Banking System
 * PT821 - Object-Oriented Programming
 * SUZA
 */

// ============================================
// BASE CLASS
// ============================================
class BankAccount {

    protected String accountNumber;
    protected String accountHolder;
    protected double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited TZS " + amount +
                    ". New balance: TZS " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew TZS " + amount +
                    ". New balance: TZS " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: TZS " + balance);
        System.out.println("Account Type: " + this.getClass().getSimpleName());
    }

    public double calculateInterest() {
        return 0;
    }
}

// ============================================
// SAVINGS ACCOUNT
// ============================================
class SavingsAccount extends BankAccount {

    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolder,
                          double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        return balance * interestRate;
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= 10000) {
            balance -= amount;
            System.out.println("Withdrew TZS " + amount +
                    ". New balance: TZS " + balance);
        } else {
            System.out.println("Minimum balance of TZS 10,000 required.");
        }
    }

    public void applyInterest() {
        double interest = calculateInterest();
        balance += interest;
        System.out.println("Interest of TZS " + interest +
                " applied. New balance: TZS " + balance);
    }
}

// ============================================
// CURRENT ACCOUNT
// ============================================
class CurrentAccount extends BankAccount {

    private double overdraftLimit;

    public CurrentAccount(String accountNumber, String accountHolder,
                          double balance, double overdraftLimit) {
        super(accountNumber, accountHolder, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance + overdraftLimit) {
            balance -= amount;
            System.out.println("Withdrew TZS " + amount +
                    ". New balance: TZS " + balance);
        } else {
            System.out.println("Overdraft limit exceeded.");
        }
    }

    @Override
    public double calculateInterest() {
        return 0;
    }

    public boolean isOverdrawn() {
        return balance < 0;
    }
}

// ============================================
// FIXED DEPOSIT ACCOUNT
// ============================================
class FixedDepositAccount extends BankAccount {

    private double interestRate;
    private int maturityMonths;
    private boolean isMatured;

    public FixedDepositAccount(String accountNumber, String accountHolder,
                               double balance, double interestRate,
                               int maturityMonths) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
        this.maturityMonths = maturityMonths;
        this.isMatured = false;
    }

    @Override
    public double calculateInterest() {
        return balance * interestRate * (maturityMonths / 12.0);
    }

    @Override
    public void withdraw(double amount) {
        if (isMatured) {
            super.withdraw(amount);
        } else {
            System.out.println("Cannot withdraw. Account not matured.");
        }
    }

    public void checkMaturity() {
        if (maturityMonths >= 12) {
            isMatured = true;
        }
    }

    public double getMaturityAmount() {
        return balance + calculateInterest();
    }
}

// ============================================
// BANK CLASS
// ============================================
class Bank {

    private BankAccount[] accounts;
    private int count = 0;

    public Bank(int size) {
        accounts = new BankAccount[size];
    }

    public void addAccount(BankAccount account) {
        accounts[count++] = account;
    }

    public double getTotalDeposits() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += accounts[i].getBalance();
        }
        return total;
    }

    public double getTotalInterest() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += accounts[i].calculateInterest(); // polymorphism
        }
        return total;
    }

    public void displayAllAccounts() {
        for (int i = 0; i < count; i++) {
            accounts[i].displayAccountInfo();
            System.out.println("---------------------");
        }
    }

    public BankAccount findAccount(String accountNumber) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].accountNumber.equals(accountNumber)) {
                return accounts[i];
            }
        }
        return null;
    }
}

// ============================================
// MAIN CLASS + METHOD OVERLOADING
// ============================================
public class Polymorphism {

    // Overloaded Methods
    public static void transferMoney(BankAccount from,
                                     BankAccount to,
                                     double amount) {
        from.withdraw(amount);
        to.deposit(amount);
        System.out.println("Transfer completed.");
    }

    public static void transferMoney(BankAccount from,
                                     BankAccount to,
                                     double amount,
                                     String description) {
        System.out.println("Description: " + description);
        transferMoney(from, to, amount);
    }

    public static void transferMoney(BankAccount from,
                                     String toAccountNumber,
                                     double amount,
                                     Bank bank) {
        BankAccount to = bank.findAccount(toAccountNumber);
        if (to != null) {
            transferMoney(from, to, amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public static void main(String[] args) {

        System.out.println("=== BANKING SYSTEM TEST ===\n");

        SavingsAccount savings =
                new SavingsAccount("SAV001", "Ali Hassan",
                        500000, 0.05);

        CurrentAccount current =
                new CurrentAccount("CUR001", "Fatma Said",
                        1000000, 500000);

        FixedDepositAccount fixed =
                new FixedDepositAccount("FD001", "Omar Juma",
                        2000000, 0.08, 12);

        // Testing accounts
        System.out.println("--- Testing Savings Account ---");
        savings.displayAccountInfo();
        savings.deposit(100000);
        savings.withdraw(50000);
        savings.applyInterest();

        System.out.println("\n--- Testing Current Account ---");
        current.displayAccountInfo();
        current.withdraw(1200000);
        System.out.println("Is overdrawn? " + current.isOverdrawn());

        System.out.println("\n--- Testing Fixed Deposit ---");
        fixed.displayAccountInfo();
        fixed.withdraw(500000); // not matured
        fixed.checkMaturity();
        System.out.println("Maturity amount: TZS " +
                fixed.getMaturityAmount());

        // Bank
        Bank bank = new Bank(10);
        bank.addAccount(savings);
        bank.addAccount(current);
        bank.addAccount(fixed);

        System.out.println("\n--- Bank Summary (Polymorphism) ---");
        bank.displayAllAccounts();
        System.out.println("Total Deposits: TZS " +
                bank.getTotalDeposits());
        System.out.println("Total Interest: TZS " +
                bank.getTotalInterest());

        System.out.println("\n--- Testing Transfers ---");
        transferMoney(savings, current, 50000);
        transferMoney(current, savings,
                30000, "Rent payment");

        System.out.println("\n=== END OF TEST ===");
    }
}
