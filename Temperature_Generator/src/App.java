import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        String[] weekDay = {"Sunday", "Monday", "Tueday", "Wednesday", "Thursday", "Friday", "Saturday"};

        Integer[] temp = {22, 77, 80, 72, 61, 44, 32};
        
        System.out.println("WEATHER STATION");
        System.out.println("---------------\n");
        System.out.println("Enter a day of the week to display temperature.");
        System.out.println("*For weekly forcast, please enter 'week'\n");
        System.out.print("Enter Choice: ");
        Scanner scan = new Scanner(System.in);
        String userChoice = scan.next().toLowerCase();
        System.out.print("\n");

        switch (userChoice) {
            case "sunday":
            System.out.println("Day: " + weekDay[0] + " | " + "Temperature: " + temp[0]);
            break;
            case "monday":
                System.out.println("Day: " + weekDay[1] + " | " + "Temperature: " + temp[1]);
                break;
            case "tuesday":
            System.out.println("Day: " + weekDay[2] + " | " + "Temperature: " + temp[2]);
                break;
            case "wednesday":
                System.out.println("Day: " + weekDay[3] + " | " + "Temperature: " + temp[3]);
                break;
            case "thursday":
                System.out.println("Day: " + weekDay[4] + " | " + "Temperature: " + temp[4]);
            break;
            case "friday":
                System.out.println("Day: " + weekDay[5] + " | " + "Temperature: " + temp[5]);
            break;
            case "saturday":
                System.out.println("Day: " + weekDay[6] + " | " + "Temperature: " + temp[6]);
            break;
            case "week":
                for(int i = 0; i < weekDay.length; i++) {

                    for(int j = 0; i < temp.length; j++) {
                        System.out.println("Day: " + weekDay[i] + " | " +"Temperature: " + temp[j] + "\n");
                        i++;
                    }
                }
            break;
            default:
            System.out.println("Invalid Choice");
        }
    }
}
