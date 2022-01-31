import java.io.*;
import java.util.ArrayList;
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

    // Overrides toString() to return values of arrayList
    @Override
    public String toString() {
       return this.getIndex() + "   " + this.getMake() + "  " + this.getModel() + "  " + this.getColor()+ "  " + this.getYear() + "  " + this.getMileage() + " mi.";
    }

}

class Vehicle {

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    static ArrayList<AutoMobile> vehicleList = new ArrayList<>();
    public static final String FILENAME = "C:\\Users\\Samer\\Desktop\\AUTO_INVENTORY.txt";
    //public static final String FILENAME = "C:\\Users\\Samer.Khamisi\\Documents\\AUTO_INVENTORY.txt";
    static Scanner scan = new Scanner(System.in);

    public static void addVehicle() {
        System.out.println(YELLOW + "VEHICLE INVENTORY MANAGEMENT SYSTEM\n\n");
        System.out.println("      *Add Vehicle*      " + RESET);
        System.out.println("-------------------------");
        System.out.print("Enter Vehicle Make: ");
        String make = scan.next();
        System.out.print("Enter Vehicle Model: ");
        String model = scan.next();
        System.out.print("Enter Vehicle Color: ");
        String color = scan.next();
        System.out.print("Enter Vehicle Year: ");
        int year = scan.nextInt();
        System.out.print("Enter Vehicle Mileage: ");
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
        System.out.println("      *REMOVE VEHICLE*" + RESET);
        System.out.println("---------------------------");
        System.out.print("Enter Vehicle Make: ");
        String make = scan.next();
        System.out.print("Enter Vehicle Model: ");
        String model = scan.next();
        System.out.print("Enter the Vehicle Index Number: ");
        int index = scan.nextInt();
        ListIterator<AutoMobile> iterator = vehicleList.listIterator();
        boolean find = false;
        while(iterator.hasNext()){
            AutoMobile existingAuto = iterator.next();
            if (existingAuto.getMake().equalsIgnoreCase(make) && existingAuto.getModel().equalsIgnoreCase(model)
            && existingAuto.getIndex() == index) {
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
        System.out.println("      UPDATE VEHICLE      " + RESET);
        System.out.println("-------------------------");
        System.out.print("Enter the Make of Automobile: ");
        String make = scan.next();
        System.out.print("Enter the Model of Automobile: ");
        String model = scan.next();
        System.out.print("Enter the Vehicle Index Number: ");
        int index = scan.nextInt();

        ListIterator<AutoMobile> iterator = vehicleList.listIterator();
        boolean find = false;

        while(iterator.hasNext()) {

            AutoMobile existingAuto = iterator.next();

            if (existingAuto.getMake().equalsIgnoreCase(make) && existingAuto.getModel().equalsIgnoreCase(model)
            && existingAuto.getIndex() == index) {
                System.out.println(GREEN + "\n*Vehicle Found*" + RESET);
                System.out.println("---------------");
                System.out.println("Please enter updated values");
                System.out.print("Make: ");
                make = scan.next();
                System.out.print("Model: ");
                model = scan.next();
                System.out.print("Color: ");
                String color = scan.next();
                System.out.print("Year: ");
                int year = scan.nextInt();
                System.out.print("Mileage : ");
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
            
            for (AutoMobile auto : vehicleList) {

                bw.write(auto.toString() + "\n");
            }
            bw.close();

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
        scan.nextLine();
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

            System.out.print("\nENTER SELECTION: ");
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
                System.out.println("\nSYSTEM SHUTTING DOWN...");
                System.out.println("\nGOODBYE.");
                System.exit(0);
                break;
                default:
                    System.out.println(RED + "\nInvalid choice" + RESET);
                    PressEnter();
            }

            if(userChoice == 4)
                break;

        } while (true);

        // PrintWriter pw = new PrintWriter("VEHICLE INVENTORY");
        // String text = "Index | Make | Model | Color | Year | Mileage\n---------------------------------------------\n";

        // for (AutoMobile auto : vehicleList) {
        //     text += auto.getIndex() + "     " + auto.getMake() + "   " + auto.getModel() + "   " + auto.getColor()+ "   " + auto.getYear() + "   " + auto.getMileage() + " mi." + "\n";
        // }

        // pw.write(text);
        // pw.flush();
        // pw.close();

        // System.out.println(GREEN + "FILE OUTPUT STATUS: Success" + RESET);
        // System.out.println();
        // System.out.println(text);

        System.out.println("VEHICLE INVENTORY");
        System.out.println("Index | Make | Model | Color | Year | Mileage\n---------------------------------------------\n");

        for (AutoMobile auto : vehicleList) {
            System.out.println(auto.getIndex() + "     " + auto.getMake() + "   " + auto.getModel() + "   " + auto.getColor()+ "   " + auto.getYear() + "   " + auto.getMileage() + " mi." + "\n");
        }

        System.out.println(GREEN + "FILE OUTPUT STATUS: Success" + RESET);
    }
}