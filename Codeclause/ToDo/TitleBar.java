package ToDo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

class TitleBar extends JPanel {

    Color lightColor = new Color(100, 221, 176);

    TitleBar() {
        this.setPreferredSize(new Dimension(400, 70)); // Size of the title bar
        this.setBackground(lightColor); // Color of the title bar
        JLabel titleText = new JLabel("To Do List"); // Text of the title bar
        titleText.setPreferredSize(new Dimension(400, 60)); // Size of the text
        titleText.setFont(new Font("sans-serif", Font.BOLD, 25)); // Font of the text
        titleText.setHorizontalAlignment(JLabel.CENTER); // Align the text to the center
        titleText.setVerticalAlignment(JLabel.CENTER);
        this.add(titleText); // Add the text to the title bar
    }
}
