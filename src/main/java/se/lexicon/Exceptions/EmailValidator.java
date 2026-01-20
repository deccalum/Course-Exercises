package se.lexicon.Exceptions;

public class EmailValidator {
    void main() {
        String prompt = ("Enter your email address: ");
        String userInput = IO.readln(prompt);

        try {
            validateEmail(userInput);
            IO.println("Success! " + userInput + " is a valid email.");
        } catch (IllegalArgumentException e) {
            IO.println("Invalid email: " + e.getMessage());
        }
    }

    public static void validateEmail(String email) {
        // 1. Check for null or empty
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be empty.");
        }

        // 2. Check for @ symbol
        int atIndex = email.indexOf("@");
        if (atIndex == -1) {
            throw new IllegalArgumentException("Email is missing the '@' symbol.");
        }

        // 3. Check for text before @
        if (atIndex == 0) {
            throw new IllegalArgumentException("Email cannot start with '@'.");
        }

        // 4. Validate Domain portion
        // Now it is safe to substring because we know @ exists
        String domain = email.substring(atIndex + 1);

        if (domain.isEmpty()) {
            throw new IllegalArgumentException("Email is missing the domain part.");
        }

        if (!domain.contains(".")) {
            throw new IllegalArgumentException("Domain must contain a dot (e.g., .com).");
        }
        
        if (domain.startsWith(".")) {
             throw new IllegalArgumentException("Domain cannot start with a dot.");
        }
    }
}