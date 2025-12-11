package se.lexicon;

import java.util.Scanner;
import java.util.Random;

public class MethodsAndLoops {

    public static void methodsAndLoopsExercises() {
        EX1();
        EX2();
        EX3();
        EX4();
        EX5();
        EX6();
        EX7();
        EX8();
    }

    // Shared Scanner and simple state
    private static final Scanner SCANNER = new Scanner(System.in);
    private static String usernameInput;

    static void getUsername() {
        System.out.printf("Enter username: ");
        usernameInput = SCANNER.nextLine();
        System.out.printf("Your Username is %s%n", usernameInput);
    }

    private static void EX1() {
        System.out.printf("\nExercise 1 - 'What is my name?'%n");
        System.out.printf("Hello!%n");
        System.out.printf("Your name is Dennis%n");
    }

    private static void EX2() {
        System.out.printf("\nExercise 2 - Leap year check%n");
        System.out.printf("Enter a year: ");
        int inputYear = SCANNER.nextInt();
        SCANNER.nextLine();
        if ((inputYear % 4 == 0 && inputYear % 100 != 0) || (inputYear % 400 == 0)) {
            System.out.printf("%nYear %d is a leap year.%n", inputYear);
        } else {
            System.out.printf("%nYear %d is not a leap year.%n", inputYear);
        }

        System.out.printf(
                "Leap year rules use these conditions:%n%n" +
                        "\"It is divisible by 4 AND not divisible by 100.%n" +
                        "OR it is evenly divisible by 400.\"%n");
        System.out.printf("%d / 4 = %.2f%n", inputYear, inputYear / 4f);
        System.out.printf("%d / 100 = %.2f%n", inputYear, inputYear / 100f);
        System.out.printf("%d / 400 = %.2f%n", inputYear, inputYear / 400f);
    }

    private static void EX3() {
        System.out.printf("\nExercise 3 - Simple calculations%n%n");
        int result1 = 45 + 11;
        System.out.printf("45 + 11 = %d%n", result1);
        int result2 = 12 * 4;
        System.out.printf("12 * 4 = %d%n", result2);
        int result3 = 24 / 6;
        System.out.printf("24 / 6 = %d%n", result3);
        int result4 = 10 - 3;
        System.out.printf("10 - 3 = %d%n", result4);
    }

    private static void EX4() {
        System.out.printf("\nExercise 4 - Average of 3 numbers.%n");

        int[] numbs = new int[3];
        int count = 0;

        while (count < 3) {
            System.out.printf("%nEnter number %d: ", (count + 1));
            String line = SCANNER.nextLine();
            numbs[count] = Integer.parseInt(line);
            count++;
        }
        int sum = numbs[0] + numbs[1] + numbs[2];
        double average = (double) sum / count;
        double avgRounded = Math.round(average * 100.0) / 100.0;
        System.out.printf("%nThe average of %d, %d, and %d is: %.2f%n", numbs[0], numbs[1], numbs[2],
                avgRounded);
    }

    private static void EX5() {
        System.out.printf("\nExercise 5 - Username Input%n");
        if (usernameInput == null || usernameInput.isBlank()) {
            getUsername();
        }
        System.out.printf("Hello %s%n%n", usernameInput);
    }

    private static void EX6() {
        System.out.printf("\nExercise 6 - subtraction, addition, multiplication, division.%n");

        System.out.printf("Enter first number: ");
        int number1 = SCANNER.nextInt();

        System.out.printf("Enter second number: ");
        int number2 = SCANNER.nextInt();
        SCANNER.nextLine();

        int subtraction = number1 - number2;
        int sum = number1 + number2;
        int multiplication = number1 * number2;
        double division = (double) number1 / (double) number2;
        double divRounded = Math.round(division * 100.0) / 100.0;

        System.out.printf("%d - %d = %d%n", number1, number2, subtraction);
        System.out.printf("%d + %d = %d%n", number1, number2, sum);
        System.out.printf("%d * %d = %d%n", number1, number2, multiplication);
        System.out.printf("%d / %d = %.2f%n%n", number1, number2, divRounded);
    }

    private static void EX7() {
        System.out.printf("\nExercise 7 - Convert seconds to hours, minutes, and seconds.%n");
        System.out.printf("Enter total seconds: ");

        long totalSeconds = SCANNER.nextLong();
        SCANNER.nextLine();

        long hours = (totalSeconds / 3600);
        long remainingSeconds = (totalSeconds % 3600);
        long minutes = remainingSeconds / 60;
        long seconds = remainingSeconds % 60;
        System.out.printf("%n%d seconds is equal to:%n", totalSeconds);
        System.out.printf("%dh %dm %ds%n", hours, minutes, seconds);
    }

    private static void EX8() {
        System.out.printf("\nExercise 8 - Random Guesser.%n");
        Random random = new Random();
        int randomNumber = random.nextInt(501);

        int attempts = 0;
        boolean hintShown = false;

        while (true) {
            System.out.printf("Guess a number between 0 and 500: ");

            int guess = SCANNER.nextInt();
            attempts++;

            if (guess == randomNumber) {
                System.out.printf("Correct! The number was: %d. Attempts: %d%n", randomNumber, attempts);
                break;
            }

            if (guess < randomNumber) {
                System.out.printf("Higher%n");
            } else {
                System.out.printf("Lower%n");
            }

            if (attempts >= 3 && !hintShown) {
                System.out.printf("Hint: %d is close%n", (randomNumber - 1));
                hintShown = true;
            }
        }
        System.out.printf("%n");
        SCANNER.nextLine();
    }
}

/*
 * Methods and Loops exercises: Practice with method definitions, method calls,
 * loops, conditionals,
 * user input handling, and interactive menu-driven programs.
 * 
 * Key Concepts:
 * - Method definition: static returnType methodName(parameters) { ... }
 * - Method calls: methodName(arguments)
 * - while loops: Repeat code block while condition is true
 * - for loops: Iterate with counter variable
 * - if/else: Conditional branching
 * - Scanner: Read user input from console
 * - String parsing: Convert strings to numbers (Integer.parseInt,
 * Long.parseLong)
 * - Math operations: Arithmetic, modulo (%), casting, rounding
 * - Random: Generate random numbers
 * 
 * Common operations/methods (commands) used in the exercises:
 * System.out.printf(String format, Object... args) // Formatted output
 * SCANNER.nextLine() // Read entire line as String
 * SCANNER.nextInt() // Read next int
 * SCANNER.nextLong() // Read next long
 * Integer.parseInt(String s) // Convert String to int
 * Long.parseLong(String s) // Convert String to long
 * String.trim() // Remove leading/trailing whitespace
 * String.toLowerCase() // Convert to lowercase
 * String.isBlank() // Check if string is empty or whitespace
 * Math.round(double a) // Round to nearest integer
 * Random.nextInt(int bound) // Generate random int 0 to bound-1
 * % (modulo operator) // Get remainder after division
 * / (division) with casting // Divide with type conversion
 * 
 * Exercise Types:
 * 1. Simple method calls and printing
 * 2. Conditional logic (leap year calculation)
 * 3. Basic arithmetic operations
 * 4. Input validation and array operations
 * 5. State management (usernameInput variable)
 * 6. Mathematical operations with user input
 * 7. Time conversion (seconds to hours/minutes/seconds)
 * 8. Interactive loop with random number guessing
 */
