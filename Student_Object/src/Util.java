import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Util {

    static Scanner scan = new Scanner(System.in);
    static LinkedList<Student> students = new LinkedList<Student>();
    static final String FILENAME = "C:\\Users\\skham\\Documents\\log.txt";
    //final String FILENAME = "C:\\Users\\public\\log.txt";

    static void addStudent() {
        System.out.print("Please enter your name: ");
        String name = scan.nextLine();
        System.out.print("Please enter your address: ");
        String address = scan.nextLine();
        System.out.print("Please enter your GPA: ");
        double gpa = scan.nextDouble();
        Student newStudent = new Student(name, address, gpa);
        students.add(newStudent);

        students.sort(null);
    }

    static void printStudent() {
        for (Student i: students) {
            System.out.println("\n" + i.toString() + "\n");
        }
    }

    static void saveDate() {
        FileWriter fw = null;

         try {
            fw = new FileWriter(FILENAME);

            String fileContent = "     NAME     | ADDRESS                                  | GPA \n---------------------------------------------------------------\n";
            fw.write(fileContent);

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
}
