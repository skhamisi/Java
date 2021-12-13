import java.util.Scanner;

public class Information_Creator {
    public static void main(String[] args) throws Exception 
    {
        try (Scanner input = new Scanner(System.in)) 
        {
            ClearScreen();
            System.out.println("Please fill in the information below");
            System.out.println("------------------------------------");

            System.out.print("First Name: ");
            String first_name = input.nextLine();

            System.out.print("Last Name: ");
            String last_name = input.nextLine();

            System.out.print("Street address: ");
            String street_address = input.nextLine();

            System.out.print("City: ");
            String city = input.nextLine();

            System.out.print("Zip code: ");
            Integer zip = input.nextInt();

            System.out.print("\n");

            CreatePerson(first_name, last_name, street_address, city, zip);
        }
    }

    public static void CreatePerson(String first_name, String last_name, String street_address, String city, Integer zip)
    {
        System.out.println("Displaying Information");
        System.out.println("----------------------");
        System.out.println(first_name);
        System.out.println(last_name);
        System.out.println(street_address);
        System.out.println(city);
        System.out.println(zip);
        System.out.print("\n");
    }

    public static void ClearScreen() 
    {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
}
