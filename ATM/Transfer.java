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
import org.bson.conversions.Bson;

import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;

class TransferAccount {
		
		public static void withraw() {	

	        JFrame with = new JFrame("Transfer");
	        
	        JLabel accountLabel = new JLabel("Enter account to Tranfer:");
	        accountLabel.setBounds(130,150,220,30);
	        accountLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	        with.add(accountLabel);

	        Main.transaccount = new JTextField();
	        Main.transaccount.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	        Main.transaccount.setBounds(375,150,220,30);
	        with.add(Main.transaccount);
	        
	        JButton backBtn=new JButton("Back");
	        backBtn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	        backBtn.setBounds(200,300, 150, 40); 
	       
	        backBtn.addActionListener(actionListener->{	    
	             	try {         		
	            		with.dispose();
	            		MainPage.Menu();
	            	
	             	}catch(MongoException e) {
	            		e.printStackTrace();
	            	}
	            });

	        
	        JButton regBtn=new JButton("Next");
	        regBtn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	        regBtn.setBounds(400,300, 150, 40); 
	       
	        regBtn.addActionListener(actionListener->{	    
	             	try {         		
	            		with.dispose();
	            		Transfer.transfer();
	            	
	             	}catch(MongoException e) {
	            		e.printStackTrace();
	            	}
	            });

	        with.add(backBtn);
	        with.add(regBtn);
	        with.setSize(800,500);
	        with.setLayout(null);
	        with.setVisible(true);
	        with.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		}
}
public class Transfer{
	static String accno=Main.transaccount.getText();
	static Bson filter=Filters.eq("Account No",accno);
	
	static FindIterable<Document> iterables=Sign_In.coll.find(filter);
    static Document doc=iterables.first();

	public static void transfer() {

	JFrame with = new JFrame("Withraw");
        
	  JLabel transamount = new JLabel("Enter amount to Tranfer:");
        transamount.setBounds(130,150,220,30);
        transamount.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        with.add(transamount);

        JTextField transamountval = new JTextField();
        transamountval.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        transamountval.setBounds(375,150,220,30);
        with.add(transamountval);
        
        JButton regBtn=new JButton("Transfer");
        regBtn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        regBtn.setBounds(300,250, 150, 40); 
       
        regBtn.addActionListener(actionListener->{	    
         	try {
         		if(doc==null) {
         			JOptionPane.showMessageDialog(with, "Acount is invalid ! Not present");
         		}else {
         		double Balance=(double)(doc.getDouble("Balance"));
         		double amount=Double.parseDouble(transamountval.getText());
         		
         		
         		Balance=Balance+amount;
         		
         		Document filt=new Document("Account No",accno);
        		Document updates=new Document("$push",new Document("Deposited Amount",new Document("$each",Arrays.asList(amount))));
        		Document updates1=new Document("$push",new Document("Deposit Time",new Document("$each",Arrays.asList(new Date().toString()))));
        		Document updates2=new Document("$push",new Document("Transfered Amount",new Document("$each",Arrays.asList(amount))));
        		Document updates3=new Document("$push",new Document("Transfer Time",new Document("$each",Arrays.asList(new Date().toString()+"Deposited"))));
        		Sign_In.coll.updateOne(new Document("Account No",accno),new Document("$set",new Document("Balance",Balance)));
        		Sign_In.coll.updateOne(filt, updates);
        		Sign_In.coll.updateOne(filt, updates1);
        		Sign_In.coll.updateOne(filt, updates2);
        		Sign_In.coll.updateOne(filt, updates3);
        		
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
        		
         		}
        		
        		with.dispose();
        		TransferAccount.withraw();
        	
         	}catch(MongoException e) {
        		e.printStackTrace();
        	}
        });
        

    with.add(regBtn);
    with.setSize(800,500);
    with.setLayout(null);
    with.setVisible(true);
    with.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}
}

