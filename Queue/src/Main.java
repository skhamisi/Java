import java.util.*;

class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", Age: " + age;
    }
}

class Queue {
    private List<Person> queue;

    public Queue() {
        queue = new ArrayList<>();
    }

    public void enqueue(Person person) {
        queue.add(person);
    }

    public void sortByNameDescending() {
        queue.sort(Comparator.comparing(Person::getLastName).reversed());
    }

    public void sortByAgeDescending() {
        queue.sort(Comparator.comparing(Person::getAge).reversed());
    }

    public void printQueue() {
        for (Person person : queue) {
            System.out.println(person);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue queue = new Queue();

        for (int i = 0; i < 5; i++) {
            System.out.println("Enter details for person " + (i + 1) + ":");
            System.out.print("First Name: ");
            String firstName = scanner.nextLine();
            System.out.print("Last Name: ");
            String lastName = scanner.nextLine();
            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // consume newline character

            Person person = new Person(firstName, lastName, age);
            queue.enqueue(person);
        }

        System.out.println("Queue contents:");
        queue.printQueue();

        queue.sortByNameDescending();
        System.out.println("\nSorted by last name (descending):");
        queue.printQueue();

        queue.sortByAgeDescending();
        System.out.println("\nSorted by age (descending):");
        queue.printQueue();

        scanner.close();
    }
}
