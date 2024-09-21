package ToDo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

class List extends JPanel {

    Color lightColor = new Color(252, 221, 176);

    List() {

        GridLayout layout = new GridLayout(10,1);
        layout.setVgap(2); // Vertical gap

        this.setLayout(layout); // 10 tasks
        this.setPreferredSize(new Dimension(400, 100));
        this.setBackground(lightColor);
    }

    public void updateNumbers() {
        Component []listItems = this.getComponents();

        for (int i = 0; i < listItems.length; i++) {
            if (listItems[i] instanceof Task) {
                ((Task) listItems[i]).changeIndex(i + 1);
            }
        }

    }

    public void removeCompletedTasks() {

        for (Component c : getComponents()) {
            if (c instanceof Task) {
                if (((Task) c).getState()) {
                    remove(c); // remove the component
                    updateNumbers(); // update the indexing of all items
                }
            }
        }

    }
}
