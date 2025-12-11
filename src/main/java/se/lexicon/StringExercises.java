package se.lexicon;

public class StringExercises {

    public static void stringExercises() {
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
    }

    private static void EX1() {
        System.out.println("\nEXERCISE 1");
        String ex1 = ("Java");
        System.out.println(ex1);
        int ex1Length = ex1.length();
        System.out.println("Length: " + ex1Length);
    }

    private static void EX2() {
        System.out.println("\nEXERCISE 2");
        String ex2 = ("Long example sentence");
        char ex2Char = ex2.charAt(6);
        System.out.println("Character at index 6: " + ex2Char);
    }

    private static void EX3() {
        System.out.println("\nEXERCISE 3");
        String ex3 = ("Even longer example sentence");
        int ex3Char = ex3.indexOf("o");
        System.out.println("Index of first 'o': " + ex3Char);
    }

    private static void EX4() {
        System.out.println("\nEXERCISE 4");
        String ex4 = ("Ok this is not as long!");
        String ex41 = ("Ok this is ");
        ex41 = ex41.concat("not as long");
        System.out.println(ex41);
    }

    private static void EX5() {
        System.out.println("\nEXERCISE 5");
        String ex5 = ("CAPS EQUALS SCREAMING");
        ex5 = ex5.toLowerCase();
        System.out.println(ex5);
        String ex51 = ex5.toUpperCase();
        System.out.println(ex51);
    }

    private static void EX6() {
        System.out.println("\nEXERCISE 6");
        String ex6 = ("Java is the worst programming language");
        ex6 = ex6.replace("worst", "best");
        System.out.println(ex6);
    }

    private static void EX7() {
        System.out.println("\nEXERCISE 7");
        String ex7 = ("\tJ\ta\tv\ta\t");
        String ex71 = ex7.trim();
        System.out.println("Trimmed: " + ex71);
    }

    private static void EX8() {
        System.out.println("\nEXERCISE 8");
        String ex8 = ("20");
        int ex81 = (20);
        String ex82 = ex8 + ex81;
        System.out.println("String + int concatenation v1: " + ex82);

        String ex83 = (20 + "20");
        System.out.println("Int + String concatenation v2: " + ex83);
    }

    private static void EX9() {
        System.out.println("\nEXERCISE 9");
        String ex9 = ("Oil and Water");
        String[] ex9Parts = ex9.split(" and ");
        System.out.println("First part: " + ex9Parts[0]);
        System.out.println("Second part: " + ex9Parts[1]);
    }

    private static void EX10() {
        System.out.println("\nEXERCISE 10");
        String ex10 = ("Carl,Susie,Fredrick,Bob,Erik");
        String[] ex10Parts = ex10.split(",");
        for (String i : ex10Parts) {
            System.out.println("Name: " + i);
        }
    }

    private static void EX11() {
        System.out.println("\nEXERCISE 11");
        String ex11 = ("ThisShouldBeConverted");
        char[] ex11Chars = ex11.toCharArray();
        for (char c : ex11Chars) {
            System.out.println(c);
        }
    }

    private static void EX12() {
        System.out.println("\nEXERCISE 12");
        char[] ex12 = { 'J', 'a', 'v', 'a' };
        String ex121 = String.valueOf(ex12);
        System.out.println("Char array to String " + ex121);
    }
}

/*
 * String basics: immutable sequences of characters. Once created, strings
 * cannot
 * be changed. String operations return new String objects.
 * 
 * Common operations/methods (commands) used in the exercises:
 * .length() // Number of characters
 * .charAt(int index) // Character at specific position
 * .indexOf(String str) // First occurrence position (-1 if not found)
 * .concat(String str) // Concatenate strings (returns new String)
 * .toLowerCase() // Convert to lowercase
 * .toUpperCase() // Convert to uppercase
 * .replace(CharSequence target, CharSequence replacement) // Replace substrings
 * .trim() // Remove leading and trailing whitespace
 * .split(String regex) // Split into String array by delimiter
 * .toCharArray() // Convert String to char array
 * String.valueOf(char[] data) // Convert char array to String
 * String concatenation with + // Concatenate strings and other types
 * 
 * Utilities used:
 * java.lang.String // String class (implicit import)
 */