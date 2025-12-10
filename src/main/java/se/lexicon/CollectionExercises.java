package se.lexicon;

import java.util.HashMap;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CollectionExercises {

    private static final String[] WEEK = {
            "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
    };

    public static void collectionExercises() {
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
        String[] days = WEEK;
        System.out.println(Arrays.toString(days));
    }

    private static void EX2() {
        System.out.println("\nEXERCISE 2");
        String[] days = WEEK;
        for (String day : days) {
            System.out.println(day);
        }
    }

    private static void EX3() {
        System.out.println("\nEXERCISE 3");
        List<String> daysList = new ArrayList<>(Arrays.asList(WEEK));
        // Ensure Thursday is at index 3
        if (!daysList.get(3).equals("Thursday")) {
            daysList.add(3, "Thursday");
        }
        System.out.println(daysList);
    }

    private static void EX4() {
        System.out.println("\nEXERCISE 4");
        ArrayList<String> days = new ArrayList<>(Arrays.asList(WEEK));
        System.out.println(days.subList(0, 3));
    }

    private static void EX5() {
        System.out.println("\nEXERCISE 5");
        HashSet<String> daysSet = new HashSet<>(Arrays.asList(WEEK));
        System.out.println(daysSet);
    }

    private static void EX6() {
        System.out.println("\nEXERCISE 6");
        HashSet<String> daysSet = new HashSet<>(Arrays.asList(WEEK));
        String[] daysArray = daysSet.toArray(new String[0]);
        System.out.println(Arrays.toString(daysArray));
    }

    private static void EX7() {
        System.out.println("\nEXERCISE 7");
        HashSet<String> names = new HashSet<>();
        names.add("Zachary");
        names.add("John");
        names.add("Alice");
        names.add("Charlie");
        names.add("Bob");
        System.out.println(names);

        ArrayList<String> namesList = new ArrayList<>(names);
        namesList.remove("Alice");
        namesList.add("Alice");
        namesList.remove("Bob");
        namesList.add("Bob");
        namesList.remove("Charlie");
        namesList.add("Charlie");
        namesList.remove("John");
        namesList.add("John");
        namesList.remove("Zachary");
        namesList.add("Zachary");
        System.out.println(namesList);
    }

    private static void EX8() {
        System.out.println("\nEXERCISE 8");
        HashSet<String> names = new HashSet<>(Arrays.asList("Zachary", "John", "Alice", "Charlie", "Bob"));
        Set<String> sortedNames = new HashSet<>(names);
        List<String> sortedList = new ArrayList<>(sortedNames);
        System.out.println(sortedList);
    }

    private static void EX9() {
        System.out.println("\nEXERCISE 9");
        HashMap<Integer, String> carID = new HashMap<>();
        carID.put(1, "Volvo");
        carID.put(2, "BMW");
        carID.put(3, "Ford");
        System.out.println(carID);
    }

    private static void EX10() {
        System.out.println("\nEXERCISE 10");
        HashMap<Integer, String> carID = new HashMap<>();
        carID.put(1, "Volvo");
        carID.put(2, "BMW");
        carID.put(3, "Ford");

        for (Integer key : carID.keySet()) {
            System.out.println(carID.get(key));
        }
    }

    private static void EX11() {
        System.out.println("\nEXERCISE 11");
        HashMap<Integer, String> carID = new HashMap<>();
        carID.put(1, "Volvo");
        carID.put(2, "BMW");
        carID.put(3, "Ford");

        System.out.println(carID.values());
    }

    private static void EX12() {
        System.out.println("\nEXERCISE 12");
        HashMap<Integer, Car> carGarage = new HashMap<>();
        carGarage.put(1, new Car(1, "Toyota", "Camry"));
        carGarage.put(2, new Car(2, "Honda", "Civic"));
        carGarage.put(3, new Car(3, "Ford", "F-150"));
        carGarage.put(4, new Car(4, "BMW", "X5"));

        for (Map.Entry<Integer, Car> entry : carGarage.entrySet()) {
            Car car = entry.getValue();
            System.out.println(car.getBrand());
        }
    }

    public static class Car {
        Integer Id;
        String brand;
        String model;

        public Car(Integer id, String brand, String model) {
            Id = id;
            this.brand = brand;
            this.model = model;
        }

        public Integer getId() {
            return Id;
        }

        public String getBrand() {
            return brand;
        }

        public String getModel() {
            return model;
        }

        public void setId(Integer id) {
            Id = id;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public void setModel(String model) {
            this.model = model;
        }
    }
}

/*
 * Set basics: Set forbids duplicates. HashSet is unordered (hash-code based);
 * TreeSet is always sorted (natural order) and forbids null; LinkedHashSet
 * preserves
 * insertion order.
 * Map basics: Map stores key -> value pairs. HashMap is unordered; TreeMap is
 * sorted by key; LinkedHashMap keeps insertion order and is handy for
 * predictable iteration.
 * List basics: List keeps insertion order and allows duplicates. ArrayList is
 * backed by an
 * array (fast random access); LinkedList is node-based (fast adds/removes in
 * middle).
 * Ordering notes: Hash structures are unpredictable order; Tree structures
 * sort; LinkedHash*
 * keeps insertion order.
 *
 * Common operations/methods (commands) used in the exercises:
 * .add(element) // Add to List/Set; returns boolean for Set
 * .remove(element) // Remove by value
 * .get(index) // List only: read element at index
 * .put(key, value) // Map: add or replace entry
 * .keySet() // Map: Set of keys
 * .values() // Map: Collection of values
 * .entrySet() // Map: Set of Map.Entry (key/value pairs)
 * .contains(element) // Collection: membership test
 * .containsKey(key) // Map: key exists
 * .containsValue(value) // Map: value exists
 * .size() // Number of elements
 * .isEmpty() // True if no elements
 * .toArray() // Collection -> array
 * .subList(from, to) // List slice [from, to)
 * Arrays.asList(array) // Array -> fixed-size List view
 * Arrays.toString(array) // Pretty-print array
 * Collections.sort(list) // Sort List in natural order
 * Collections.reverse(list) // Reverse List in-place
 * Collections.shuffle(list) // Randomize order
 *
 * Utilities used:
 * java.util.ArrayList // Resizable List
 * java.util.HashSet // Unordered unique elements
 * java.util.LinkedHashSet // Preserves insertion order, unique elements
 * java.util.TreeSet // Sorted unique elements
 * java.util.HashMap // Unordered key/value map
 * java.util.LinkedHashMap // Insertion-ordered map
 * java.util.TreeMap // Sorted-by-key map
 * java.util.Set // Interface for unique collections
 * java.util.List // Interface for ordered, indexable collections
 * java.util.Map // Interface for key/value pairs
 * java.util.Arrays // Array helpers
 * java.util.Collections // Collection helpers (sort, reverse, shuffle, etc.)
 */