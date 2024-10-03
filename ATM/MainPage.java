package ATM;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import com.mongodb.MongoException;

public class MainPage {
	public static void Menu() {

			JFrame frame1=new JFrame();
		
			
			JLabel detail1=new JLabel("ATM");
		  	detail1.setFont(new Font("Times New Roman",Font.BOLD,30));
		  	
	        JPanel panel11=new JPanel();

	        panel11.setLayout(new FlowLayout(FlowLayout.CENTER));
	        panel11.setBorder(new EmptyBorder(20,0,40,0));
	        
	        panel11.add(detail1);
	        	        

	        JButton fastcash=new JButton("Fast Cash");
	        fastcash.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	        fastcash.addActionListener(actionListener->{
	        	FastCash.cash();
	        	frame1.dispose();
	        });
	        
	        JButton withrawl=new JButton("Withrawl");
	        withrawl.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	        withrawl.addActionListener(actionListener->{
	        	Withraw.withraw();
	        	frame1.dispose();
	        });
	        
	        JButton enquiry=new JButton("Balance Enquiry");
	        enquiry.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	        enquiry.addActionListener(actionListener->{
	        	try {
	    	        		BalanceEnquiry.enquiry();
	    		        	frame1.dispose();
	        	}
	        	
	        	
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	
	        });
	        
	        JButton changepin=new JButton("Change Pin");
	        changepin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	        changepin.addActionListener(actionListener->{
	        	frame1.dispose();
	        	ChangPin.change();
	        });
	        
	        JButton transfer=new JButton("Transfer");
	        transfer.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	        transfer.addActionListener(actionListener->{
	        	frame1.dispose();
	        	TransferAccount.withraw();
	        });
	        
	        JButton deposit=new JButton("Deposit");
	        deposit.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	        deposit.addActionListener(actionListener->{
	        	Deposit.deposit();
	        	frame1.dispose();
	        });
	        
	        JButton statement=new JButton("Mini Statement");
	        statement.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	        statement.addActionListener(actionListener->{	    
             	try {         		
            		frame1.dispose();
            		Statement.choose();
            	
             	}catch(MongoException e) {
            		e.printStackTrace();
            	}
            });
	        
	        JButton back=new JButton("Exit");
	        back.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	        back.addActionListener(actionListener->{
	        	System.exit(0);
	        });
	        
	        
	        JPanel panel12=new JPanel();
	        GridLayout cardLayout = new GridLayout(0, 2);
	        cardLayout.setVgap(30);
	        cardLayout.setHgap(100);
	        panel12.setLayout(cardLayout);
	        
	        panel12.add(fastcash);
	        panel12.add(deposit);
	        panel12.add(withrawl);
	        panel12.add(statement);
	        panel12.add(enquiry);
	        panel12.add(changepin);
	        panel12.add(transfer);
	        panel12.add(back);
	        
	        JPanel buttonPanel=new JPanel();
	        JButton backButton = new JButton("Delete Account");
	        backButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	        backButton.setFocusPainted(false);
	        backButton.addActionListener(actionListener -> {

	        	Sign_In.conn.deleteOne(Deposit.filter);
	        	Sign_In.coll.deleteOne(Deposit.filters);
	            frame1.dispose();
	            Sign_In.loginFrame.setVisible(true);
	        });
	        buttonPanel.add(backButton);
	        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
	        buttonPanel.setBorder(new EmptyBorder(40,0,30,0));
	        
	        
	        
	        JPanel panel1=new JPanel(new BorderLayout());
	        panel1.setBorder(new EmptyBorder(0,100,10,100));
	        
	        
	        panel1.add(panel11,BorderLayout.NORTH);
	        panel1.add(panel12,BorderLayout.CENTER);
	        panel1.add(buttonPanel,BorderLayout.SOUTH);
	        
	        
	        frame1.add(panel1);
	        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame1.setPreferredSize(new Dimension(800,500));
	        frame1.pack();
	        frame1.setVisible(true);

	}
}
