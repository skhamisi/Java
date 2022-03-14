import java.awt.*;
import java.time.temporal.ChronoUnit;
import java.time.*;
import javax.swing.*;

public class AgeCalculator {

    private final LocalDate currentDate = LocalDate.now();
    private final JFrame mainFrame;
    private final JPanel mainPanel;
    private final JComboBox dayComboBox, monthComboBox, yearComboBox;
    private final JLabel dayLabel, monthLabel, yearLabel;
    private final JButton calculateAgeButton, exitButton;

    public AgeCalculator() {

        this.mainFrame = new JFrame("Calculate Age");
        mainFrame.setLayout(new FlowLayout());
        mainFrame.setPreferredSize(new Dimension(400, 110));
        mainFrame.getContentPane().setBackground(Color.getHSBColor(75, 83, 32));
        

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


        mainFrame.add(dayLabel);
        mainFrame.getContentPane().add(dayComboBox);
        mainFrame.add(monthLabel);
        mainFrame.getContentPane().add(monthComboBox);
        mainFrame.add(yearLabel);
        mainFrame.getContentPane().add(yearComboBox);
        mainFrame.getContentPane().add(mainPanel);

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

    /**
     * Creates and initializes a new "LocalDate object" called start"
     * 
     * @ChronotUnit.YEARS.between returns # of years between "start" and "currentDate"
     */
    private void calculateAge() {
        
        Integer day = (Integer)dayComboBox.getSelectedItem();
        Month month = (Month)monthComboBox.getSelectedItem();
        Integer year = (Integer)yearComboBox.getSelectedItem();

        LocalDate start = LocalDate.of(
        year, 
        month.getValue(),
        day);

        if ((start != null) && (currentDate != null)) {
            long years = ChronoUnit.YEARS.between(start, currentDate);

        JOptionPane.showMessageDialog(
                mainFrame,
                "You are " + years + " years"  + " old.",
                "Age",
                JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
