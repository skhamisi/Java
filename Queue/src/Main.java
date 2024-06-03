import java.util.*;

class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName; // Assign parameter to instance variable
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
        // Format the person's information for printing in a table
        return String.format("%-15s %-15s %3d", firstName, lastName, age);
    }
}

class Queue {
    private List<Person> queue;

    public Queue() {
        queue = new ArrayList<>(); // Initialize the queue as an empty ArrayList
    }

    public void enqueue(Person person) {
        queue.add(person); // Add a person to the back of the queue
    }

    // Sort the queue by last name in descending order using a comparator
    public void sortByNameDescending() {
        queue.sort(Comparator.comparing(Person::getLastName).reversed());
    }

    // Sort the queue by age in descending order using a comparator
    public void sortByAgeDescending() {
        queue.sort(Comparator.comparing(Person::getAge).reversed());
    }

    public void printQueue() {
        System.out.printf("%-15s %-15s %3s%n", "First Name", "Last Name", "Age");
        System.out.println("------------------------------------");
        // Print a header for the queue contents table
        for (Person person : queue) {
            System.out.println(person); // Print each person's information
        }
    }
}

class Util {
    public void ClearScreen() {
        System.out.print("\033[H\033[2J"); // Clear the console screen
        System.out.flush();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue queue = new Queue();
        Util util = new Util();

        util.ClearScreen();

        // Add person information to the Queue
        for (int i = 0; i < 5; i++) {
            System.out.println("\nEnter details for person " + (i + 1));
            System.out.println("--------------------------");
            System.out.print("First Name: ");
            String firstName = scanner.nextLine();
            System.out.print("Last Name: ");
            String lastName = scanner.nextLine();
            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            Person person = new Person(firstName, lastName, age);
            queue.enqueue(person);
        }

        System.out.println("\n\nQueue contents");
        System.out.println("------------------------------------");
        queue.printQueue();

        queue.sortByNameDescending();
        System.out.println("\n\nSorted by last name (descending)");
        System.out.println("------------------------------------");
        queue.printQueue();

        queue.sortByAgeDescending();
        System.out.println("\n\nSorted by age (descending)");
        System.out.println("------------------------------------");
        queue.printQueue();

        scanner.close();
    }
}
