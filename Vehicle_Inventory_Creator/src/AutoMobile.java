import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

public class AutoMobile {

    private String make;
    private String model;
    private String color;
    private int year;
    private int mileage;
    private int index = 300;

    // AutoMobile Object Constructor
    public AutoMobile(String make, String model, String color, int year, int mileage, int index) {
        //super();
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.mileage = mileage;
        this.index = index;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}

class Vehicle {

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    static ArrayList<AutoMobile> vehicleList = new ArrayList<>();
    public static final String FILENAME = "C:\\Users\\Samer\\Desktop\\AUTO_INVENTORY.txt";
    //Prints to location with proper header, but returns package and no vehicles

    public static void addVehicle() {
        System.out.println(YELLOW + "VEHICLE INVENTORY MANAGEMENT SYSTEM\n\n");
        Scanner scan = new Scanner(System.in);
        System.out.println("      *Add Vehicle*      " + RESET);
        System.out.println("-------------------------");
        System.out.print("Enter Vehicle make: ");
        String make = scan.nextLine();
        System.out.print("Enter Vehicle model: ");
        String model = scan.nextLine();
        System.out.print("Enter Vehicle color: ");
        String color = scan.nextLine();
        System.out.print("Enter Vehicle year: ");
        int year = scan.nextInt();
        System.out.print("Enter Vehicle mileage: ");
        int mileage = scan.nextInt();
        System.out.print("Enter the Vehicle Index Number: ");
        int index = scan.nextInt();
        AutoMobile newAuto = new AutoMobile(make, model, color, year, mileage, index);
        vehicleList.add(newAuto);

        System.out.println(GREEN + "\nSTATUS: Succesful" + RESET);
        PressEnter();
    }

    public static void removeVehicle() {
        System.out.println(YELLOW + "VEHICLE INVENTORY MANAGEMENT SYSTEM\n\n");
        Scanner scan = new Scanner(System.in);
        System.out.println("      *REMOVE VEHICLE*" + RESET);
        System.out.println("----------------------------");
        System.out.print("Enter Vehicle make: ");
        String make = scan.nextLine();
        System.out.print("Enter Vehicle model: ");
        String model = scan.nextLine();
        System.out.print("Enter the Vehicle Index Number: ");
        int index = scan.nextInt();
        ListIterator<AutoMobile> iterator =vehicleList.listIterator();
        boolean find = false;
        while(iterator.hasNext()){
            AutoMobile removeAuto = iterator.next();
            if (removeAuto.getMake().equalsIgnoreCase(make) && removeAuto.getModel().equalsIgnoreCase(model)
            && removeAuto.getIndex() == index) { // Line Showing Error
                iterator.remove();
                find = true;
                break;
            }
        }

        if(find){
            System.out.println(GREEN + "\nSTATUS: Succesful" + RESET);
            PressEnter();
        }
        else{
            System.out.println(RED + "\nSTATUS: Failed");
            System.out.println("*Vehicle does not exist" + RESET);
            PressEnter();
        }

    }

    public static void updateVehicle() {
        System.out.println(YELLOW + "VEHICLE INVENTORY MANAGEMENT SYSTEM\n\n");
        Scanner scan = new Scanner(System.in);
        System.out.println("      UPDATE VEHICLE      " + RESET);
        System.out.println("-------------------------");
        System.out.print("Enter the make of Automobile: ");
        String make = scan.nextLine();
        System.out.print("Enter the model of Automobile: ");
        String model = scan.nextLine();
        System.out.print("Enter the Vehicle Index Number: ");
        int index = scan.nextInt();

        ListIterator<AutoMobile> iterator =vehicleList.listIterator();
        boolean find = false;
        while(iterator.hasNext()){
            AutoMobile existingAuto = iterator.next();
            if (existingAuto.getMake().equalsIgnoreCase(make) && existingAuto.getModel().equalsIgnoreCase(model)
            && existingAuto.getIndex() == index) {
                System.out.println(GREEN + "\n*Vehicle found*" + RESET);
                System.out.println("---------------");
                System.out.print("Enter the new make of Automobile: ");
                make = scan.nextLine();
                System.out.print("Enter the new model of Automobile: ");
                model = scan.nextLine();
                System.out.print("Enter the new color of Automobile: ");
                String color = scan.nextLine();
                System.out.print("Enter the new year of Automobile: ");
                int year = scan.nextInt();
                System.out.print("Enter the new mileage of Automobile: ");
                int mileage = scan.nextInt();
                existingAuto.setMake(make);
                existingAuto.setModel(model);
                existingAuto.setColor(color);
                existingAuto.setYear(year);
                existingAuto.setMileage(mileage);
                existingAuto.setIndex(index);
                find = true;
                break;
            }
        }

        if (find){
            System.out.println(GREEN + "\nSTATUS: Succesful" + RESET);
            PressEnter();
        }
        else {
            System.out.println(RED + "\nSTATUS: Failed");
            System.out.println("*Vehicle does not exist" + RESET);
            PressEnter();
        }
    }

    public static void printfile() {
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {

            fw = new FileWriter(FILENAME);
            bw = new BufferedWriter(fw);
            String content = "ID | Make | Model | Color | Year | Mileage\n------------------------------------------\n";
            bw.write(content);
            Iterator<AutoMobile> itr = vehicleList.iterator();

            while(itr.hasNext()){
                bw.write(itr.next().toString() + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 
    
    public static void PressEnter()
    { 
        System.out.println(YELLOW + "\nPress [ENTER] to continue" + RESET);
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
    }
    public static void main(String[] args) throws FileNotFoundException {

        do {
            
            clearScreen();
            System.out.println(YELLOW + "VEHICLE INVENTORY MANAGEMENT SYSTEM\n\n" + RESET);
            System.out.println("INVENTORY OPTIONS");
            System.out.println("=======================*");
            System.out.println("1. Add Vehicle         |");
            System.out.println("2. Remove Vehicle      |");
            System.out.println("3. Update Vehicle      |");
            System.out.println("4. Print Vehicle List  |");
            System.out.println("5. Exit                |");
            System.out.println("=======================*\n");

            Scanner scan = new Scanner(System.in);
            System.out.print("\nPlease enter your choice: ");
            int userChoice = scan.nextInt();

            switch (userChoice) {
                case 1:
                    clearScreen();
                    addVehicle();
                    break;
                case 2:
                    clearScreen();
                    removeVehicle();
                    break;
                case 3:
                    clearScreen();
                    updateVehicle();
                    break;
                case 4:
                    clearScreen();
                    printfile();
                    break;
                case 5:
                System.out.println("\nThank you for using the vehicle management system. Goodbye.");
                System.exit(0);
                break;
                default:
                    System.out.println(RED + "\nInvalid choice" + RESET);
                    PressEnter();
            }

            if(userChoice == 4)
                break;

        } while (true);

        PrintWriter pw = new PrintWriter("VEHICLE INVENTORY");
        String text = "Index | Make | Model | Color | Year | Mileage\n---------------------------------------------\n";

        for (AutoMobile auto : vehicleList) {
            text += auto.getIndex() + "     " + auto.getMake() + "   " + auto.getModel() + "   " + auto.getColor()+ "   " + auto.getYear() + "   " + auto.getMileage() + " mi." + "\n";
        }

        pw.write(text);
        pw.flush();
        pw.close();

        System.out.println(GREEN + "OUTPUT STATUS: Success" + RESET);
        System.out.println();
        System.out.println(text);
    }
}