package se.lexicon.Exceptions;

public class InsufficientBalanceException extends Exception {
    private double amount;
    private double balance;

    public InsufficientBalanceException(String message, double balance, double amount) {
        super(message);
        this.balance = balance;
        this.amount = amount;
    }

    public InsufficientBalanceException(String message) {
        super(message);
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Insufficient Balance: balance = " + balance + ", attempted withdrawal = " + amount;
    }
}
