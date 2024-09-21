package ToDo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Task extends JPanel {

    JLabel index;
    JTextField taskName;
    JButton done;

    Color pink = new Color(255, 161, 161);
    Color green = new Color(188, 226, 158);
    Color doneColor = new Color(233, 119, 119);

    private boolean checked;

    Task() {
        this.setPreferredSize(new Dimension(400, 20)); // set size of task
        this.setBackground(pink); // set background color of task

        this.setLayout(new BorderLayout()); // set layout of task

        checked = false;

        index = new JLabel(""); // create index label
        index.setPreferredSize(new Dimension(20, 20)); // set size of index label
        index.setHorizontalAlignment(JLabel.CENTER); // set alignment of index label
        this.add(index, BorderLayout.WEST); // add index label to task

        taskName = new JTextField("Write something.."); // create task name text field
        taskName.setBorder(BorderFactory.createEmptyBorder()); // remove border of text field
        taskName.setBackground(pink); // set background color of text field

        this.add(taskName, BorderLayout.CENTER);

        done = new JButton("Done");
        done.setPreferredSize(new Dimension(80, 20));
        done.setBorder(BorderFactory.createEmptyBorder());
        done.setBackground(doneColor);
        done.setFocusPainted(false);

        this.add(done, BorderLayout.EAST);

    }

    public void changeIndex(int num) {
        this.index.setText(num + ""); // num to String
        this.revalidate(); // refresh
    }

    public JButton getDone() {
        return done;
    }

    public boolean getState() {
        return checked;
    }

    public void changeState() {
        this.setBackground(green);
        taskName.setBackground(green);
        checked = true;
        revalidate();
    }
}