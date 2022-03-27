import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;

public class Util {
    static Scanner scan = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<Student>();
    static ArrayList<Integer> rollNumbers = new ArrayList<Integer>();
    static Hashtable<Integer, Student> studentTable = new Hashtable<Integer, Student>();

    static void addStudent() {
        Random rand = new Random();
        scan.useDelimiter("\r?\n");

        System.out.print("Please enter your name: ");
        String name = scan.next();
        System.out.print("Please enter your address: ");
        String address = scan.next();
        Integer rollno = rand.nextInt(1, 10);
        rollNumbers.add(rollno);
        Student newStudent = new Student(rollno, name, address);
        studentTable.put(rollno, newStudent);
        students.add(newStudent);
    }


    static void printStudent() {
        // for (Student i: studentTable) {
        //     System.out.println("\n" + i.toString() + "\n");
        // }
        System.out.println(studentTable);
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
                printStudent();
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
