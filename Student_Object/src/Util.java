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

        do {
            if (CheckForNumericInput(input)) {
                double gpa = Double.parseDouble(input);
                Student newStudent = new Student(name, address, gpa);
                students.add(newStudent);
            } else {
                System.out.println("Please enter a valid number");
                input = scan.next();
                CheckForNumericInput(input);
            }
        } while (!CheckForNumericInput(input));

        //double gpa = scan.nextDouble();
        //Student newStudent = new Student(name, address, gpa);
        //students.add(newStudent);

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

            String fileContent = "STUDENT INFO----------------\n";
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

        // try {
        //     // check if it can be parsed as any double
        //     double num = Double.valueOf(input);
        //     // check if the double can be converted without loss to an int
        //     if (num == (int) num)
        //         // if yes, this is an int, thus return false
        //         return false;
        //     // otherwise, this cannot be converted to an int (e.g. "1.2")
        //     return true;
        //     // short version: return x != (int) x;
        // } catch(NumberFormatException e) {
        //     return false;
        // }

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
