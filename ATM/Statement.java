package ATM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

//import org.bson.Document;
//
//import com.mongodb.client.MongoCursor;

public class Statement {
	public static void choose() {
		JFrame frame=new JFrame("Mini Statement");
        JPanel panel1=new JPanel();
        JPanel panel2=new JPanel();
        JPanel panel=new JPanel();
        
        JPanel employeeCard = new JPanel();

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        JLabel nameVal = new JLabel(Deposit.doc.getString("Name"));
        nameVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        JLabel phoneLabel = new JLabel("Account Number");
        phoneLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        JLabel phoneVal = new JLabel(Deposit.doc.getString("Account No"));
        phoneVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        JLabel emailLabel = new JLabel("Account Opening Time");
        emailLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        JLabel emailVal = new JLabel(Deposit.doc.getString("Account Opening Time"));
        emailVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        JLabel designationLabel = new JLabel("Current Balance");
        designationLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        JLabel designationVal = new JLabel(String.valueOf(Deposit.Balance));
        designationVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        employeeCard.add(nameLabel);
        employeeCard.add(nameVal);
        employeeCard.add(phoneLabel);
        employeeCard.add(phoneVal);
        employeeCard.add(emailLabel);
        employeeCard.add(emailVal);
        employeeCard.add(designationLabel);
        employeeCard.add(designationVal);

        employeeCard.setSize(800, 500);
        employeeCard.setBackground(new Color(166, 209, 230));
        employeeCard.setBorder(new EmptyBorder(20, 0, 20, 0));
        GridLayout cardLayout = new GridLayout(0, 2);
        cardLayout.setHgap(100);
        cardLayout.setVgap(10);
        employeeCard.setLayout(cardLayout);
        panel1.add(employeeCard);
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER));

        panel1.setBackground(new Color(166, 209, 230));
       
       
        JButton with=new JButton("Withrawl statement");
        with.setFont(new Font("Times New Roman",Font.PLAIN,20));
        with.addActionListener(actionListener->{
        	Statement.withrawl();
        	frame.dispose();
        });
        panel2.add(with);
        
        JButton dep=new JButton("Deposit Statement");
        dep.setFont(new Font("Times New Roman",Font.PLAIN,20));
        dep.addActionListener(actionListener->{
        	Statement.deposit();
        	frame.dispose();
        });
        panel2.add(dep);
        
        JButton all=new JButton("All Statement");
        all.setFont(new Font("Times New Roman",Font.PLAIN,20));
        all.addActionListener(actionListener->{
        	Statement.all();
        	frame.dispose();
        });
        panel2.add(all);
        GridLayout layout =new GridLayout(1,3); 
        layout.setHgap(40);
        panel2.setLayout(layout);
        panel2.setBorder(new EmptyBorder(90,30,30,30));
        
        JPanel panel3=new JPanel();
        JButton back=new JButton("Back");
        back.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        back.addActionListener(actionListener->{
        	frame.dispose();
        	MainPage.Menu();
        });
        
        panel3.add(back);
        panel3.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel3.setBorder(new EmptyBorder(30,0,50,0));
        
     
        
        panel.setLayout(new BorderLayout());
        panel.add(panel1,BorderLayout.NORTH);
        panel.add(panel2,BorderLayout.CENTER);
        panel.add(panel3,BorderLayout.SOUTH);
        
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800,500));
        frame.pack();
        frame.setVisible(true);
	}
	
//	static MongoCursor<Document> iterable=Sign_In.coll.find(Deposit.filters).iterator();
//	static Document doc =iterable.next();
	
	public static void withrawl() {
		JFrame frame=new JFrame("Statement");
		
        JPanel panel=new JPanel();
        JPanel toplabel=new JPanel();
        JPanel data = new JPanel();
        JPanel buttonPanel = new JPanel();
       
        JLabel withrawstat=new JLabel("Withrawl Statement");
        	withrawstat.setFont(new Font("Times New Roman",Font.PLAIN,30));
        	toplabel.add(withrawstat);
        	toplabel.setLayout(new FlowLayout(FlowLayout.CENTER));
        	toplabel.setBorder(new EmptyBorder(10, 0, 20, 0));
          
            JPanel with=new JPanel();
            with.setSize(250, 300);
            with.setBackground(new Color(166, 209, 230));
            with.setBorder(new EmptyBorder(0,50,0,0));
         
            GridLayout withLayout = new GridLayout(0, 1);
      
            withLayout.setVgap(10);
            with.setLayout(withLayout);
            
            Object withtime=Deposit.doc.get("Withrawl Time");
        	List<Object> timelist=(List<Object>) withtime;
            
        	for(int i=0; i<timelist.size();i++) {
        		Object element=timelist.get(i);
        		JLabel label=new JLabel(element.toString());
        		with.add(label);
        	}
        	data.add(with);
        	
        	JPanel time=new JPanel();
            time.setSize(250, 300);
            time.setBackground(new Color(166, 209, 230));
            time.setBorder(new EmptyBorder(0,100,0,0));
           
            GridLayout timeLayout = new GridLayout(0, 1);
     
            timeLayout.setVgap(10);
            time.setLayout(timeLayout);
            
            Object withamt=Deposit.doc.get("Withrawl Amount");
        	List<Object> withlist=(List<Object>) withamt;
            
        	for(int i=0; i<withlist.size();i++) {
        		Object element=withlist.get(i);
        		JLabel label=new JLabel(element.toString());
        		time.add(label);
        	}
        	data.add(time);

            data.setSize(600, 700);

            GridLayout cardLayout = new GridLayout(0, 2);
            data.setLayout(cardLayout);

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        backButton.setFocusPainted(false);
        backButton.addActionListener(actionListener -> {
            frame.dispose();
            Statement.choose();
        });
        buttonPanel.add(backButton);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBorder(new EmptyBorder(10,0,20,0));
        
        
        
        panel.setLayout(new BorderLayout());
        panel.add(toplabel,BorderLayout.NORTH);
        panel.add(data,BorderLayout.CENTER);
        panel.add(buttonPanel,BorderLayout.SOUTH);
        
            JScrollPane scrollBar=new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            frame.add(scrollBar);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setPreferredSize(new Dimension(600,700));
            frame.pack();
            frame.setVisible(true);
        }

	public static void deposit() {
		
JFrame frame=new JFrame("Statement");
		
        JPanel panel=new JPanel();
        JPanel toplabel=new JPanel();
        JPanel data = new JPanel();
        JPanel buttonPanel = new JPanel();
       
        JLabel withrawstat=new JLabel("Withrawl Statement");
        	withrawstat.setFont(new Font("Times New Roman",Font.PLAIN,30));
        	toplabel.add(withrawstat);
        	toplabel.setLayout(new FlowLayout(FlowLayout.CENTER));
        	toplabel.setBorder(new EmptyBorder(10, 0, 20, 0));
          
            JPanel with=new JPanel();
            with.setSize(250, 300);
            with.setBackground(new Color(166, 209, 230));
            with.setBorder(new EmptyBorder(0,50,0,0));
         
            GridLayout withLayout = new GridLayout(0, 1);
      
            withLayout.setVgap(10);
            with.setLayout(withLayout);
            
            Object withtime=Deposit.doc.get("Deposit Time");
        	List<Object> timelist=(List<Object>) withtime;
            
        	for(int i=0; i<timelist.size();i++) {
        		Object element=timelist.get(i);
        		JLabel label=new JLabel(element.toString());
        		with.add(label);
        	}
        	data.add(with);
        	
        	JPanel time=new JPanel();
            time.setSize(250, 300);
            time.setBackground(new Color(166, 209, 230));
            time.setBorder(new EmptyBorder(0,100,0,0));
           
            GridLayout timeLayout = new GridLayout(0, 1);
     
            timeLayout.setVgap(10);
            time.setLayout(timeLayout);
            
            Object withamt=Deposit.doc.get("Deposited Amount");
        	List<Object> withlist=(List<Object>) withamt;
            
        	for(int i=0; i<withlist.size();i++) {
        		Object element=withlist.get(i);
        		JLabel label=new JLabel(element.toString());
        		time.add(label);
        	}
        	data.add(time);

            data.setSize(600, 700);

            GridLayout cardLayout = new GridLayout(0, 2);
            data.setLayout(cardLayout);

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        backButton.setFocusPainted(false);
        backButton.addActionListener(actionListener -> {
            frame.dispose();
            Statement.choose();
        });
        buttonPanel.add(backButton);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBorder(new EmptyBorder(10,0,20,0));
        
        
        
        panel.setLayout(new BorderLayout());
        panel.add(toplabel,BorderLayout.NORTH);
        panel.add(data,BorderLayout.CENTER);
        panel.add(buttonPanel,BorderLayout.SOUTH);
        
            JScrollPane scrollBar=new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            frame.add(scrollBar);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setPreferredSize(new Dimension(600,700));
            frame.pack();
            frame.setVisible(true);
    
	}
	public static void all() {

		
		JFrame frame=new JFrame("Transfer Statement");
		 JPanel panel=new JPanel();
	        JPanel toplabel=new JPanel();
	        JPanel data = new JPanel();
	        JPanel buttonPanel = new JPanel();
	       
	        JLabel withrawstat=new JLabel("Transfer Statement");
	        	withrawstat.setFont(new Font("Times New Roman",Font.PLAIN,30));
	        	toplabel.add(withrawstat);
	        	toplabel.setLayout(new FlowLayout(FlowLayout.CENTER));
	        	toplabel.setBorder(new EmptyBorder(10, 0, 20, 0));
	          
	            JPanel with=new JPanel();
	            with.setSize(250, 300);
	            with.setBackground(new Color(166, 209, 230));
	            with.setBorder(new EmptyBorder(0,50,0,0));
	         
	            GridLayout withLayout = new GridLayout(0, 1);
	      
	            withLayout.setVgap(10);
	            with.setLayout(withLayout);
	            
	            Object transamt=Deposit.doc.get("Transfered Amount");
	        	List<Object> translist=(List<Object>) transamt;
	            
	        	for(int i=0; i<translist.size();i++) {
	        		Object element=translist.get(i);
	        		JLabel label=new JLabel(element.toString());
	        		with.add(label);
	        	}
	        	
	        	
	        	JPanel time=new JPanel();
	            time.setSize(250, 300);
	            time.setBackground(new Color(166, 209, 230));
	            time.setBorder(new EmptyBorder(0,100,0,0));
	           
	            GridLayout timeLayout = new GridLayout(0, 1);
	     
	            timeLayout.setVgap(10);
	            time.setLayout(timeLayout);
	            
	            Object transtime=Deposit.doc.get("Transfer Time");
	        	List<Object> timelist=(List<Object>)transtime;
	            
	        	for(int i=0; i<timelist.size();i++) {
	        		Object element=timelist.get(i);
	        		JLabel label=new JLabel(element.toString());
	        		time.add(label);
	        	}
	        	data.add(time);
	        	data.add(with);

	            data.setSize(600, 700);

	            GridLayout cardLayout = new GridLayout(0, 2);
	            data.setLayout(cardLayout);

	        JButton backButton = new JButton("Back");
	        backButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	        backButton.setFocusPainted(false);
	        backButton.addActionListener(actionListener -> {
	            frame.dispose();
	            Statement.choose();
	        });
	        buttonPanel.add(backButton);
	        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
	        buttonPanel.setBorder(new EmptyBorder(10,0,20,0));
	        
	        
	        
	        panel.setLayout(new BorderLayout());
	        panel.add(toplabel,BorderLayout.NORTH);
	        panel.add(data,BorderLayout.CENTER);
	        panel.add(buttonPanel,BorderLayout.SOUTH);
	        
	            JScrollPane scrollBar=new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	            frame.add(scrollBar);
	            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            frame.setPreferredSize(new Dimension(600,700));
	            frame.pack();
	            frame.setVisible(true);
        }
	
}