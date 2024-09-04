package JAVA;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class InvestmentFrame1 extends JFrame{
    private static final int FRAME_WIDTH=450;
    private static final int FRAME_HEIGHT=300;

    private static final double DEFAULT_RATE=5;
    private static final double INITIAL_BALANCE=1000;

    private JLabel rateLabel;
    private JTextField rateField;
    private JButton button;
    private JLabel resultLabel;
    private double balance;

    public InvestmentFrame1(){
        balance=INITIAL_BALANCE;

        resultLabel=new JLabel("Balance: "+balance);
        createTextField();
    }
    private void createTextField(){
        rateLabel=new JLabel("Interest Rate : ");
        final int FIELD_WIDTH=10;
        rateField =new JTextField(FRAME_WIDTH);
        rateField.setText(""+DEFAULT_RATE);
    }
    class AddInterestListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            double rate=Double.parseDouble(rateField.getText());
            double interest=balance*rate/100;
            balance+=interest;
            resultLabel.setText("Balance: "+balance);
        }
    }
    public void createButton(){
        button =new JButton("Add Interest");
        ActionListener listener=new AddInterestListener();
        button.addActionListener(listener);
    }
    private void createPanel()
    {
        JPanel panel=new JPanel();
        panel.add(rateLabel);
        panel.add(rateField);
        panel.add(button);
        panel.add(resultLabel);
        add(panel);
    }
}
    class Viewer{
    public static void main(String[] args) {
        JFrame i=new InvestmentFrame1();
        i.setTitle(null);
        i.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        i.setVisible(true);
    }
}


