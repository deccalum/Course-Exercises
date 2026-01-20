package se.lexicon.Exceptions;

public class BankingSystem {
    void main() {
        try {
            double startBalance = Double.parseDouble(IO.readln("Enter balance for test account: "));
            BankAccount account = new BankAccount(startBalance);
            
            String choice = IO.readln("Would you like to (d)eposit or (w)ithdraw? ");
            
            if (choice.equalsIgnoreCase("d")) {
                double depositAmount = Double.parseDouble(IO.readln("Enter amount to deposit: "));
                account.deposit(depositAmount);
            } else if (choice.equalsIgnoreCase("w")) {
                double withdrawAmount = Double.parseDouble(IO.readln("Enter amount to withdraw: "));
                account.withdraw(withdrawAmount);
            } else {
                IO.println("Invalid choice.");
            }
            IO.println("Final Account Balance: " + account.getBalance());
        } catch (InsufficientBalanceException e) {
                IO.println("Transaction Failed: " + e.getMessage());
                IO.println(" -> Current Balance: " + e.getBalance());
                IO.println(" -> Attempted Amount: " + e.getAmount());
                IO.println(" -> Shortage: " + (e.getAmount() - e.getBalance()));
        }
    }
}