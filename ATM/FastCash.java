package ATM;



import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Arrays;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.bson.Document;


public class FastCash {
	public static void cash() {

		JFrame frame1=new JFrame();
	
		
		JLabel detail1=new JLabel("Choose the Amount");
	  	detail1.setFont(new Font("Times New Roman",Font.BOLD,30));
	  	
        JPanel panel11=new JPanel();

        panel11.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel11.setBorder(new EmptyBorder(20,0,50,0));
        
        panel11.add(detail1);
        	        

        JButton oneh=new JButton("100");
        oneh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        oneh.addActionListener(actionListener->{
        	int amount=Integer.parseInt(oneh.getText());
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
        		JOptionPane.showMessageDialog(frame1, "you had withraw Rs. "+amount, "Balance Withrawl", -1);
        
          	}else 
          	{
        		JOptionPane.showMessageDialog(frame1, "In Sufficient Amount", "Balance insufficient", 0);
        		frame1.dispose();
        		
        	}
        	frame1.dispose();
        	MainPage.Menu();
        });
        
        JButton twoh=new JButton("200");
        twoh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        twoh.addActionListener(actionListener->{
        	int amount=Integer.parseInt(twoh.getText());
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
        		JOptionPane.showMessageDialog(frame1, "you had withraw Rs. "+amount, "Balance Withrawl", -1);
        
          	}else 
          	{
        		JOptionPane.showMessageDialog(frame1, "In Sufficient Amount", "Balance insufficient", 0);
        		frame1.dispose();
        		
        	}
        	frame1.dispose();
        	MainPage.Menu();
        });
        
        JButton fiveh=new JButton("500");
        fiveh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        fiveh.addActionListener(actionListener->{
        	int amount=Integer.parseInt(fiveh.getText());
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
        		JOptionPane.showMessageDialog(frame1, "you had withraw Rs. "+amount, "Balance Withrawl", -1);
        
          	}else 
          	{
        		JOptionPane.showMessageDialog(frame1, "In Sufficient Amount", "Balance insufficient", 0);
        		frame1.dispose();
        		
        	}
        	frame1.dispose();
        	MainPage.Menu();
        });
        
        
        JButton onet=new JButton("1000");
        onet.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        onet.addActionListener(actionListener->{
        	int amount=Integer.parseInt(onet.getText());
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
        		JOptionPane.showMessageDialog(frame1, "you had withraw Rs. "+amount, "Balance Withrawl", -1);
        
          	}else 
          	{
        		JOptionPane.showMessageDialog(frame1, "In Sufficient Amount", "Balance insufficient", 0);
        		frame1.dispose();
        		
        	}
        	frame1.dispose();
        	MainPage.Menu();
        });
        
        JButton twot=new JButton("2000");
        twot.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        twot.addActionListener(actionListener->{
        	int amount=Integer.parseInt(twot.getText());
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
        		JOptionPane.showMessageDialog(frame1, "you had withraw Rs. "+amount, "Balance Withrawl", -1);
        
          	}else 
          	{
        		JOptionPane.showMessageDialog(frame1, "In Sufficient Amount", "Balance insufficient", 0);
        		frame1.dispose();
        		
        	}
        	frame1.dispose();
        	MainPage.Menu();
        });
        
        JButton fivet=new JButton("5000");
        fivet.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        fivet.addActionListener(actionListener->{
        	int amount=Integer.parseInt(fivet.getText());
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
        		JOptionPane.showMessageDialog(frame1, "you had withraw Rs. "+amount, "Balance Withrawl", -1);
        
          	}else 
          	{
        		JOptionPane.showMessageDialog(frame1, "In Sufficient Amount", "Balance insufficient", 0);
        		frame1.dispose();
        		
        	}
        	frame1.dispose();
        	MainPage.Menu();
        });
        
        
        JButton tent=new JButton("10000");
        tent.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        tent.addActionListener(actionListener->{
        	int amount=Integer.parseInt(tent.getText());
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
        		JOptionPane.showMessageDialog(frame1, "you had withraw Rs. "+amount, "Balance Withrawl", -1);
        
          	}else 
          	{
        		JOptionPane.showMessageDialog(frame1, "In Sufficient Amount", "Balance insufficient", 0);
        		frame1.dispose();
        		
        	}
        	frame1.dispose();
        	MainPage.Menu();
        });
        
        JButton fifty=new JButton("50000");
        fifty.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        fifty.addActionListener(actionListener->{
        	int amount=Integer.parseInt(fifty.getText());
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
        		JOptionPane.showMessageDialog(frame1, "you had withraw Rs. "+amount, "Balance Withrawl", -1);
        
          	}else 
          	{
        		JOptionPane.showMessageDialog(frame1, "In Sufficient Amount", "Balance insufficient", 0);
        		frame1.dispose();
        		
        	}
        	frame1.dispose();
        	MainPage.Menu();
        });
        
        JPanel panel12=new JPanel();
        GridLayout cardLayout = new GridLayout(0, 2);
        cardLayout.setVgap(25);
        cardLayout.setHgap(50);
        panel12.setLayout(cardLayout);
        
        panel12.add(oneh);
        
        panel12.add(twoh);
       
        panel12.add(fiveh);
        panel12.add(onet);
        panel12.add(twot);
        panel12.add(fivet);
        panel12.add(tent);
        panel12.add(fifty);
        
        JPanel panel13=new JPanel();

        JButton back=new JButton("Back");
	  	back.setFont(new Font("Times New Roman",Font.BOLD,20));
        panel13.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel13.setBorder(new EmptyBorder(30,0,30,0));
        
        panel13.add(back);
        
        back.addActionListener(actionListener->{
        	frame1.dispose();
        	MainPage.Menu();
        });
        
        JPanel panel1=new JPanel(new BorderLayout());
        panel1.setBorder(new EmptyBorder(10,100,10,100));
        
        
        panel1.add(panel11,BorderLayout.NORTH);
        panel1.add(panel12,BorderLayout.CENTER);
        panel1.add(panel13,BorderLayout.SOUTH);
        
        
        frame1.add(panel1);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setPreferredSize(new Dimension(800,500));
        frame1.pack();
        frame1.setVisible(true);

}
}
