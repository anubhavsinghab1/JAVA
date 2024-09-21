package ToDo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

class Footer extends JPanel {

    JButton addTask;
    JButton clear;

    Color green = new Color(100, 221, 176);
    Color lightColor = new Color(252, 221, 176);
    // Border emptyBorder = BorderFactory.createDashedBorder(green);

    Footer() {
        this.setPreferredSize(new Dimension(400, 40));
        this.setBackground(lightColor);

        addTask = new JButton("Add Task"); // add task button
        addTask.setFont(new Font("Sans", Font.BOLD, 20)); // set font
        addTask.setVerticalAlignment(JButton.BOTTOM); // align text to bottom
        addTask.setBackground(green); // set background color
        this.add(addTask); // add to footer

        this.add(Box.createHorizontalStrut(50)); // Space between buttons

        clear = new JButton("Clear finished tasks"); // clear button
        clear.setFont(new Font("Sans-serif", Font.BOLD, 20)); // set font
        clear.setVerticalAlignment(JButton.CENTER);
        clear.setBackground(green); // set background color
        this.add(clear); // add to footer
    }

    public JButton getNewTask() {
        return addTask;
    }

    public JButton getClear() {
        return clear;
    }
}
