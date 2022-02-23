import java.awt.*;
import javax.swing.*;

public class MyFrame {

    private static void renderGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("My Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(200, 150));

        //Creates new button element with text "Press Me"
        JButton button = new JButton("Press Me");

        //Creates new panel element to hold the button
        JPanel panel = new JPanel();
        panel.add(button);

        //Adds panel element to frame
        frame.getContentPane().add(panel);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        renderGUI();
    }
}
