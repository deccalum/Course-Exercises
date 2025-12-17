package se.lexicon;

import java.util.List;

public class OOP {

    public static void main() {
        IO.println();
        List<BankAccount> accounts = Generators.generateAccounts();
        IO.println(String.format("%-18s %-10s", "Account Holder", "Balance"));
        for (BankAccount acc : accounts) {
            IO.println(String.format("%-18s %-10.2f SEK",
                    acc.getAccountHolder(),
                    acc.getBalance()));
        }
        IO.println();
        List<Customer> customers = Generators.generateCustomers();
        IO.println(String.format("%-4s %-18s %-25s", "ID", "Name", "Email"));
        for (Customer customer : customers) {
            IO.println(String.format("%-4d %-18s %-25s",
                    customer.getCustomerID(),
                    customer.getName(),
                    customer.getEmail()));
        }
        IO.println();
        List<Student> students = Generators.generateStudents();
        IO.println(String.format("%-4s %-18s %-6s %-15s", "ID", "Name", "Age", "Major"));
        for (Student student : students) {
            IO.println(String.format("%-4d %-18s %-6d %-15s",
                    student.getStudentID(),
                    student.getName(),
                    student.getAge(),
                    student.getMajor()));
        }
        IO.println();
        List<Product> products = Generators.generateProducts();
        IO.println(String.format("%-12s %-15s %8s", "ProductID", "Name", "Price"));
        for (Product product : products) {
            IO.println(String.format("%-12d %-15s %8.2f SEK",
                    product.getProductID(),
                    product.getName(),
                    product.getPrice()));
        }
        IO.println();

    }
}

class BankAccount {

    private String accountHolder;
    private double balance;

    // Parameterized Constructor
    BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Getters
    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    // Setters
    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

class Customer {
    private int customerID;
    private String name;
    private String email;

    Customer(int customerID, String name, String email) {
        this.customerID = customerID;
        this.name = name;
        this.email = email;
    }

    // Getters
    public int getCustomerID() {
        return customerID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

class Student {
    private int studentID;
    private String name;
    private int age;
    private String major;

    // Parameterized Constructor

    Student(int studentID, String name, int age, String major) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.major = major;
    }

    // Getters
    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getMajor() {
        return major;
    }

    // Setters
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMajor(String major) {
        this.major = major;
    }

}

class Product {
    private int productID;
    private String name;
    private double price;

    // Parameterized Constructor
    Product(int productID, String name, double price) {
        this.productID = productID;
        this.name = name;
        this.price = price;
    }

    // Getters
    public int getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // Setters
    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}