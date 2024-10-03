package ATM;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.mongodb.MongoException;

public class Main {

	static String atmno = "";
	static String atmpin = "";
    static JTextField cardnoField,transaccount;
    public static void main(String[] args) throws MongoException, ClassNotFoundException { 
    	

        Sign_In.loginFrame = new JFrame("Login");

        JLabel cardnoLabel = new JLabel("Atm Card Number :");
        cardnoLabel.setBounds(200,150,220,50);
        cardnoLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        Sign_In.loginFrame.add(cardnoLabel);

        cardnoField= new JTextField();
        cardnoField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        cardnoField.setBounds(450,150,420,50);
        Sign_In.loginFrame.add(cardnoField);

        JLabel pinLabel = new JLabel("Atm Pin :");
        pinLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        pinLabel.setBounds(200,250,220,50);
        Sign_In.loginFrame.add(pinLabel);

        JPasswordField pinField = new JPasswordField();
        pinField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        pinField.setBounds(450,250,420,50);
        Sign_In.loginFrame.add(pinField);

        JButton submitButton=new JButton("Sign In");
        submitButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        submitButton.setBounds(250,350,250, 50);

        submitButton.addActionListener(actionEvent -> {
            atmno = cardnoField.getText();
            atmpin = String.valueOf(pinField.getPassword());

            try {
                boolean auth = Sign_In.login(atmno, atmpin);
                if(auth){
                    Sign_In.loginFrame.dispose();
                    MainPage.Menu();
                }

            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
        });
        
        JButton clear=new JButton("Clear");
        clear.setFont(new Font("Times New Roman",Font.PLAIN,30));
        clear.setBounds(550,350,250,50);
        
        clear.addActionListener(actionEvent->{
        	cardnoField.setText("");
        	pinField.setText("");
        });
        
        
        JButton regBtn=new JButton("Create Account");
        regBtn.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        regBtn.setBounds(250,450, 550, 50);
        
        
        
        regBtn.addActionListener(actionEvent ->{
        	Sign_In.loginFrame.dispose();
        	Registration.register();
        });
        
        JButton exitBtn=new JButton("Exit");
        exitBtn.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        exitBtn.setBounds(400,550, 250, 50);
        
        exitBtn.addActionListener(actionListener->{
        	System.exit(0);
        });
        
        Sign_In.loginFrame.add(submitButton);
        Sign_In.loginFrame.add(clear);
        Sign_In.loginFrame.add(regBtn);
        Sign_In.loginFrame.add(exitBtn);
      
        Sign_In.loginFrame.setSize(1100,750);
        Sign_In.loginFrame.setLayout(null);
        Sign_In.loginFrame.setVisible(true);

        
        Sign_In.loginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}