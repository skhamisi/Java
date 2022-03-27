import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Util {
    static Scanner scan = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<Student>();

    static void addStudent() {
        Random rand = new Random();
        scan.useDelimiter("\r?\n");

        System.out.print("Please enter your name: ");
        String name = scan.next();
        System.out.print("Please enter your address: ");
        String address = scan.next();
        double rollno = rand.nextInt(1, 10);
        Student newStudent = new Student(rollno, name, address);
        students.add(newStudent);
    }

    static void sort() {

        Node sortedStudent = null;

        for (Student key: students) {
            sortedStudent = new Node(key, sortedStudent);
        }
 
        // sort the list
        sortedStudent = Sort.mergesort(sortedStudent);
    }

    static void printStudent() {
        for (Student i: students) {
            System.out.println("\n" + i.toString() + "\n");
        }
    }

    static void PrintMenu() {
        do {
            
            ClearScreen();

            System.out.println("STUDENT INVENTORY");
            System.out.println("=======================*");
            System.out.println("1. Add Student Info    |");
            System.out.println("2. Exit                |");
            System.out.println("=======================*\n");

            System.out.print("\nENTER CHOICE: ");
            int userChoice = scan.nextInt();

            SwitchMenu(userChoice);

        } while (true);
    }

    static void SwitchMenu(int userChoice) {

        switch (userChoice) {
            case 1:
            ClearScreen();
                addStudent();
                break;
            case 2:
                ClearScreen();
                System.out.println("Goodbye.\n");
                scan.close();
                System.exit(0);
                break;
            default:
                System.out.println("\nInvalid choice");
        }
    }

    public static void ClearScreen() 
    {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
}
