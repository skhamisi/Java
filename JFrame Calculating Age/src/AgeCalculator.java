import java.awt.Dimension;
import java.awt.Toolkit;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.FlowLayout;

public class AgeCalculator {

    private final LocalDate currentDate = LocalDate.now();
    private final JFrame mainFrame;
    private final JPanel mainPanel;
    private final JComboBox dayComboBox, monthComboBox, yearComboBox;
    private final JLabel dayLabel, monthLabel, yearLabel;
    private final JButton calculateAgeButton, exitButton;

    public AgeCalculator() {

        this.mainFrame = new JFrame("Calculate Age");

        this.mainPanel = new JPanel();

        this.dayLabel = new JLabel("Day:");
        this.monthLabel = new JLabel("Month:");
        this.yearLabel = new JLabel("Year:");
        
        this.dayComboBox = new JComboBox<Integer>();
        for (int i = 1; i <= 31; i++) {
            dayComboBox.addItem(i);
        }

        this.monthComboBox = new JComboBox<Month>(Month.values());

        this.yearComboBox = new JComboBox<Integer>();
        for (int i = currentDate.getYear(); i >= 1930; i--) {
            yearComboBox.addItem(i);
        }

        this.calculateAgeButton = new JButton("Calculate");
        calculateAgeButton.addActionListener(e -> calculateAge());

        this.exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> { 
        int confirmed = JOptionPane.showConfirmDialog(null,
        "Are you sure you want to exit?",
        "EXIT",JOptionPane.YES_NO_OPTION);
            if(confirmed == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        mainPanel.add(calculateAgeButton);
        mainPanel.add(exitButton);


        mainFrame.getContentPane().setLayout(new FlowLayout());
        mainFrame.setPreferredSize(new Dimension(400, 110));
        mainFrame.add(dayLabel);
        mainFrame.getContentPane().add(dayComboBox);
        mainFrame.add(monthLabel);
        mainFrame.getContentPane().add(monthComboBox);
        mainFrame.add(yearLabel);
        mainFrame.getContentPane().add(yearComboBox);
        mainFrame.getContentPane().add(mainPanel);
        //mainFrame.getContentPane().add(exitButton);

        mainFrame.pack();

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(true);

        centerFrame(mainFrame);

        mainFrame.setVisible(true);
    }
    

    private void centerFrame(JFrame frame) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        frame.setLocation((dim.width - frame.getWidth()) / 2,
            (dim.height - frame.getHeight()) / 2);
    }

    private void calculateAge() {
        
        //int day = returnIntValue(dayComboBox);
        Integer day = (Integer)dayComboBox.getSelectedItem();
        Month month = (Month)monthComboBox.getSelectedItem();
        // int year = returnIntValue(yearComboBox);
        Integer year = (Integer)yearComboBox.getSelectedItem();

        // LocalDate start = LocalDate.of(year, 
        // monthComboBox.getSelectedIndex() + 1,
        // day);

        LocalDate start = LocalDate.of(year, 
        month.getValue(),
        day);

        if ((start != null) && (currentDate != null)) {
            long years = ChronoUnit.YEARS.between(start, currentDate);

        JOptionPane.showMessageDialog(
                mainFrame,
                "You are " + years + " years"  + " old.",
                "Age",
                JOptionPane.INFORMATION_MESSAGE);
        
        // JFrame ageFrame = new JFrame();
        // centerFrame(ageFrame);
        // ageFrame.setSize(200, 100);
        // JLabel showAge = new JLabel("You are " + years + " years"  + " old.", SwingConstants.CENTER);
        // ageFrame.add(showAge);

        // ageFrame.setVisible(true);
        }
    }

    /**
     * @newFrame() is an experimental method for creating new JFrame
     */
    // void newFrame(JFrame jFrameName, JLabel jLabelName, String message) {
    //     jFrameName = new JFrame();
    //     centerFrame(jFrameName);
    //     jFrameName.setSize(200, 100);
    //     jLabelName = new JLabel(message, SwingConstants.CENTER);
    //     jFrameName.add(jLabelName);

    //     jFrameName.setVisible(true);
    // }

    /**
     * Gets the numeric value
     * 
     * @return the numeric object value of the JComboBox
     */
    private int returnIntValue(JComboBox objectValue) {
        int intValue = Integer.parseInt(objectValue.getSelectedItem().toString());
        return intValue;
    }

    public static void main(final String... args) {
        javax.swing.SwingUtilities.invokeLater(AgeCalculator::new);
    }
}

