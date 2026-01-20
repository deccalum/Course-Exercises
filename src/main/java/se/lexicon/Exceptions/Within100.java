package se.lexicon.Exceptions;

public class Within100 {    
    void main() throws OutOfRange {
    String prompt = ("Enter a number between 1-100: ");
    String userInput = IO.readln(prompt);
        try {
            int number = Integer.parseInt(userInput);
            if (number < 1 || number > 100) {
                throw new OutOfRange(number, "Number out of range. Please enter a number between 1 and 100.");
            }
            IO.println("You entered: " + number);
        } catch (NumberFormatException e) {
            IO.println("Error: Invalid number input.");
        }
    }
}
