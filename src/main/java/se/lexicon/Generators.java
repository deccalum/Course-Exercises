package se.lexicon;

import java.util.Random;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

public class Generators {

    public static String[] randFirstNames = { "Simon", "Anna", "Peter", "Maria", "John", "Anna", "Peter", "Maria",
            "John",
            "Linda", "James", "Susan", "Robert", "Karen" };

    public static String[] randLastNames = { "Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller",
            "Davis",
            "Rodriguez", "Martinez", "Hernandez", "Lopez", "Gonzalez", "Wilson" };

    public static String[] randFullNamesGenerator(String firstName, String lastName) {
        return new String[] { firstName, lastName };
    }

    public static String[] randEmailProviders = { "fmail.com", "ahooy.com", "inlook.com", "example.com",
            "notmail.com" };

    public static String randEmailNamesGenerator() {
        Random rand = new Random();
        String firstName = randFirstNames[rand.nextInt(randFirstNames.length)];
        String lastName = randLastNames[rand.nextInt(randLastNames.length)];
        String provider = randEmailProviders[rand.nextInt(randEmailProviders.length)];
        return (firstName.substring(0, 1) + lastName).toLowerCase() + "@" + provider;
    }

    public static int randAge() {
        Random rand = new Random();
        int adjusted = rand.nextInt(100);
        if (adjusted < 50) {
            return 18 + rand.nextInt(4);
        } else if (adjusted < 75) {
            return 22 + rand.nextInt(8);
        } else {
            return 27 + rand.nextInt(36);
        }
    }

    public static String randMajorGenerator() {
        String[] majors = { "Computer Science", "Mathematics", "Physics", "Chemistry", "Biology", "Economics",
                "History", "Literature", "Philosophy", "Psychology" };
        Random rand = new Random();
        return majors[rand.nextInt(majors.length)];
    }

    public static int randID() {
        int randID = UUID.randomUUID().hashCode();
        if (randID < 0) {
            randID = -randID;
        }
        return randID;
    }

    // Centralized generators
    public static List<BankAccount> generateAccounts() {
        List<BankAccount> accounts = new ArrayList<>();
        Random rand = new Random();
        int count = rand.nextInt(4, 12) + 1;
        for (int i = 0; i < count; i++) {
            String holder = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
            double balance = rand.nextDouble() * 100000;
            accounts.add(new BankAccount(holder, balance));
        }
        return accounts;
    }

    public static List<Customer> generateCustomers() {
        List<Customer> customers = new ArrayList<>();
        Random rand = new Random();
        int count = rand.nextInt(4, 12) + 1;
        for (int i = 0; i < count; i++) {
            String name = randFirstNames[rand.nextInt(randFirstNames.length)];
            String lastName = randLastNames[rand.nextInt(randLastNames.length)];
            String email = (name.substring(0, 1) + lastName).toLowerCase() + "@" +
                    randEmailProviders[rand.nextInt(randEmailProviders.length)];
            customers.add(new Customer(i + 1, name + " " + lastName, email));
        }
        return customers;
    }

    public static List<Student> generateStudents() {
        List<Student> students = new ArrayList<>();
        Random rand = new Random();
        int count = rand.nextInt(4, 12) + 1;
        for (int i = 0; i < count; i++) {
            String name = randFirstNames[rand.nextInt(randFirstNames.length)];
            String lastName = randLastNames[rand.nextInt(randLastNames.length)];
            int age = randAge();
            String major = randMajorGenerator();
            students.add(new Student(i + 1, name + " " + lastName, age, major));
        }
        return students;
    }

    public static List<Product> generateProducts() {
        List<Product> products = new ArrayList<>();
        Random rand = new Random();
        int count = rand.nextInt(4, 12) + 1;
        for (int i = 0; i < count; i++) {
            String name = "Product-" + UUID.randomUUID().toString().substring(0, 5).toUpperCase();
            double price = Math.round(rand.nextDouble(1) * 1000);
            int productID = randID();
            products.add(new Product(productID, name, price));
        }
        return products;
    }

}
