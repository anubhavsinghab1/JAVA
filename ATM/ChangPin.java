package ATM;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JTextField;
import javax.swing.WindowConstants;

import org.bson.Document;

public class ChangPin {
	public static void change() {
	    JFrame with = new JFrame("Change Pin");

        JLabel usernameLabel = new JLabel("Enter New Pin:");
        usernameLabel.setBounds(130,150,220,30);
        usernameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        with.add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        usernameField.setBounds(375,150,220,30);
        with.add(usernameField);
            
	    JButton regBtn=new JButton("Change");
        regBtn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        regBtn.setBounds(300,250, 150, 40); 
        
        
        regBtn.addActionListener(actionListener->{
        	String amount=usernameField.getText();
        	Sign_In.conn.updateOne(new Document("Card No",Deposit.accountno),new Document("$set",new Document("Atm Pin",amount)));
        	with.dispose();
        	MainPage.Menu();
        });

        with.add(regBtn);
        with.setSize(800,500);
        with.setLayout(null);
        with.setVisible(true);
        with.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	}
}
