package se.lexicon.LamdaAndStream;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class LamdaStream {

    public static void main() {

    List<Person> people = List.of(
        new Person("Amina", 22, "Stockholm", true),
        new Person("Erik", 17, "Uppsala", true),
        new Person("Noah", 34, "Stockholm", false),
        new Person("Sara", 29, "Gothenburg", true),
        new Person("Lina", 41, "Malmö", false),
        new Person("Omar", 19, "Stockholm", true)
    );

    // LAMBDA RULES
    Predicate<Person> isAdult = p -> p.getAge() >= 18;
    Predicate<Person> isFromStockholm = p -> p.getCity().equalsIgnoreCase("Stockholm");
    // Predicate<Person> isActive = p -> p.isActive();
    Predicate<Person> isActive = Person::isActive;


    Predicate<Person> filterPeople = isAdult.and(isFromStockholm).and(isActive);

    Consumer<Person> printName = p -> System.out.println(p.getName());
    Consumer<Person> sendEmail = p -> System.out.println("Send email to " + p.getName());

    people.forEach(printName);
    sendEmail.accept(people.get(0));

    // 1. Filter all active people
    List<Person> activePeople = people.stream()
        .filter(isActive)
        .collect(Collectors.toList());
    System.out.println("Active: " + activePeople);

    // 2. Map all names
    Function<Person,String> toName = Person::getName;
    List<String> names = people.stream()
        .map(toName)
        .collect(Collectors.toList());
    System.out.println("Names: " + names);

    // 3. Count adults
    long adultCount = people.stream()
        .filter(isAdult)
        .count();
    System.out.println("Adult count: " + adultCount);

    // 4. Sort by age
    List<Person> sortedByAge;
        sortedByAge = people.stream()
                .sorted(Comparator.comparingInt(Person::getAge))
                .collect(Collectors.toList());
    System.out.println("Sorted by age: " + sortedByAge);

    // 5. Find first active person in Stockholm
    Optional<Person> firstActiveInStockholm = people.stream()
        .filter(isActive.and(isFromStockholm))
        .findFirst();
        firstActiveInStockholm.ifPresent(p -> System.out.println("First active in Stockholm: " + p));
    }
}


/******************************************************************
Reflection Questions

Which solutions were easier to read: loop-based or stream-based?
    - Stream-based are easier to read, it reduces lines making it easier to read. 

Which operations felt like transformations and which felt like side effects?
    - None really feel like side effects other than not being used to it and its syntax.

********************************************************************

Equivalent implementations WITHOUT streams/lambdas comparison

1. Filter all active people (loop)
List<Person> filterActiveLoop(List<Person> people) {
    List<Person> result = new ArrayList<>();
    for (Person p : people) {
        if (p.isActive()) {
            result.add(p);
        }
    }
    return result;
}

2. Map all names (loop)
List<String> mapNamesLoop(List<Person> people) {
    List<String> names = new ArrayList<>();
    for (Person p : people) {
        names.add(p.getName());
    }
    return names;
}

3. Count adults (loop)
long countAdultsLoop(List<Person> people) {
    long count = 0;
    for (Person p : people) {
        if (p.getAge() >= 18) count++;
    }
    return count;
}

4. Sort by age (classic sort)
List<Person> sortByAgeLoop(List<Person> people) {
    List<Person> copy = new ArrayList<>(people);
    copy.sort(new Comparator<Person>() {
        @Override
        public int compare(Person a, Person b) {
            return Integer.compare(a.getAge(), b.getAge());
        }
    });
    return copy;
}

5. Find first active person in Stockholm (loop)
Optional<Person> findFirstActiveInStockholmLoop(List<Person> people) {
    for (Person p : people) {
        if (p.isActive() && p.getCity().equalsIgnoreCase("Stockholm")) {
            return Optional.of(p);
        }
    }
    return Optional.empty();
}

/* WITHOUT FUNCTIONS
interface PersonRule {
    
    boolean rule(Person p);
}

class PersonAction {
    
    void printName(Person p) {
        System.out.println(p.getName());
    }

    void sendEmail(Person p) {
        System.out.println("Send email to " + p.getName());
    }
}


class PersonProcessor {

    List<Person> findPeople(List<Person> list, Predicate<Person> rule) {
        List<Person> found = new ArrayList<>();
        for (Person p : list) {
            if (rule.test(p)) {
                found.add(p);
            }
        }
        return found;
    }

    void applyToMatching(List<Person> list, Predicate<Person> rule, Consumer<Person> action) {
        for (Person p : list) {
            if (rule.test(p)) {
                action.accept(p);
            }
        }
    }
}
processor.applyToMatching(people, filterPeople, sendEmail); // calls action.accept(p)
*/