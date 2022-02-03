import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;

public class Vehicle {
    
    static ArrayList<AutoMobile> vehicleList = new ArrayList<>();

    // Adds vehicle to inventory list
    public static void AddVehicle() {
        Util.PrintHeader();

        System.out.println("      *Add Vehicle*      ");
        System.out.println("-------------------------");
        System.out.print("Enter Vehicle Make: " + Util.YELLOW);
        String make = Util.scan.next();
        System.out.print(Util.RESET + "Enter Vehicle Model: " + Util.YELLOW);
        String model = Util.scan.next();
        System.out.print(Util.RESET + "Enter Vehicle Color: " + Util.YELLOW);
        String color = Util.scan.next();
        System.out.print(Util.RESET + "Enter Vehicle Year: " + Util.YELLOW);
        int year = Util.scan.nextInt();
        System.out.print(Util.RESET + "Enter Vehicle Mileage: " + Util.YELLOW);
        int mileage = Util.scan.nextInt();
        System.out.print(Util.RESET + "Enter the Vehicle ID: " + Util.YELLOW);
        int id = Util.scan.nextInt();

        AutoMobile newAuto = new AutoMobile(make, model, color, year, mileage, id);
        vehicleList.add(newAuto);

        System.out.println(Util.GREEN + "\nSTATUS: Succesful" + Util.RESET);
        Util.PressEnter();
    }

    // Removes vehicle from inventory list
    public static void RemoveVehicle() {
        Util.PrintHeader();

        System.out.println("      *REMOVE VEHICLE*");
        System.out.println("---------------------------");
        System.out.print("Enter Vehicle Make: " + Util.YELLOW);
        String make = Util.scan.next();
        System.out.print(Util.RESET + "Enter Vehicle Model: " + Util.YELLOW);
        String model = Util.scan.next();
        System.out.print(Util.RESET + "Enter Vehicle ID: " + Util.YELLOW);
        int id = Util.scan.nextInt();

        ListIterator<AutoMobile> iterator = vehicleList.listIterator();
        boolean found = false;

        while(iterator.hasNext()){
            AutoMobile existingAuto = iterator.next();

            if (existingAuto.GetMake().equalsIgnoreCase(make) && existingAuto.GetModel().equalsIgnoreCase(model)
            && existingAuto.getID() == id) {
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

    // Finds vehicle in inventory list and allows user to update vehicle attributes
    public static void UpdateVehicle() {
        Util.PrintHeader();

        System.out.println("      UPDATE VEHICLE      ");
        System.out.println("-------------------------");
        System.out.print("Enter Vehicle Make: " + Util.YELLOW);
        String make = Util.scan.next();
        System.out.print(Util.RESET + "Enter Vehicle Model: " + Util.YELLOW);
        String model = Util.scan.next();
        System.out.print(Util.RESET + "Enter Vehicle ID: " + Util.YELLOW);
        int id = Util.scan.nextInt();

        ListIterator<AutoMobile> iterator = vehicleList.listIterator();
        boolean found = false;

        while(iterator.hasNext()) {
            AutoMobile existingAuto = iterator.next();

            if (existingAuto.GetMake().equalsIgnoreCase(make) && existingAuto.GetModel().equalsIgnoreCase(model)
            && existingAuto.getID() == id) {
                System.out.println(Util.GREEN + "\n*Vehicle Found*" + Util.RESET);
                System.out.println("---------------");
                System.out.println("Please enter updated values");
                System.out.print("Make: " + Util.YELLOW);
                make = Util.scan.next();
                System.out.print(Util.RESET + "Model: " + Util.YELLOW);
                model = Util.scan.next();
                System.out.print(Util.RESET + "Color: " + Util.YELLOW);
                String color = Util.scan.next();
                System.out.print(Util.RESET + "Year: " + Util.YELLOW);
                int year = Util.scan.nextInt();
                System.out.print(Util.RESET + "Mileage : " + Util.YELLOW);
                int mileage = Util.scan.nextInt();

                existingAuto.SetMake(make);
                existingAuto.SetModel(model);
                existingAuto.SetColor(color);
                existingAuto.SetYear(year);
                existingAuto.SetMileage(mileage);
                //existingAuto.setIndex(id);
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

    // Prints .txt file with all current vehicles in inventory list
    public static void PrintFile() {

        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            fw = new FileWriter(Util.FILENAME);
            bw = new BufferedWriter(fw);

            Util.PrintHeader();

            System.out.print("\nWould you like to print a text file of the inventory?\n");
            System.out.print(Util.CYAN + "(Y) yes / (N) No: " + Util.YELLOW);
            String printChoice = Util.scan.next();
            System.out.print(Util.RESET);
            if (printChoice.equalsIgnoreCase("Y")) {

                String fileContent = "Inventory Date: " + Util.date + "\n\nID | Make | Model | Color | Year | Mileage\n------------------------------------------\n";
                bw.write(fileContent);
                
                for (AutoMobile auto : vehicleList) {
    
                    bw.write(auto.toString() + "\n");
                }
                bw.close();

                System.out.println(Util.GREEN + "\nFILE OUTPUT STATUS: Success" + Util.RESET);
                Util.PressEnter();
            }
            else {
                System.out.println("Text file will not be printed.");
                System.out.println(Util.RED + "\nFILE OUTPUT STATUS: Not Printed" + Util.RESET);
                Util.PressEnter();
            }

            Util.PrintHeader();

            System.out.println(Util.CYAN + "CURRENT INVENTORY:\n" + Util.RESET);
            System.out.println("\nVEHICLE INVENTORY");
            System.out.println("ID | Make | Model | Color | Year | Mileage\n---------------------------------------------\n");
    
            for (AutoMobile auto : vehicleList) {
                System.out.println(auto.getID() + "     " + auto.GetMake() + "   " + auto.GetModel() + "   " + auto.GetColor()+ "   " + auto.GetYear() + "   " + auto.GetMileage() + " mi." + "\n");
            }

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
