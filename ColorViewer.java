package JAVA;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ColorViewer {
    public static void main(String[]args){
        JFrame frame=new ColorFrame();
        frame.setVisible(true);
    }
}
class ColorFrame extends JFrame{
    private static final int FRAME_WIDTH=450;
    private static final int FRAME_HEIGHT=300;

    private JPanel colorPanel;
    private JSlider redSlider;
    private JSlider greenSlider;
    private JSlider blueSlider;
    public ColorFrame()
    {
        colorPanel= new JPanel();
        add(colorPanel,BorderLayout.CENTER);
        createControlPanel();
        setSampleColor();
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
    }
    class ColorListener implements ChangeListener{
        public void stateChanged(ChangeEvent event){
            setSampleColor();
        }
    }
    public void createControlPanel(){
        ChangeListener listener=new ColorListener();

        redSlider=new JSlider(0,255,255);
        redSlider.addChangeListener(listener);

        greenSlider=new JSlider(0,255,175);
        greenSlider.addChangeListener(listener);

        blueSlider=new JSlider(0,255,175);
        blueSlider.addChangeListener(listener);

        JPanel controlPanel=new JPanel();
        controlPanel.setLayout(new GridLayout(3,2));

        controlPanel.add(new JLabel("Red"));
        controlPanel.add(redSlider);

        controlPanel.add(new JLabel("Green"));
        controlPanel.add(greenSlider);

        controlPanel.add(new JLabel("Blue"));
        controlPanel.add(blueSlider);

        add(controlPanel, BorderLayout.SOUTH);
    } 
    public void setSampleColor(){
        int red=redSlider.getValue();
        int green=greenSlider.getValue();
        int blue=blueSlider.getValue();

        colorPanel.setBackground(new Color(red,green,blue));
        colorPanel.repaint();
    }
}