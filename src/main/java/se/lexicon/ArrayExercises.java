package se.lexicon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import java.util.Random;

public class ArrayExercises {

    public static void arrayExercises() {
        EX1();
        EX2();
        EX3();
        EX4();
        EX5();
        EX6();
        EX7();
        EX8();
        EX9();
        EX10();
        EX11();
        EX12();
        EX13();
    }

    private static void EX1() {
        System.out.println("\nEXERCISE 1");
        int[] number = { 11, 23, 39 };
        for (int i = 0; i < number.length; i++) {
            System.out.println(number[i]);
        }
    }

    private static void EX2() {
        System.out.println("\nEXERCISE 2");
        int[] numbers = { 1, 2, 5, 2, 8, 3 };
        int index = indexOf(numbers, 5);
        System.out.println("Index of 5: " + index);
    }

    private static int indexOf(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    private static void EX3() {
        System.out.println("\nEXERCISE 3");
        String[] cities = { "Paris", "London", "New York", "Stockholm" };
        Arrays.sort(cities);

        System.out.println(Arrays.toString(cities));
    }

    private static void EX4() {
        System.out.println("\nEXERCISE 4");
        int a[] = { 1, 15, 20 };
        int b[] = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }

        System.out.println(Arrays.toString(b));
    }

    private static void EX5() {
        System.out.println("\nEXERCISE 5");

        String[][] countrycapital = new String[2][2];
        countrycapital[0][0] = "Sweden";
        countrycapital[0][1] = "Stockholm";
        countrycapital[1][0] = "Norway";
        countrycapital[1][1] = "Oslo";
        for (int i = 0; i < countrycapital.length; i++) {
            for (int j = 0; j < countrycapital[i].length; j++) {
                System.out.println(countrycapital[i][j]);
            }
        }
    }

    private static void EX6() {
        System.out.println("\nEXERCISE 6");
        int[] numbers = { 43, 5, 23, 17, 2, 14 };

        double sum = 0;
        for (int i : numbers) {
            sum += i;
        }

        double average = sum / numbers.length;

        System.out.println("Average of Array numbers: " + average);
    }

    private static void EX7() {
        System.out.println("\nEXERCISE 7");
        int[] numbers = { 1, 2, 4, 7, 5, 7, 8, 9, 12 };

        List<Integer> evenNumbers = new ArrayList<>();
        List<Integer> oddNumbers = new ArrayList<>();

        for (int number : numbers) {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            } else {
                oddNumbers.add(number);
            }
        }

        int[] evenArray = evenNumbers.stream().mapToInt(Integer::intValue).toArray();
        int[] oddArray = oddNumbers.stream().mapToInt(Integer::intValue).toArray();

        System.out.println("Even Numbers: " + Arrays.toString(evenArray));
        System.out.println("Odd Numbers: " + Arrays.toString(oddArray));

    }

    private static void EX8() {
        System.out.println("\nEXERCISE 8");
        int[] numbers = { 20, 20, 40, 20, 30, 40, 50, 60, 50 };
        List<Integer> uniqueNumbers = new ArrayList<>();
        for (int number : numbers) {
            if (!uniqueNumbers.contains(number)) {
                uniqueNumbers.add(number);
            }
        }
        int[] uniqueArray = uniqueNumbers.stream().mapToInt(Integer::intValue).toArray();
        System.out.println("Unique Numbers: " + Arrays.toString(uniqueArray));
    }

    private static void EX9() {
        System.out.println("\nEXERCISE 9");
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);

        System.out.println("ArrayList elements: " + numbers);
    }

    private static void EX10() {
        System.out.println("\nEXERCISE 10");
        int[][] multiplicationmatrix = new int[10][10];
        for (int i = 0; i < multiplicationmatrix.length; i++) {
            for (int j = 0; j < multiplicationmatrix[i].length; j++) {
                multiplicationmatrix[i][j] = (i + 1) * (j + 1);
                System.out.print(multiplicationmatrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static void EX11() {
        System.out.println("\nEXERCISE 11");
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        ArrayList<Integer> numbers = new ArrayList<>();
        System.out.println("Enter an integer (enter 5 to stop): ");

        while (number != 5) {
            number = scanner.nextInt();
            numbers.add(number);
        }

        System.out.println("You entered: " + numbers);
        Collections.reverse(numbers);
        System.out.println("Reversed: " + numbers);
        scanner.close();
    }

    private static void EX12() {
        System.out.println("\nEXERCISE 12");

        int[][] twoDArray = {
                { 1, 2, 3 },
                { 2, 4, 6 },
                { 3, 6, 9 }
        };

        for (int i = 0; i < twoDArray.length; i++) {
            for (int j = 0; j < twoDArray[i].length; j++) {
                System.out.print("\t" + twoDArray[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("\t" + twoDArray[0][0]);
        System.out.println("\t\t" + twoDArray[1][1]);
        System.out.println("\t\t\t" + twoDArray[2][2]);
    }

    private static void EX13() {
        System.out.println("\nEXERCISE 13");

        final int finalArray = 10;
        int[] originArray = new int[finalArray];
        int[] lastArray = new int[finalArray];

        List<Integer> oddNumbers = new ArrayList<>();
        List<Integer> evenNumbers = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < finalArray; i++) {
            originArray[i] = random.nextInt(100);
            if (originArray[i] % 2 == 0) {
                evenNumbers.add(originArray[i]);
            } else {
                oddNumbers.add(originArray[i]);
            }
        }
        int index = 0;
        for (int odd : oddNumbers) {
            lastArray[index] = odd;
            index++;
        }
        for (int even : evenNumbers) {
            lastArray[index] = even;
            index++;
        }
        System.out.println("Original Array: " + Arrays.toString(originArray));
        System.out.println("Rearranged Array: " + Arrays.toString(lastArray));
    }
}

/*
 * Array basics: fixed-size, zero-indexed; access via arr[i], length via
 * arr.length.
 * Mutability: elements can change; size cannot—use List for dynamic sizing.
 * Memory: contiguous block, fast indexed reads/writes; no growth without
 * copying.
 *
 * Common operations/methods (commands) used in the exercises:
 * Arrays.copyOf(arr, len) // Copy/resize
 * arr.clone() // Shallow clone
 * Arrays.sort(arr) // Sort full array
 * Arrays.sort(arr, from, to) // Sort slice [from,to)
 * Arrays.binarySearch(arr, v) // Binary search (arr must be sorted)
 * Arrays.toString(arr) // 1D pretty-print
 * Arrays.deepToString(arr2d) // 2D pretty-print
 * Arrays.asList(objArr) // Fixed-size List view (object arrays only)
 * Collections.reverse(list) // Reverse a List (after Arrays.asList for objects)
 * Collections.shuffle(list) // Shuffle a List
 * System.arraycopy(src, sPos, dst, dPos, len) // Fast bulk copy
 *
 * Utilities used:
 * java.util.Arrays // Array helpers (copy, sort, search, print)
 * java.util.Collections // List helpers (reverse, shuffle, sort on Lists)
 * java.util.Random // Random number generation
 * java.util.ArrayList // Dynamic list used alongside arrays
 * java.util.stream.* // Streams for map/filter/collect (int[] via mapToInt)
 */