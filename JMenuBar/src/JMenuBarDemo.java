import java.io.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class JMenuBarDemo {

    private final JFrame mainFrame;
    private final JMenuBar menuBar;
    private final JMenu mainMenu;
    private final JMenuItem displayDate, printLog, changeColor, exit;
    private final JPanel displayBox;
    private final Border blackline, loweredbevel;
    static final DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("MM/dd/yyyy h:mm a");
    //final String FILENAME = "C:\\Users\\Samer\\Desktop\\log.txt";
    final String FILENAME = "C:\\Users\\skham\\Documents\\log.txt";
    //final String FILENAME = "C:\\Users\\public\\log.txt";
    static final Random rand = new Random();

    public JMenuBarDemo() {

        //Creates the main display fram
        this.mainFrame = new JFrame("Menu Demo");
        JFrame.setDefaultLookAndFeelDecorated(true);
        mainFrame.setLayout(new GridBagLayout());
        mainFrame.setPreferredSize(new Dimension(400, 200));

        //Creates the menu bar container that will hold the menu(s)
        this.menuBar = new JMenuBar();
        menuBar.setBackground(Color.BLUE);
        
        //Creates the menu container that will hold item(s)
        this.mainMenu = new JMenu("Main Menu");
        mainMenu.setForeground(Color.WHITE);
        menuBar.add(mainMenu);

        this.displayBox = new JPanel();
        displayBox.setPreferredSize(new Dimension(300, 100));
        this.blackline = BorderFactory.createLineBorder(Color.BLACK);
        this.loweredbevel = BorderFactory.createLoweredBevelBorder();
        displayBox.setBorder(blackline);
        displayBox.setBorder(loweredbevel);

        //Adds the menu item(s) to the menu container
        this.displayDate = new JMenuItem("Display date");
        displayDate.addActionListener(e -> showDate(displayBox));

        //Changes background color of frame
        this.changeColor = new JMenuItem("Change background color");
        changeColor.addActionListener(e -> changeColor(mainFrame));

        //Saves current content in the JPanel to a .txt file
        this.printLog = new JMenuItem("Save date to log");
        printLog.addActionListener(e -> saveDate(displayBox));

        //Exits program
        this.exit = new JMenuItem("Exit");
        exit.addActionListener(e -> System.exit(0));


        mainMenu.add(displayDate);
        mainMenu.add(printLog);
        mainMenu.add(changeColor);
        mainMenu.add(exit);


        mainFrame.setJMenuBar(menuBar);
        mainFrame.add(displayBox);
        mainFrame.pack();

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(true);
        mainFrame.setLocationRelativeTo(null);

        mainFrame.setVisible(true); 
    }

    private void showDate(JPanel panel) {
        String date = LocalDateTime.now().format(formattedDate);
        JLabel showDate = new JLabel("" + date);
        showDate.setFont(new Font("Verdana", 1, 20));
        panel.add(showDate);
        panel.revalidate();
    }

    private void saveDate(JPanel panel) {
        FileWriter fw = null;

         try {
            fw = new FileWriter(FILENAME);

            for (int i = 0; i < panel.getComponents().length; i++) {
                
                if (panel.getComponent(i) instanceof JLabel) {
                    String panelText = ((JLabel) panel.getComponent(i)).getText();
                    fw.write(panelText + "\n\n");
                }
            }
            fw.close();
            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } finally {
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static void changeColor(JFrame frame) {

        //Generates random int value between 100-255 (Approximate green values for RGB)
        int g = rand.nextInt(100, 255);
        // Creates new green hue
        Color randomGreenHue = new Color(0, g, 0);

        frame.getContentPane().setBackground(randomGreenHue);
        frame.revalidate();
    }
}
