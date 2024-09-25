package EmployeeManagement;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.mongodb.MongoException;


public class Employee {

	static String username = "";
	static String password = "";
   
    public static void main(String[] args) throws MongoException, ClassNotFoundException {


        Menu ems = new Menu();

        ems.loginFrame = new JFrame("Login");

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(200,150,220,50);
        usernameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        ems.loginFrame.add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        usernameField.setBounds(450,150,420,50);
        ems.loginFrame.add(usernameField);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        passwordLabel.setBounds(200,250,220,50);
        ems.loginFrame.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        passwordField.setBounds(450,250,420,50);
        ems.loginFrame.add(passwordField);

        JButton submitButton=new JButton("Submit");
        submitButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        submitButton.setBounds(450,400,250, 50);

        submitButton.addActionListener(actionEvent -> {
            username = usernameField.getText();
            password = String.valueOf(passwordField.getPassword());

            try {
                boolean auth = Login.login(username, password);
                if(auth){
                    ems.loginFrame.dispose();
                    Menu.mainMenu();
                }

            } catch (MongoException throwables) {
                throwables.printStackTrace();
            }
        });
        ems.loginFrame.add(submitButton);

        ems.loginFrame.setSize(1100,750);
        ems.loginFrame.setLayout(null);
        ems.loginFrame.setVisible(true);
        ems.loginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}