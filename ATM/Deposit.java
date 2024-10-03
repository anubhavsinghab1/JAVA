package ATM;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

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
import org.bson.conversions.Bson;

import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;

public class Deposit {
	

	static String accountno=Main.cardnoField.getText();
	static Bson filters =Filters.eq("Account No",accountno);
	static Bson filter=and(eq("Card No",accountno));

	
	static FindIterable<Document> iterable=Sign_In.coll.find(filters);
    static Document doc=iterable.first();

	static double Balance=(double)(doc.getDouble("Balance"));
	
	
	
	public static void deposit() {
		
		
		JFrame dep = new JFrame("Deposit");

        JLabel usernameLabel = new JLabel("Enter amount to deposit :");
        usernameLabel.setBounds(130,150,220,30);
        usernameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        
        dep.add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        usernameField.setBounds(375,150,220,30);;
        dep.add(usernameField);
        
        
	
        JButton regBtn=new JButton("Deposit");
        regBtn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        regBtn.setBounds(300,250, 150, 40); 

        regBtn.addActionListener(actionListener->{
        	try {
        	double amount=Double.parseDouble(usernameField.getText());
        	if(amount<=(Math.pow(10,15)-1)) {
        	if(amount!=0) {
        		Balance=Balance+amount;
        		Document filter=new Document("Account No",accountno);
        		Document update=new Document("$push",new Document("Deposited Amount",new Document("$each",Arrays.asList(amount))));
        		Document update1=new Document("$push",new Document("Deposit Time",new Document("$each",Arrays.asList(new Date().toString()))));
        		Document update2=new Document("$push",new Document("Transfered Amount",new Document("$each",Arrays.asList(amount))));
        		Document update3=new Document("$push",new Document("Transfer Time",new Document("$each",Arrays.asList(new Date().toString()+"Deposited"))));
        		Sign_In.coll.updateOne(new Document("Account No",accountno),new Document("$set",new Document("Balance",Balance)));
        		Sign_In.coll.updateOne(filter, update);
        		Sign_In.coll.updateOne(filter, update1);
        		Sign_In.coll.updateOne(filter, update2);
        		Sign_In.coll.updateOne(filter, update3);
        	}
        	}else {
        		JOptionPane.showMessageDialog(dep, "Invalid amount");
        	}
        	dep.dispose();
        	MainPage.Menu();
        	
        	}catch(MongoException e) {
        		e.printStackTrace();
        	}
        });

        dep.add(regBtn);
        dep.setSize(800,500);
        dep.setLayout(null);
        dep.setVisible(true);
        dep.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
}
