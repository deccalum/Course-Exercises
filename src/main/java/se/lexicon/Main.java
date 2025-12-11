package se.lexicon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean run = true;
        Scanner scanner = new Scanner(System.in);

        while (run) {
            System.out.println("[1] String Exercises");
            System.out.println("[2] Methods and Loops Exercises");
            System.out.println("[3] Time API Exercises");
            System.out.println("[4] Collection Exercises");
            System.out.println("[5] Array Exercises");
            System.out.println("[0] Exit");
            int menu;
            try {
                menu = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (menu) {
                case 1:
                    StringExercises.stringExercises();
                    break;
                case 2:
                    MethodsAndLoops.methodsAndLoopsExercises();
                    break;
                case 3:
                    TimeAPI.timeExercises();
                    break;
                case 4:
                    CollectionExercises.collectionExercises();
                    break;
                case 5:
                    ArrayExercises.arrayExercises();
                    break;
                case 0:
                    run = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
        scanner.close();
    }
}