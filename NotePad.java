package JAVA;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class NotePad {
    public static void main(String[] args) {
        JFrame frame=new NoteFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Notepad");
        frame.setVisible(true);
    }
}
class NoteFrame extends JFrame{
    private static final int FRAME_WIDTH=300;
    private static final int FRAME_HEIGHT=300;


    public NoteFrame(){
        
        JMenuBar menuBar=new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(createFileMenu());

        setSize(FRAME_WIDTH,FRAME_HEIGHT);
    }
    public JMenu createFileMenu(){
        JMenu menu=new JMenu("File");
        JMenuItem menuItem=new JMenuItem("File");
        menu.add(menuItem);
        return menu;
    }
}