package se.lexicon.Exceptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.naming.NameNotFoundException;

public class NameProcessor {
    
    public static void main(String[] args) {
        List<String> nameList = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie", "Diana", "Eve"));

        String choice = IO.readln("Enter '(f)ind name', '(a)dd name' or (l)ist names: ");
        
        try {
            if (choice.equalsIgnoreCase("f")) {
                String nameToFind = IO.readln("Enter name to find: ");
                String foundName = findName(nameList, nameToFind);
                IO.println("Found name: " + foundName);
                
            } else if (choice.equalsIgnoreCase("a")) {
                String nameToAdd = IO.readln("Enter name to add: ");
                addName(nameList, nameToAdd);
                IO.println("Successfully added: " + nameToAdd);
                
            } else if (choice.equalsIgnoreCase("l")) {
                IO.println("Names: " + nameList);
            } else {
                IO.println("Invalid choice.");
            }
            
        } catch (NameNotFoundException | DuplicateNameException | IllegalArgumentException e) {
            // catch exceptions
            IO.println("Operation Failed: " + e.getMessage());
        }
    }
    
    public static String findName(List<String> names, String name) throws NameNotFoundException {
        for (String n : names) {
            if (n.equalsIgnoreCase(name)) {
                return n;
            }
        }
        throw new NameNotFoundException("Name '" + name + "' was not found in the list.");
    }

    public static void addName(List<String> names, String name) throws DuplicateNameException {
        
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }

        for (String n : names) {
            if (n.equalsIgnoreCase(name)) {
                throw new DuplicateNameException("The name '" + name + "' already exists in the list.");
            }
        }
        
        names.add(name);
    }
}
