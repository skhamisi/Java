import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.ListIterator;
import java.util.Scanner;

public class Vehicle {
    
    public static String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    static ArrayList<AutoMobile> vehicleList = new ArrayList<>();
    public static Date date = new Date();
    //public static final String FILENAME = "C:\\Users\\Samer\\Desktop\\AUTO_INVENTORY.txt";
    public static final String FILENAME = "C:\\Users\\Samer.Khamisi\\Documents\\AUTO_INVENTORY.txt";
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
        Util.PressEnter();
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
        boolean found = false;
        while(iterator.hasNext()){
            AutoMobile existingAuto = iterator.next();
            if (existingAuto.getMake().equalsIgnoreCase(make) && existingAuto.getModel().equalsIgnoreCase(model)
            && existingAuto.getIndex() == index) {
                iterator.remove();
                found = true;
                break;
            }
        }

        if(found){
            System.out.println(GREEN + "\nSTATUS: Succesful" + RESET);
            Util.PressEnter();
        }
        else{
            System.out.println(RED + "\nSTATUS: Failed");
            System.out.println("*Vehicle does not exist" + RESET);
            Util.PressEnter();
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
        boolean found = false;

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
                found = true;
                break;
            }
        }

        if (found){
            System.out.println(GREEN + "\nSTATUS: Succesful" + RESET);
            Util.PressEnter();
        }
        else {
            System.out.println(RED + "\nSTATUS: Failed");
            System.out.println("*Vehicle does not exist" + RESET);
            Util.PressEnter();
        }
    }

    public static void printfile() {

        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            fw = new FileWriter(FILENAME);
            bw = new BufferedWriter(fw);
            String fileContent = "File Date: " + date + "\n\nID | Make | Model | Color | Year | Mileage\n------------------------------------------\n";
            bw.write(fileContent);
            
            for (AutoMobile auto : vehicleList) {

                bw.write(auto.toString() + "\n");
            }
            bw.close();

            System.out.println(YELLOW + "FILE OUTPUT:\n" + RESET);
            System.out.println("\nVEHICLE INVENTORY");
            System.out.println("Index | Make | Model | Color | Year | Mileage\n---------------------------------------------\n");
    
            for (AutoMobile auto : vehicleList) {
                System.out.println(auto.getIndex() + "     " + auto.getMake() + "   " + auto.getModel() + "   " + auto.getColor()+ "   " + auto.getYear() + "   " + auto.getMileage() + " mi." + "\n");
            }
    
            System.out.println(GREEN + "\nFILE OUTPUT STATUS: Success" + RESET);
            Util.PressEnter();

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
}
