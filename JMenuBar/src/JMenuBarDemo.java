import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class JMenuBarDemo {

    private final JFrame mainFrame;
    private final JMenuBar menuBar;
    private final JMenu mainMenu;
    private final JMenuItem displayDate, printLog, changeColor, exit;
    private final JPanel displayBox;
    private final Border blackline, loweredbevel;
    static final LocalDateTime localDateTime = LocalDateTime.now();
    static final DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("dd/MM/yyyy h:mm a");
    static final String date = localDateTime.format(formattedDate);
    final String FILENAME = "C:\\Users\\Samer\\Desktop\\log.txt";
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

        JLabel showDate = new JLabel("" + date, SwingConstants.CENTER);
        showDate.setFont(new Font("Verdana",1,20));
        panel.add(showDate);
        panel.revalidate();
    }

    private void saveDate(JPanel panel) {
        BufferedWriter bw = null;
        FileWriter fw = null;

         try {
            fw = new FileWriter(FILENAME);
            bw = new BufferedWriter(fw);

            String data = panel.getComponents().toString();
            bw.write(data);
            
            bw.close();
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

    private static void changeColor(JFrame frame) {
 
        Color green0 = new Color(9, 121, 105);
        Color green1 = new Color(102, 255, 51);
        Color green2 = new Color(0, 102, 0);
        Color green3 = new Color(0, 201, 102);

        Color[] colors = {green0, green1, green2, green3 };
        int color = rand.nextInt(colors.length);

        switch (color) {
            case 0:
            frame.getContentPane().setBackground(green0);
            frame.revalidate();
            case 1:
            frame.getContentPane().setBackground(green1);
            frame.revalidate();
            case 2:
            frame.getContentPane().setBackground(green2);
            frame.revalidate();
            case 3:
            frame.getContentPane().setBackground(green3);
            frame.revalidate();
            default:
                break;
        }
    }
}
