import java.util.Enumeration;
import java.util.Hashtable;

public class App 
{
    public static void main(String[] args) 
    {
        Hashtable<String, Byte> family = new Hashtable<>();

        family.put("Anakin", (byte) 45);
        family.put("Luke", (byte) 17);
        family.put("Leia", (byte) 15);

        Enumeration<String> e = family.keys();
 
        // Iterating through the Hashtable
        // object
 
        // Checking for next element in Hashtable object
        // with the help of hasMoreElements() method
        while (e.hasMoreElements()) {
 
            // Getting the key of a particular entry
            String key = e.nextElement();
 
            // Print and display the Rank and Name
            System.out.println("Name: " + key + "\t Age: " + family.get(key));
        }
    }
}
