import java.util.Arrays;
import java.util.InputMismatchException;

public class Game {

    private static String[] board;
    private static String turn;
    
    
    /* 
    CheckWinner method will 
    decide the combination 
    of three boxes given below.
    */
    private static String checkWinner()
    {
        for (int i = 0; i < 8; i++) {
            String line = null;
  
            switch (i) {
            case 0:
                line = board[0] + board[1] + board[2];
                break;
            case 1:
                line = board[3] + board[4] + board[5];
                break;
            case 2:
                line = board[6] + board[7] + board[8];
                break;
            case 3:
                line = board[0] + board[3] + board[6];
                break;
            case 4:
                line = board[1] + board[4] + board[7];
                break;
            case 5:
                line = board[2] + board[5] + board[8];
                break;
            case 6:
                line = board[0] + board[4] + board[8];
                break;
            case 7:
                line = board[2] + board[4] + board[6];
                break;
            }
            //For X winner
            if (line.equals("XXX")) {
                return "X";
            }
              
            // For O winner
            else if (line.equals("OOO")) {
                return "O";
            }
        }
          
        for (int i = 0; i < 9; i++) {
            if (Arrays.asList(board).contains(String.valueOf(i + 1))) {
                break;
            }
            else if (i == 8) {
                return "draw";
            }
        }
  
       // Change player color
       if(turn.equalsIgnoreCase("x")) {
           System.out.print(Util.GREEN);
        } else {
           System.out.print(Util.RED);
        }

        // To enter X Or O on the board.
        System.out.println("\n" 
        + turn 
        + "'s turn. Enter a slot number (1-9): ");
        System.out.print(Util.RESET);
        return null;
    }
      
    /* 
    Print out the board.
    | 1 | 2 | 3 |
    |-----------|
    | 4 | 5 | 6 |
    |-----------|
    | 7 | 8 | 9 |
    */
    
    public static void printBoard()
    {
        Util.PrintHeader();
        System.out.print("\n");
        System.out.println("| " + board[0] + " | "
                           + board[1] + " | " + board[2]
                           + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | "
                           + board[4] + " | " + board[5]
                           + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | "
                           + board[7] + " | " + board[8]
                           + " |");
    }

    public static void gameInit() {
        board = new String[9];
        turn = "X";
        String winner = null;
  
        for (int a = 0; a < 9; a++) {
            board[a] = String.valueOf(a + 1);
        }

        printBoard();
  
        System.out.print("\nX will play first. Enter a slot number (1-9): ");
  
        while (winner == null) {
            int numInput;
            
           // Exception handling.
           // numInput will take input from user like from 1 to 9.
           // If it is not in range from 1 to 9.
           // then it will show you an error "Invalid input."
            try {
                numInput = Util.scan.nextInt();
                if (!(numInput > 0 && numInput <= 9)) {
                    System.out.println("Invalid input; re-enter slot number:");
                    continue;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid input; re-enter slot number:");
                continue;
            }
              
            // Decide who's turn it is
            if (board[numInput - 1].equals(String.valueOf(numInput))) {

                board[numInput - 1] = turn;
  
                if (turn.equals("X")) {
                    turn = "O";
                }
                else {
                    turn = "X";
                }
  
                printBoard();
                winner = checkWinner();
            }
            else {
                System.out.println("Slot already taken; re-enter slot number:");
            }
        }
        
        // If no one wins or loses, prints draw
        if (winner.equalsIgnoreCase("draw")) {
            System.out.println("\nIt's a draw! Thanks for playing.");
            Util.PressEnter();
        }
        
        // Winner fanfare
        else {
            System.out.println("\n" 
            + winner
            + " is the winner! Thanks for playing.");
            Util.PressEnter();
        }
    }
}
