import java.util.Scanner;

public class ShapeArray {
    public static void main(String[] args) throws Exception {
        clearScreen();
        Scanner scan = new Scanner(System.in);

        System.out.print("Please enter a value for Radius: ");
        double radius = scan.nextDouble();

        System.out.print("Please enter a value for Height: ");
        double height = scan.nextDouble();

        System.out.print("\n");

        Shape[] shapeArray = {new Sphere(radius), new Cylinder(radius, height), new Cone(radius, height)};

        for (Shape i : shapeArray) {
            System.out.println(i + "\n");
        }

        scan.close();
    }

    static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
}
