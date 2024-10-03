package ATM;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mongodb.MongoException;

public class BalanceEnquiry {
	public static void enquiry() throws MongoException{
	
		JFrame frame=new JFrame("Employee Records");
        JPanel panel1=new JPanel();
        JPanel panel2=new JPanel();
        JPanel panel=new JPanel();
        
        JLabel idVal = new JLabel("Rs."+String.valueOf(Deposit.Balance));
        idVal.setFont(new Font("Times New Roman", Font.PLAIN, 50));
        panel1.add(idVal);
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel1.setBorder(new EmptyBorder(100,0,0,0));
       
       
        JButton back=new JButton("Back");
        back.setFont(new Font("Times New Roman",Font.PLAIN,30));
        back.addActionListener(actionListener->{
        	MainPage.Menu();
        	frame.dispose();
        });
        panel2.add(back);
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel2.setBorder(new EmptyBorder(0,0,100,0));

       
        
     
        
        panel.setLayout(new BorderLayout());
        panel.add(panel1,BorderLayout.CENTER);
        panel.add(panel2,BorderLayout.SOUTH);
        
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800,500));
        frame.pack();
        frame.setVisible(true);
        
	}
}
