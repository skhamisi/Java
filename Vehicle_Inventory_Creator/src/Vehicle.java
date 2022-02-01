import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;

public class Vehicle {
    
    static ArrayList<AutoMobile> vehicleList = new ArrayList<>();
    //public static final String FILENAME = "C:\\Users\\Samer\\Desktop\\AUTO_INVENTORY.txt";
    public static final String FILENAME = "C:\\Users\\Samer.Khamisi\\Documents\\AUTO_INVENTORY.txt";

    public static void addVehicle() {
        System.out.println(Util.YELLOW + "VEHICLE INVENTORY MANAGEMENT SYSTEM\n\n");
        System.out.println("      *Add Vehicle*      " + Util.RESET);
        System.out.println("-------------------------");
        System.out.print("Enter Vehicle Make: ");
        String make = Util.scan.next();
        System.out.print("Enter Vehicle Model: ");
        String model = Util.scan.next();
        System.out.print("Enter Vehicle Color: ");
        String color = Util.scan.next();
        System.out.print("Enter Vehicle Year: ");
        int year = Util.scan.nextInt();
        System.out.print("Enter Vehicle Mileage: ");
        int mileage = Util.scan.nextInt();
        System.out.print("Enter the Vehicle Index Number: ");
        int index = Util.scan.nextInt();
        AutoMobile newAuto = new AutoMobile(make, model, color, year, mileage, index);
        vehicleList.add(newAuto);

        System.out.println(Util.GREEN + "\nSTATUS: Succesful" + Util.RESET);
        Util.PressEnter();
    }

    public static void removeVehicle() {
        System.out.println(Util.YELLOW + "VEHICLE INVENTORY MANAGEMENT SYSTEM\n\n");
        System.out.println("      *REMOVE VEHICLE*" + Util.RESET);
        System.out.println("---------------------------");
        System.out.print("Enter Vehicle Make: ");
        String make = Util.scan.next();
        System.out.print("Enter Vehicle Model: ");
        String model = Util.scan.next();
        System.out.print("Enter the Vehicle Index Number: ");
        int index = Util.scan.nextInt();
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
            System.out.println(Util.GREEN + "\nSTATUS: Succesful" + Util.RESET);
            Util.PressEnter();
        }
        else{
            System.out.println(Util.RED + "\nSTATUS: Failed");
            System.out.println("*Vehicle does not exist" + Util.RESET);
            Util.PressEnter();
        }

    }

    public static void updateVehicle() {
        System.out.println(Util.YELLOW + "VEHICLE INVENTORY MANAGEMENT SYSTEM\n\n");
        System.out.println("      UPDATE VEHICLE      " + Util.RESET);
        System.out.println("-------------------------");
        System.out.print("Enter the Make of Automobile: ");
        String make = Util.scan.next();
        System.out.print("Enter the Model of Automobile: ");
        String model = Util.scan.next();
        System.out.print("Enter the Vehicle Index Number: ");
        int index = Util.scan.nextInt();

        ListIterator<AutoMobile> iterator = vehicleList.listIterator();
        boolean found = false;

        while(iterator.hasNext()) {

            AutoMobile existingAuto = iterator.next();

            if (existingAuto.getMake().equalsIgnoreCase(make) && existingAuto.getModel().equalsIgnoreCase(model)
            && existingAuto.getIndex() == index) {
                System.out.println(Util.GREEN + "\n*Vehicle Found*" + Util.RESET);
                System.out.println("---------------");
                System.out.println("Please enter updated values");
                System.out.print("Make: ");
                make = Util.scan.next();
                System.out.print("Model: ");
                model = Util.scan.next();
                System.out.print("Color: ");
                String color = Util.scan.next();
                System.out.print("Year: ");
                int year = Util.scan.nextInt();
                System.out.print("Mileage : ");
                int mileage = Util.scan.nextInt();
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
            System.out.println(Util.GREEN + "\nSTATUS: Succesful" + Util.RESET);
            Util.PressEnter();
        }
        else {
            System.out.println(Util.RED + "\nSTATUS: Failed");
            System.out.println("*Vehicle does not exist" + Util.RESET);
            Util.PressEnter();
        }
    }

    public static void printfile() {

        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            fw = new FileWriter(FILENAME);
            bw = new BufferedWriter(fw);
            String fileContent = "File Date: " + Util.date + "\n\nID | Make | Model | Color | Year | Mileage\n------------------------------------------\n";
            bw.write(fileContent);
            
            for (AutoMobile auto : vehicleList) {

                bw.write(auto.toString() + "\n");
            }
            bw.close();

            System.out.println(Util.YELLOW + "FILE OUTPUT:\n" + Util.RESET);
            System.out.println("\nVEHICLE INVENTORY");
            System.out.println("Index | Make | Model | Color | Year | Mileage\n---------------------------------------------\n");
    
            for (AutoMobile auto : vehicleList) {
                System.out.println(auto.getIndex() + "     " + auto.getMake() + "   " + auto.getModel() + "   " + auto.getColor()+ "   " + auto.getYear() + "   " + auto.getMileage() + " mi." + "\n");
            }
    
            System.out.println(Util.GREEN + "\nFILE OUTPUT STATUS: Success" + Util.RESET);
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
