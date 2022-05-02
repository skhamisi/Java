import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

public class Main {
    public static void main(String[] args) throws Exception {
        
        // Creates Multiset
        Multiset<String> AutoInventory = HashMultiset.create();

        //Adding objects to Multiset
        AutoInventory.add("Tundra");
        AutoInventory.add("Tundra");
        AutoInventory.add("Tundra");
        AutoInventory.add("F-150");
        AutoInventory.add("F-150");
        AutoInventory.add("Silverado");
        AutoInventory.add("Ram");
        AutoInventory.add("Titan");

        // Returns total size of Multiset
        System.out.println("TOTAL VEHICLES IN STOCK: " + AutoInventory.size() + "\n--------------------------");
  
        // print the occurrence of each element
        System.out.printf("Toyota Tundra:           %15s\n", AutoInventory.count("Tundra"));
        System.out.printf("Ford F-150:              %15s\n", AutoInventory.count("F-150"));
        System.out.printf("Chevrolet Silverado:     %15s\n", AutoInventory.count("Silverado"));
        System.out.printf("Dodge RAM:               %15s\n", AutoInventory.count("Ram"));
        System.out.printf("Nissan Titan:            %15s\n", AutoInventory.count("Titan"));
    }
}
