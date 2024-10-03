package ATM;

import java.awt.Font;
import java.util.Arrays;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import org.bson.Document;

public class Withraw {
	public static void withraw() {
		

        JFrame with = new JFrame("Withraw");

        JLabel usernameLabel = new JLabel("Enter amount to Withraw :");
        usernameLabel.setBounds(130,150,220,30);
        usernameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        with.add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        usernameField.setBounds(375,150,220,30);
        with.add(usernameField);
        
        
	
        JButton regBtn=new JButton("Withraw");
        regBtn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        regBtn.setBounds(300,250, 150, 40); 
       
        regBtn.addActionListener(actionListener->{
        	double amount=Double.parseDouble(usernameField.getText());
        	if(amount!=0) {
        	if(Deposit.Balance>=amount) {
        		Deposit.Balance=Deposit.Balance-amount;
        		
        		Document filter=new Document("Account No",Deposit.accountno);
        		Document update=new Document("$push",new Document("Withrawl Amount",new Document("$each",Arrays.asList(amount))));
        		Document update1=new Document("$push",new Document("Withrawl Time",new Document("$each",Arrays.asList(new Date().toString()))));
        		Document update2=new Document("$push",new Document("Transfered Amount",new Document("$each",Arrays.asList(amount))));
        		Document update3=new Document("$push",new Document("Transfer Time",new Document("$each",Arrays.asList(new Date().toString()+"withrawl"))));
        		Sign_In.coll.updateOne(new Document("Account No",Deposit.accountno),new Document("$set",new Document("Balance",Deposit.Balance)));
        		Sign_In.coll.updateOne(filter, update);
        		Sign_In.coll.updateOne(filter, update1);
        		Sign_In.coll.updateOne(filter, update2);
        		Sign_In.coll.updateOne(filter, update3);
        
          	}else 
          	{
        		JOptionPane.showMessageDialog(with, "In Sufficient Amount", "Balance insufficient", 0);
        		with.dispose();
        		
        	}
        	}
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
