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
import java.awt.FlowLayout;

public class AgeCalculator {

    private final LocalDate currentDate = LocalDate.now();
    private final JFrame frame;
    private final JComboBox dayComboBox, monthComboBox, yearComboBox;
    private final JLabel dayLabel, monthLabel, yearLabel;
    private final JButton calculateAgeButton, exitButton;

    public AgeCalculator() {

        this.frame = new JFrame("Calculate Age");

        this.dayLabel = new JLabel("Day:");
        this.monthLabel = new JLabel("Month:");
        this.yearLabel = new JLabel("Year:");
        
        this.dayComboBox = new JComboBox<>();
        for(int i = 1; i <= 31; i++) {
            dayComboBox.addItem(i);
        }

        this.monthComboBox = new JComboBox<>(Month.values());

        this.yearComboBox = new JComboBox<>();
        for(int i = currentDate.getYear(); i >= 1940; i--) {
            yearComboBox.addItem(i);
        }

        this.calculateAgeButton = new JButton("Calculate");
        calculateAgeButton.addActionListener(e -> calculateAge());

        this.exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0));


        frame.getContentPane().setLayout(new FlowLayout());
        frame.setPreferredSize(new Dimension(400, 110));
        frame.add(dayLabel);
        frame.getContentPane().add(dayComboBox);
        frame.add(monthLabel);
        frame.getContentPane().add(monthComboBox);
        frame.add(yearLabel);
        frame.getContentPane().add(yearComboBox);
        frame.getContentPane().add(calculateAgeButton);
        frame.getContentPane().add(exitButton);

        frame.pack();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);

        //Centers frame to middle of screen on startup
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        frame.setLocation((dim.width - frame.getWidth()) / 2,
                (dim.height - frame.getHeight()) / 2);

        frame.setVisible(true);
    }

    public void calculateAge() {
        
        int day = returnIntValue(dayComboBox);
        int year = returnIntValue(yearComboBox);

        LocalDate start = LocalDate.of(year, 
        monthComboBox.getSelectedIndex() + 1,
        day);

        if ((start != null) && (currentDate != null)) {
            long years = ChronoUnit.YEARS.between(start, currentDate);

        JOptionPane.showMessageDialog(
                frame,
                "You are " + years + " years"  + " old.",
                "Age",
                JOptionPane.INFORMATION_MESSAGE);
        
        // JFrame ageFrame = new JFrame();
        // JLabel showAge = new JLabel("You are " + years + " years"  + " old.");
        // ageFrame.add(showAge);

        // ageFrame.setVisible(true);
        }
    }

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

