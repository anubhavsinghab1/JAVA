package JAVA;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

class FontFrame extends JFrame{
    private static final int FRAME_WIDTH=400;
    private static final int FRAME_HEIGHT=400;
    
    private JLabel label;
    private JCheckBox italicCheckbox;
    private JCheckBox boldChckbox;
    private JRadioButton smallButton;
    private JRadioButton mediumButton;
    private JRadioButton largeButton;
    private JComboBox facenameCombo;
    private ActionListener listener;
    public FontFrame(){
        label=new JLabel("Big Java");
        add(label, BorderLayout.CENTER);

        listener=new ChoiceListener();
        createControlPanel();
        setLabelFont();
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
    }
    class ChoiceListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            setLabelFont();
        }
    }
    public void createControlPanel(){
        JPanel facenamePanel =createComboBox();
        JPanel sizeGroupPanel=createCheckBoxes();
        JPanel styleGroupPanel=createRadioButtons();

        JPanel controlPanel=new JPanel();
        controlPanel.setLayout(new GridLayout(3,1));
        controlPanel.add(facenamePanel);
        controlPanel.add(sizeGroupPanel);
        controlPanel.add(styleGroupPanel);
        add(controlPanel,BorderLayout.SOUTH);

    }
    public JPanel createComboBox(){
        facenameCombo=new JComboBox();
        facenameCombo.addItem("Serif");
        facenameCombo.addItem("SansSerif");
        facenameCombo.addItem("Monospaced");
        facenameCombo.setEditable(true);
        facenameCombo.addActionListener(listener);
        JPanel panel =new JPanel();
        panel.add(facenameCombo);
        return panel;
    }
    public JPanel createCheckBoxes(){
        italicCheckbox=new JCheckBox("Italic");
        italicCheckbox.addActionListener(listener);
        boldChckbox=new JCheckBox("Bold");
        boldChckbox.addActionListener(listener);

        JPanel panel=new JPanel();
        panel.add(italicCheckbox);
        panel.add(boldChckbox);
        panel.setBorder(new TitledBorder(new EtchedBorder(),"Style"));

        return panel;
    }
    public JPanel createRadioButtons(){
        smallButton=new JRadioButton("Small");
        smallButton.addActionListener(listener);

        mediumButton=new JRadioButton("Medium");
        mediumButton.addActionListener(listener);

        largeButton =new JRadioButton("Large");
        largeButton.addActionListener(listener);
        largeButton.setSelected(true);

        ButtonGroup group=new ButtonGroup();
        group.add(smallButton);
        group.add(mediumButton);
        group.add(largeButton);

        JPanel panel=new JPanel();
        panel.add(smallButton);
        panel.add(mediumButton);
        panel.add(largeButton);
        panel.setBorder(new TitledBorder(new EtchedBorder(),"Size"));

        return panel;

    }
    public void setLabelFont(){
        String faceName=(String)facenameCombo.getSelectedItem();

        int style=0;
        if(italicCheckbox.isSelected()){

            style+=Font.ITALIC;
        }
        if(boldChckbox.isSelected()){
            style+=Font.BOLD;;
        }

        int size=0;
        final int SMALL_SIZE=24;
        final int MEDIUM_SIZE=36;
        final int LARGE_SIZE=48;
         if(smallButton.isSelected()){
            size=SMALL_SIZE;
         }
         else if(mediumButton.isSelected()){
            size=MEDIUM_SIZE;
         }
         else if(largeButton.isSelected()){
            size=LARGE_SIZE;
         }

        label.setFont(new Font(faceName,style,size));
        label.repaint();
    }
}
class FontViewer{
    public static void main(String[]args){
        JFrame frame=new FontFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Font Viewer");
        frame.setVisible(true);


    }
}