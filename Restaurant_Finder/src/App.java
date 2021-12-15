import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        ClearScreen();
        System.out.println("Please select a restaurant to display information \n Enter [1] for Chick-fil-A \n Enter [2] for Jimmy John's \n Enter [3] for Pizza Hut\n");

        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter Selection: ");
            Integer userChoice = input.nextInt();
            DisplayRestaurant(userChoice);
        }
    }

    public static void DisplayRestaurant(Integer choice)
    {
        System.out.println("");
        if (choice == 1)
        {
            System.out.println("Chick-fil-A");
            System.out.println("1031 W University Ave");
            System.out.println("Georgetown, TX, 78628");
        }
        else if (choice == 2)
        {
            System.out.println("Jimmy John's");
            System.out.println("1400 E W Whitestone Blvd #500");
            System.out.println("Cedar Park, TX, 78613");
        }
        else if (choice == 3)
        {
            System.out.println("Pizza Hut");
            System.out.println("1395 S Hwy 183");
            System.out.println("Leander, TX, 78641");
        }
        System.out.println("");
    }

    public static void ClearScreen() 
    {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
}
