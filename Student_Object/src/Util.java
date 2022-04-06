import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Util {

    static Scanner scan = new Scanner(System.in);
    static LinkedList<Student> students = new LinkedList<Student>();
    static final String FILENAME = "C:\\Users\\public\\log.txt";

    static void addStudent() {
        scan.useDelimiter("\r?\n");

        System.out.print("Please enter your name as Last, First: ");
        String name = scan.next();
        System.out.print("Please enter your address: ");
        String address = scan.next();
        System.out.print("Please enter your GPA: ");
        String input = scan.next();

        double gpa;
         do {
            if (CheckForNumericInput(input)) {
                break;
            } else {
                System.out.println("Please enter a valid number");
                input = scan.next();
                CheckForNumericInput(input);
            }
         } while (!CheckForNumericInput(input));

        gpa = Double.parseDouble(input);
        Student newStudent = new Student(name, address, gpa);
        students.add(newStudent);
    }

    static void printStudent() {
        for (Student i: students) {
            System.out.println("\n" + i.toString() + "\n");
        }
    }

    static void saveData() {
        FileWriter fw = null;

         try {
            fw = new FileWriter(FILENAME);

            String fileContent = "STUDENT LOG\n-----------\n";
            fw.write(fileContent);

            Sort.mergeSort(students);

            for (Student i: students) {
                fw.write("\n" + i.toString() + "\n");
            }

            fw.close();
            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } finally {
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
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
                Util.saveData();
                System.out.println("\nGoodbye.\n");
                Util.scan.close();
                System.exit(0);
                break;
            default:
                System.out.println("\nInvalid choice");
        }
    }

    static boolean CheckForNumericInput(String input) {

        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    } 

    public static void ClearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
}
