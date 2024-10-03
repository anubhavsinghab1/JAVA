 package ATM;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.bson.Document;
import org.bson.conversions.Bson;


import com.mongodb.MongoException;
import com.mongodb.client.MongoCursor;


public class Registration {

	static JTextField adharVal;
	public static void register() throws MongoException  {
	
		  
		  JFrame frame1=new JFrame();
		  JFrame frame2=new JFrame();
		  JFrame frame3=new JFrame();
		  	JLabel detail1=new JLabel("Page no 1 : Personal Details");
		  	detail1.setFont(new Font("Times New Roman",Font.BOLD,30));
		  	
	        JPanel panel11=new JPanel();

	        panel11.setLayout(new FlowLayout(FlowLayout.CENTER));
	        
	        panel11.add(detail1);
	        	        

	        JLabel name = new JLabel("Name*");
	        name.setFont(new Font("Times New Roman", Font.PLAIN, 20));

	        JTextField nameval = new JTextField("");
	        nameval.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	        nameval.addKeyListener(new KeyAdapter() {
	            public void keyTyped(KeyEvent e) {
	                char c = e.getKeyChar();
	                if ((Character.isDigit(c))) {
	                    e.consume();  // if it's not a number, ignore the event
	                }
	            }
	        });

	        JLabel fname = new JLabel("Father Name");
	        fname.setFont(new Font("Times New Roman", Font.PLAIN, 20));

	        JTextField fnameVal = new JTextField("");
	        fnameVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

	        JLabel dob=new JLabel("Date Of Birth");
	        dob.setFont(new Font("Times New Roman",Font.PLAIN,20));
	        
	 
	        JTextField dobVal=new JTextField();
	        dobVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

	        JLabel genderLabel = new JLabel("Gender*");
	        genderLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	        
	        
	        JRadioButton maleVal =new JRadioButton("Male");
	        maleVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	        JRadioButton femaleVal =new JRadioButton("Female");
	        femaleVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	        JRadioButton otherVal =new JRadioButton("Other");
	        otherVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	        
	        ButtonGroup group=new ButtonGroup();
	        group.add(maleVal);
	        group.add(femaleVal);
	        group.add(otherVal);
	        
	        JPanel genderVal=new JPanel();
	        genderVal.setLayout(new GridLayout(1,3));
	        genderVal.add(maleVal);
	        genderVal.add(femaleVal);
	        genderVal.add(otherVal);

	        JLabel emailLabel = new JLabel("Email*");
	        emailLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

	        JTextField emailVal = new JTextField("");
	        emailVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	        emailVal.addKeyListener(new KeyAdapter() {
	            public void keyTyped(KeyEvent e) {
	            	
	                 char c = e.getKeyChar();
	                if(Character.isUpperCase(c)) {
	                	e.setKeyChar(Character.toLowerCase(c));
	                }
	                
	                if ( (c == KeyEvent.VK_SPACE)) {
	                    e.consume();  // if it's not a number, ignore the event
	                }
	            }
	        });
	        
	        JLabel martsta=new JLabel("Martial Status*");
	        martsta.setFont(new Font("Times New Roman",Font.PLAIN,20));
	        
	        JRadioButton marriedVal =new JRadioButton("Married");
	        marriedVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	        JRadioButton unmarriedVal =new JRadioButton("Unmarried");
	        unmarriedVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	        JRadioButton othermVal =new JRadioButton("Other");
	        othermVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	        
	        ButtonGroup group1=new ButtonGroup();
	        group1.add(marriedVal);
	        group1.add(unmarriedVal);
	        group1.add(othermVal);
	        
	        JPanel martVal=new JPanel();
	        martVal.setLayout(new GridLayout(1,3));
	        martVal.add(marriedVal);
	        martVal.add(unmarriedVal);
	        martVal.add(othermVal);
	        
	       
	        
	        JLabel add=new JLabel("Address");
	        add.setFont(new Font("Times New Roman",Font.PLAIN,20));
	        
	        JTextField  addVal =new JTextField();
	        addVal.setFont(new Font("Times New Roman",Font.PLAIN,20));
	        

	        JLabel cityLabel = new JLabel("City*");
	        cityLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

	        JTextField cityVal = new JTextField("");
	        cityVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	        
	        cityVal.addKeyListener(new KeyAdapter() {
	            public void keyTyped(KeyEvent e) {
	                char c = e.getKeyChar();
	                if ((Character.isDigit(c))) {
	                    e.consume();  // if it's not a number, ignore the event
	                }
	            }
	        });

	        
	        JLabel pin = new JLabel("PinCode*");
	        pin.setFont(new Font("Times New Roman", Font.PLAIN, 20));

	        JTextField pinVal = new JTextField("");
	        pinVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	        
	        pinVal.addKeyListener(new KeyAdapter() {
	            public void keyTyped(KeyEvent e) {
	            	if(pinVal.getText().length()>=6) {
	            		e.consume();
	            		JOptionPane.showMessageDialog(frame1, "The Length of pin can be of 6 digits", "Pincode",2);
	            	}
	                char c = e.getKeyChar();
	                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {           	
	                    e.consume();  // if it's not a number, ignore the event
	                }
	            }
	            });
	        
	        JLabel stateLabel = new JLabel("State*");
	        stateLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

	        JTextField stateVal = new JTextField("");
	        stateVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	        
	        stateVal.addKeyListener(new KeyAdapter() {
	            public void keyTyped(KeyEvent e) {
	                char c = e.getKeyChar();
	                if ((Character.isDigit(c))) {
	                    e.consume();  // if it's not a number, ignore the event
	                }
	            }
	        });

	        
	        JPanel panel12=new JPanel();
	        GridLayout cardLayout = new GridLayout(0, 2);
	        cardLayout.setVgap(25);
	        panel12.setLayout(cardLayout);

	        panel12.add(name);
	        panel12.add(nameval);
	        panel12.add(fname);
	        panel12.add(fnameVal);
	        panel12.add(dob);
	        panel12.add(dobVal);
	        panel12.add(genderLabel);
	        panel12.add(genderVal);
	        panel12.add(emailLabel);
	        panel12.add(emailVal);
	        panel12.add(martsta);
	        panel12.add(martVal);
	        panel12.add(add);
	        panel12.add(addVal);
	        panel12.add(cityLabel);
	        panel12.add(cityVal);
	        panel12.add(pin);
	        panel12.add(pinVal);
	        panel12.add(stateLabel);
	        panel12.add(stateVal);

	        JButton back1=new JButton("Back");
	        back1.setFont(new Font("Times New Roman",Font.PLAIN,20));
	        
	        JButton nextBtn1 = new JButton("Next");
	        nextBtn1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	        
	        back1.addActionListener(actionEvent ->{
	        	frame1.dispose();
	        	Sign_In.loginFrame.setVisible(true);
	        	
	        });
	        
	        
	        
	        nextBtn1.addActionListener(actionListener->{
	        	
	        	String gendervalue="";
        		if(maleVal.isSelected()) {gendervalue="Male";}
        		else if(femaleVal.isSelected()) {gendervalue="Female";}
        		else if(otherVal.isSelected()) {gendervalue="Other";}
        		
        		String maritialvalue="";
        		if(marriedVal.isSelected()) {maritialvalue="Married";}
        		else if(unmarriedVal.isSelected()) {maritialvalue="Unmarried";}
        		else if(othermVal.isSelected()) {maritialvalue="Other";}
        		
        		String mail=emailVal.getText();
	        	Bson fi =and(eq("Email",mail));
	        	MongoCursor<Document> cursor =Sign_In.conn.find(fi).iterator();
	        	
	        	if(nameval.getText().length()==0) {
	        		JOptionPane.showMessageDialog(frame1, "Name is required", "Name",2);
	        	}
	        	else if(nameval.getText().length()<4){
	        		JOptionPane.showMessageDialog(frame1, "Name has atleast 4 letters", "Name",2);
	        	}
	        	else  if(gendervalue.length()==0) {
	        		JOptionPane.showMessageDialog(frame1, "Select the gender", "Gender",2);
	        	}
	        	else if(mail.length()==0) {
	        		JOptionPane.showMessageDialog(frame1, "The email is required", "Email",2);
	        	}else if(mail.endsWith("@")) {
	        		JOptionPane.showMessageDialog(frame1, "after @ some charcter should be", "Email",2);
	        	}else if(!mail.contains("@")) {
	        		JOptionPane.showMessageDialog(frame1, "The email should contain @", "Email",2);
	   			}else if(mail.length()<10){
	        		JOptionPane.showMessageDialog(frame1, "Email has atleast 10 characters", "Name",2);
	        	}
	        	else if(cursor.hasNext()) {
	   				JOptionPane.showMessageDialog(frame1, "The email is used before", "Email used",2);	
	   			}else if(maritialvalue.length()==0){
	   				JOptionPane.showMessageDialog(frame1, "Select The maritial status", "Maritial Status",2);	
	   			}else if(cityVal.getText().length()==0) {
	   				JOptionPane.showMessageDialog(frame1, "City is required", "City",2);	
	   			}else if(pinVal.getText().length()==0) {
	   				JOptionPane.showMessageDialog(frame1, "Pin code is required", "Pincode",2);	
	   			}else if(stateVal.getText().length()==0) {
	   				JOptionPane.showMessageDialog(frame1, "State is required", "State",2);	
	   			}else{
	   				frame1.dispose();
		        	frame2.setVisible(true);
	         	} 
	        	
	        	
	        });
	        JPanel panel13=new JPanel();
	       FlowLayout flowlayout1=new FlowLayout();
	       flowlayout1.setHgap(100);
	        panel13.setLayout(flowlayout1);
	       panel13.add(back1);
	        panel13.add(nextBtn1);
	        
	        JPanel panel1=new JPanel();	        


	        BorderLayout borderlayout1=new BorderLayout();
	        borderlayout1.setVgap(20);
	        panel1.setLayout(borderlayout1);
	        
	        panel1.add(panel11,BorderLayout.NORTH);
	        panel1.add(panel12,BorderLayout.CENTER);
	        panel1.add(panel13,BorderLayout.SOUTH);
	        panel1.setBorder(new EmptyBorder(10,50,50,50));
	     
	        
	        
	        frame1.add(panel1);
	        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame1.setPreferredSize(new Dimension(800,750));
	        frame1.pack();
	        frame1.setVisible(true);
	        
	        
	        JLabel detail2=new JLabel("Page No 2: Additional Details");
	        detail2.setFont(new Font("Times New Roman",Font.BOLD,30));
	        
	        JPanel panel21=new JPanel();
	        panel21.setLayout(new FlowLayout());
	        panel21.add(detail2);
	        
	        JLabel rel=new JLabel("Religion");
	        rel.setFont(new Font("Times New Roman",Font.PLAIN,20));
	        
	        String religion[]= {"Select","Hindu","Muslim","Cristian","Sikh","Jainism","Buddhism","Other"};
	        JComboBox<String> relVal = new JComboBox<>(religion);
	        relVal.setFont(new Font("Times New Roman",Font.PLAIN,20));
	        
	        JLabel category=new JLabel("Category");
	        category.setFont(new Font("Times New Roman",Font.PLAIN,20));
	        
	        String cate[]= {"Select","GENERAL","OBC","SC","ST","OTHER"};
	        JComboBox<String> categoryVal =new JComboBox<>(cate);
	        categoryVal.setFont(new Font("Times New Roman",Font.PLAIN,20));
	        
	        JLabel income=new JLabel("Income");
	        income.setFont(new Font("Times New Roman",Font.PLAIN,20));
	        
	        String incomes[]= {"Select",
	        	"Less than 100000",
	        	"100000-500000"
	        	,"500000-2000000",
	        	"2000000-10000000",
	        	"More than 10000000"
	        };
	        JComboBox<String> incomeVal =new JComboBox<>(incomes);
	        incomeVal.setFont(new Font("Times New Roman",Font.PLAIN,20));
	        
	        JLabel qualify=new JLabel("Qualification");
	        qualify.setFont(new Font("Times New Roman",Font.PLAIN,20));
	        
	        String quali[]= {"Select",
	        	"High-School",
	        	"Intermediate",
	        	"Graduation",
	        	"Post-Graduation",
	        	"Non-qualified"
	        };
	        JComboBox<String> qualificationVal =new JComboBox<>(quali);
	        qualificationVal.setFont(new Font("Times New Roman",Font.PLAIN,20));
	        
	        JLabel occ=new JLabel("Occupation");
	        occ.setFont(new Font("Times New Roman",Font.PLAIN,20));
	        
	        String occupy[]= {"Select",
	        	"Private Job",
	        	"Government Job",
	        	"Business",
	        	"Self-Employeed",
	        	"Unemployed"
	        };
	        JComboBox<String> occupationVal =new JComboBox<>(occupy);
	        occupationVal.setFont(new Font("Times New Roman",Font.PLAIN,20));
	        
	        JLabel adhar=new JLabel("Adhar Number*");
	        adhar.setFont(new Font("Times New Roman",Font.PLAIN,20));
	        
	        adharVal=new JTextField();
	        adharVal.setFont(new Font("Times New Roman",Font.PLAIN,20));
	        
	        adharVal.addKeyListener(new KeyAdapter() {
	            public void keyTyped(KeyEvent e) {
	            	if(adharVal.getText().length()>=12) {
	            		e.consume();
	            		JOptionPane.showMessageDialog(frame2, "The Length of pin can be of 12 digits", "Aadhar No",2);
	            	}
	                char c = e.getKeyChar();

	                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
	                    e.consume();
	                }
	            }
	        });
	        
	        
	        JLabel pan=new JLabel("Pan Number");
	        pan.setFont(new Font("Times New Roman",Font.PLAIN,20));
	        
	        JTextField panVal=new JTextField("");
	        panVal.setFont(new Font("Times New Roman",Font.PLAIN,20));
	        
	        panVal.addKeyListener(new KeyAdapter() {
	            public void keyTyped(KeyEvent e) {
	            	if((panVal.getText().length()>=10)){
	            		e.consume();
	            		JOptionPane.showMessageDialog(frame2, "The Length of pin can be of 10 characters", "Pan Card No",2);
	            	}
	                char c = e.getKeyChar();
	                if(Character.isLowerCase(c)) {
	                	e.setKeyChar(Character.toUpperCase(c));
	                }
	                else if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
	                    e.consume();
	                }
	            }
	        });
	        
	        JLabel senior=new JLabel("Senior Citizen");
	        senior.setFont(new Font("Times New Roman",Font.PLAIN,20));
	        
	        JRadioButton seniyes=new JRadioButton("Yes");
	        seniyes.setFont(new Font("Times New Roman",Font.PLAIN,20));
	        
	        JRadioButton senino=new JRadioButton("No");
	        senino.setFont(new Font("Times New Roman",Font.PLAIN,20));
	        
	        ButtonGroup groupsenior=new ButtonGroup();
	        groupsenior.add(seniyes);
	        groupsenior.add(senino);
	        
	        JPanel seniorcitizen=new JPanel();
	        seniorcitizen.setLayout(new GridLayout(1,2));
	        seniorcitizen.add(seniyes);
	        seniorcitizen.add(senino);
	        
	        JLabel accexist=new JLabel("Existing Account");
	        accexist.setFont(new Font("Times New Roman",Font.PLAIN,20));
	        
	        JRadioButton existyes=new JRadioButton("Yes");
	        existyes.setFont(new Font("Times New Roman",Font.PLAIN,20));
	        JRadioButton existno=new JRadioButton("No");
	        existno.setFont(new Font("Times New Roman",Font.PLAIN,20));
	        
	        ButtonGroup groupexist=new ButtonGroup();
	        groupexist.add(existyes);
	        groupexist.add(existno);
	        
	        JPanel existaccout=new JPanel();
	        existaccout.setLayout(new GridLayout(1,2));
	        existaccout.add(existyes);
	        existaccout.add(existno);
	  
	        JPanel panel22=new JPanel();
	        GridLayout layout=new GridLayout(0,2);
	        layout.setVgap(30);
	        panel22.setLayout(layout);
	        panel22.add(rel);
	        panel22.add(relVal);
	        panel22.add(category);
	        panel22.add(categoryVal);
	        panel22.add(income);
	        panel22.add(incomeVal);
	        panel22.add(qualify);
	        panel22.add(qualificationVal);
	        panel22.add(occ);
	        panel22.add(occupationVal);
	        panel22.add(pan);
	        panel22.add(panVal);
	        panel22.add(adhar);
	        panel22.add(adharVal);
	        panel22.add(senior);
	        panel22.add(seniorcitizen);
	        panel22.add(accexist);
	        panel22.add(existaccout);
	        
	        JPanel panel23=new JPanel();
	        JButton nextBtn2 = new JButton("Next");
	        nextBtn2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	        
	        
	        JButton back2=new JButton("Back");
	        back2.setFont(new Font("Times New Roman",Font.PLAIN,20));
	       
	        back2.addActionListener(actionEvent->{
	        	frame2.dispose();
	        	frame1.setVisible(true);
	        });
	        
	        nextBtn2.addActionListener(actionnListener->{
	        	
	        	String panno=adharVal.getText();
        		Bson filters =and(eq("Pan Card No",panno));
	        	MongoCursor<Document> cursor =Sign_In.conn.find(filters).iterator();
	        	
	        	String adharno=adharVal.getText();
        		Bson filter =and(eq("Adhar No",adharno));
	        	MongoCursor<Document> curs =Sign_In.conn.find(filter).iterator();
	        	
	        	String exists="";
		        if(existyes.isSelected()) {exists="Yes";}
		        else if(existno.isSelected()) {exists="No";}
		        
		        String sencit="";
		        if(seniyes.isSelected()) {sencit="yes";}
		        else if(senino.isSelected()) {sencit="No";}
		        if(cursor.hasNext()) {
		        	JOptionPane.showMessageDialog(frame2, "Pan card is invalid used before", "Pan Invalid",2);
		        }
		        else if(adharno.length()==0) {
	        		JOptionPane.showMessageDialog(frame2, "Adhar is cumpolsury Enter Adhar no", "Adhar",2);
	        	}
	        	else if(adharno.length()!=12 ||  curs.hasNext()) {
	        		JOptionPane.showMessageDialog(frame2, "the Adhar no is invalid ", "Adhar Invalid",2);
	        	}else if(sencit.length()==0) {
		        	JOptionPane.showMessageDialog(frame2, "please select the seniority", "Senior Citizen",2);
		        }else { 
		        	if(exists.length()==0) {
		        		JOptionPane.showMessageDialog(frame2, "Select account existentence", "Account exist",2);
		        	}else {
				        if(!existyes.isSelected()) {
				        	frame2.dispose();
				        	frame3.setVisible(true);
				        }
				        else {
				        	frame2.dispose();
				        	Sign_In.loginFrame.setVisible(true);
				        	JOptionPane.showMessageDialog(Sign_In.loginFrame, "The second Account can't be opened", "Exist Account",0);		        	
				        }
		        	}
		        } 	
		       
	        });
	        FlowLayout flowlayout2=new FlowLayout();
	        flowlayout2.setHgap(100);
	        
	        panel23.setLayout(flowlayout2);
	        panel23.add(back2);
	        panel23.add(nextBtn2);
	        
	        JPanel panel2=new JPanel();
	        BorderLayout borderlayout2=new BorderLayout();
	        borderlayout2.setVgap(20);
	        panel2.setLayout(borderlayout2);
	        
	        panel2.add(panel21,BorderLayout.NORTH);
	        panel2.add(panel22,BorderLayout.CENTER);
	        panel2.add(panel23,BorderLayout.SOUTH);
	        
	        panel2.setBorder(new EmptyBorder(10,50,50,50));
	        
	        frame2.add(panel2);
	        frame2.setPreferredSize(new Dimension(800,750));
	        frame2.pack();
	        
	        
	        JLabel detail3=new JLabel("Page No 3: Account Details");
	        detail3.setFont(new Font("Times New Roman",Font.BOLD,30));
	        
	        JPanel panel31=new JPanel();
	        panel31.setLayout(new FlowLayout(FlowLayout.CENTER));
	        panel31.add(detail3);
	        
	        JRadioButton accsaving=new JRadioButton("Savings Account");
	        accsaving.setFont(new Font("Times New Roman",Font.PLAIN,20));
	        
	        JRadioButton accfixdeposit=new JRadioButton("Fixed Deposit Account");
	        accfixdeposit.setFont(new Font("Times New Roman",Font.PLAIN,20));
	        
	        JRadioButton acccurr=new JRadioButton("Current Account");
	        acccurr.setFont(new Font("Times New Roman",Font.PLAIN,20));
	        
	        JRadioButton accreccdeposit=new JRadioButton("Recurring Deposit Account");
	        accreccdeposit.setFont(new Font("Times New Roman",Font.PLAIN,20));
	        
	        ButtonGroup acctype=new ButtonGroup();
	        acctype.add(accsaving);
	        acctype.add(accfixdeposit);
	        acctype.add(acccurr);
	        acctype.add(accreccdeposit);

	        JLabel services=new JLabel("Services Required");
	        services.setFont(new Font("Times New Roman",Font.PLAIN,20));
	        
	        
	        JCheckBox card =new JCheckBox("Atm Card");
	        card.setFont(new Font("Times New Roman",Font.PLAIN,20));
	        
	        JCheckBox netbanking=new JCheckBox("Internet Banking");
	        netbanking.setFont(new Font("Times New Roman",Font.PLAIN,20));
	        
	        JCheckBox mobilebanking=new JCheckBox("Mobile Banking");
	        mobilebanking.setFont(new Font("Times New Roman",Font.PLAIN,20));
	        
	        
	        JCheckBox emailalerts=new JCheckBox("Email Alerts");
	        emailalerts.setFont(new Font("Times New Roman",Font.PLAIN,20));
	        
	        
	        JCheckBox chequebank=new JCheckBox("Cheque Bank");
	        chequebank.setFont(new Font("Times New Roman",Font.PLAIN,20));
	        
	        
	        JCheckBox estate=new JCheckBox("E-Statement");
	        estate.setFont(new Font("Times New Roman",Font.PLAIN,20));
	        
	        
	        JPanel panel32=new JPanel();
	        GridLayout gridlayout3=new GridLayout(0,2);
	        gridlayout3.setVgap(30);
	        panel32.setLayout(gridlayout3);
	        
	        panel32.add(accsaving);
	        panel32.add(accfixdeposit);
	        panel32.add(acccurr);
	        panel32.add(accreccdeposit);

	        panel32.add(services);
	        panel32.add(card);
	        panel32.add(netbanking);
	        panel32.add(mobilebanking);
	        panel32.add(emailalerts);
	        panel32.add(chequebank);
	        panel32.add(estate);
	        
	        JCheckBox declare=new JCheckBox("I Declare that if details provided by me found wrong cancel my application form");
	        declare.setFont(new Font("Times New Roman",Font.PLAIN,20));
	        JButton back3=new JButton("Back");
	        back3.setFont(new Font("Times New Roman",Font.PLAIN,20));
	        
	        
	        back3.addActionListener(actionEvent->{
	        	frame3.dispose();
	        	frame2.setVisible(true);
	        });
	        
	        JButton submit=new JButton("Submit");
	        submit.setFont(new Font("Times New Roman",Font.PLAIN,20));
	        
            
	        
	        submit.addActionListener(actionListener->{
	        		        
	        	String gendervalue="";
        		if(maleVal.isSelected()) {gendervalue="Male";}
        		else if(femaleVal.isSelected()) {gendervalue="Female";}
        		else if(otherVal.isSelected()) {gendervalue="Other";}
        		
        		String maritialvalue="";
        		if(marriedVal.isSelected()) {maritialvalue="Married";}
        		else if(unmarriedVal.isSelected()) {maritialvalue="Unmarried";}
        		else if(othermVal.isSelected()) {maritialvalue="Other";}
	        	
		        String accounttype="";
		        if(accsaving.isSelected()) {accounttype="Savings Account";}
		        else if(accfixdeposit.isSelected()) {accounttype="Fixed Deposit Account";}
	        	else if(acccurr.isSelected()) {accounttype="Current Account";}
	        	else if(accreccdeposit.isSelected()) {accounttype="Recurring Deposit Account";}

	            Boolean atm=false,NetBanking=false,MobileBanking=false,EmailAlert=false,ChequeBank=false,E_Statement=false;
	            if(mobilebanking.isSelected()) {
		        	MobileBanking=true;
		        }
	            if(card.isSelected()) {
	            	atm=true;
	            }
	            if(netbanking.isSelected()) {
	            	NetBanking=true;
	            }
	            if(chequebank.isSelected()) {
	            	ChequeBank=true;
	            }
	            if(emailalerts.isSelected()) {
	            	EmailAlert=true;
	            }
	            if(estate.isSelected()) {
	            	E_Statement=true;
	            }
	            String sencit="";
		        if(seniyes.isSelected()) {sencit="yes";}
		        else if(senino.isSelected()) {sencit="No";}
		        
	            String Name = nameval.getText();
	            String fName=fnameVal.getText();
	            String Dob = dobVal.getText();
	            String Email=emailVal.getText();
	            String Address=addVal.getText();
	            String City=cityVal.getText();
	            String Pincode=pinVal.getText();
	            String State=stateVal.getText();
	            
	            String Religion = (String) relVal.getSelectedItem();
	            String Category =(String)categoryVal.getSelectedItem();
	            String Income =(String)incomeVal.getSelectedItem();
	            String Qualification=(String)qualificationVal.getSelectedItem();
	            String Occupation=(String)occupationVal.getSelectedItem();
	            String Adhar=adharVal.getText();
	            String Pan=panVal.getText();
	            
	            	    		
	    		String cardno=(Adhar.substring(8,12)+Adhar.substring(4,8)+Adhar.substring(0, 4)+Adhar.substring(0, 2)+Adhar.substring(10));
	            String cardpin=Adhar.substring(2,3)+Adhar.substring(5,6)+Adhar.substring(8,9)+Adhar.substring(10, 11);
	            
	            Document service=new Document("Atm Card",atm)
	            		.append("Internet Banking", NetBanking)
	            		.append("Mobile Banking", MobileBanking)
	            		.append("Cheque Bank", ChequeBank)
	            		.append("E-Statement", E_Statement)
	            		.append("Email Alerts", EmailAlert);
	            
	            Document document =new Document("Name",Name)
	            		.append("Father Name", fName)
	            		.append("Date of Birth", Dob)
	            		.append("Gender", gendervalue)
	            		.append("Email",Email)  
	            		.append("Maritial Status", maritialvalue)
	            		.append("Address", Address)
	            		.append("City", City)
	            		.append("PinCode",Pincode)
	            		.append("State",State)
	            		.append("Religion", Religion)
	            		.append("Category",Category)
	            		.append("Qualification", Qualification)
	            		.append("Income", Income)
	            		.append("Occupation", Occupation)
	            		.append("Adhar No", Adhar)
	            		.append("Pan Card No", Pan)
	            		.append("Senior Citizen", sencit)
	            		.append("Account Type",accounttype)
	            		.append("Services", service)
	            		.append("Card No", cardno)
	            		.append("Atm Pin", cardpin);
	    		
	            	
	            if(accounttype.length()==0) {
		        	JOptionPane.showMessageDialog(frame3, "Please Choose the account typ", "Account",2);
		        }else {
	            if(declare.isSelected()) {
	            	try {
	            	Sign_In.conn.insertOne(document);
	            	Sign_In.coll.insertOne(new Document("Account No",cardno).append("Name",Name).append("Balance", 0.0).append("Account Opening Time", new Date().toString()));
	            	JOptionPane.showMessageDialog(frame3, "Card No="+cardno+"\nAtm Pin="+cardpin, "Atm Card",-1);
	            	frame3.dispose();
	            	Sign_In.loginFrame.setVisible(true);
//	            	Deposit.deposit();
	            	}catch(MongoException e) {
	            		e.printStackTrace();
	            	}
	        		
	            }else {
	            	JOptionPane.showMessageDialog(frame3, "Please check the declaration paragraph"+"", "Declaration",0);
	            }
	        		
		        }
	        });
	        JPanel panel33=new JPanel();
	        FlowLayout flowlayout3=new FlowLayout();
	        flowlayout3.setHgap(100);
	        flowlayout3.setVgap(10);
	        panel33.setLayout(flowlayout3);
	        panel33.setPreferredSize(new Dimension(800,100));
	        
	        panel33.add(declare);
	        panel33.add(back3);
	        panel33.add(submit);
	        
	        JPanel panel3=new JPanel();
	        BorderLayout borderlayout3=new BorderLayout();
	        borderlayout3.setVgap(20);
	        panel3.setLayout(borderlayout3);
	        panel3.add(panel31,BorderLayout.NORTH);
	        panel3.add(panel32,BorderLayout.CENTER);
	        panel3.add(panel33,BorderLayout.SOUTH);
	       
	        panel3.setBorder(new EmptyBorder(10,50,50,50));

	        frame3.add(panel3);
	        frame3.setPreferredSize(new Dimension(800,750));
	        frame3.pack();
	    }
	
}