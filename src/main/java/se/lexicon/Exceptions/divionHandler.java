package se.lexicon.Exceptions;

public class divionHandler {
    void main() {
        String prompt = ("Enter a number: ");
        String intone = IO.readln(prompt);
        String inttwo = IO.readln(prompt);
        try {
            double num1 = Double.parseDouble(intone);
            double num2 = Double.parseDouble(inttwo);
            
            if (num2 == 0) {
                throw new ArithmeticException("Division by zero is not allowed.");
            }
            
            double result = num1 / num2;
            IO.println("Result: " + result);
        } catch (NumberFormatException e) {
            IO.println("Error: Invalid number input.");
        } catch (ArithmeticException e) {
            IO.println("Error: " + e.getMessage());
            // exercise 5 finally
        } finally {
            IO.println("Execution completed.");
        }
    }
}