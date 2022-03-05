import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

public class JMenuBarDemo {

    private final JFrame mainFrame;
    private final JMenuBar menuBar;
    private final JMenu mainMenu;
    private final JMenuItem displayDate, printLog, changeColor, exit;
    private final JPanel displayBox;
    private final Border blackline, loweredbevel;
    static final DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("dd/MM/yyyy h:mm a");
    //final String FILENAME = "C:\\Users\\Samer\\Desktop\\log.txt";
    final String FILENAME = "C:\\Users\\skham\\Documents\\log.txt";
    static final Random rand = new Random();

    public JMenuBarDemo() {

        //Creates the main display fram
        this.mainFrame = new JFrame("Menu Demo");
        mainFrame.setLayout(new FlowLayout());
        mainFrame.setPreferredSize(new Dimension(400, 200));

        //Creates the menu bar container that will hold the menu(s)
        this.menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        //Creates the menu container that will hold item(s)
        this.mainMenu = new JMenu("Main Menu");
        mainMenu.getAccessibleContext().setAccessibleDescription(
        "The only menu in this program that has menu items");
        menuBar.add(mainMenu);

        this.displayBox = new JPanel();
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
        mainFrame.add(displayBox, SwingConstants.CENTER);
        displayBox.setPreferredSize(new Dimension(300, 100));
        mainFrame.pack();

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(true);
        mainFrame.setLocationRelativeTo(null);

        mainFrame.setVisible(true); 
    }

    private void showDate(JPanel panel) {
        String date = LocalDateTime.now().format(formattedDate);
        JLabel showDate = new JLabel("" + date, SwingConstants.CENTER);
        showDate.setFont(new Font("Verdana",1,20));
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
                    fw.write(panelText);
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
 
        Color green0 = new Color(9, 121, 105);
        Color green1 = new Color(102, 255, 51);
        Color green2 = new Color(0, 102, 0);
        Color green3 = new Color(0, 201, 102);

        Integer color = rand.nextInt(0, 3);

        if(color == 0) {
            frame.getContentPane().setBackground(green0);
            frame.revalidate();
        }
        else if(color == 1) {
            frame.getContentPane().setBackground(green1);
            frame.revalidate();
        }
        else if(color == 2) {
            frame.getContentPane().setBackground(green2);
            frame.revalidate();
        }
        else if(color == 3) {
            frame.getContentPane().setBackground(green3);
            frame.revalidate();
        }
    }
}
