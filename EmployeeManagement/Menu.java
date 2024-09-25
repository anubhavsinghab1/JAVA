package EmployeeManagement;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Menu {

	  static MongoClient mongo=new MongoClient("localhost",27017);
	   static MongoDatabase database=mongo.getDatabase("user");
	   
	    static MongoCollection<Document> coll=database.getCollection("data");
	 
	    static MongoCollection<Document> conn=database.getCollection("user");

	   static JFrame menuFrame;
	   JFrame loginFrame;
	
	 static public void mainMenu(){
		 
	        menuFrame = new JFrame("Employee Management System");

	        JLabel welcomeLabel = new JLabel("Welcome to Employee Management System");
	        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 32));
	        welcomeLabel.setBounds(250,50,800,50);
	        menuFrame.add(welcomeLabel);

	        JButton viewEmpButton = new JButton("View all employees");
	        viewEmpButton.setBounds(400, 200, 300, 40);
	        viewEmpButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	        viewEmpButton.setFocusPainted(false);
	        viewEmpButton.addActionListener(actionEvent -> {
	            try {
	                ViewEmployee.viewEmployee();
	            } catch (MongoException throwables) {
	                throwables.printStackTrace();
	              }
	        });
	        menuFrame.add(viewEmpButton);

	        JButton addEmpButton = new JButton("Add an employee");
	        addEmpButton.setBounds(400, 270, 300, 40);
	        addEmpButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	        addEmpButton.setFocusPainted(false);
	        addEmpButton.addActionListener(actionEvent -> {
	            try {
	                AddEmployee.addEmployee();
	            } catch (MongoException throwables) {
	                throwables.printStackTrace();
	            }
	        });
	        menuFrame.add(addEmpButton);

	        JButton editEmpButton = new JButton("Edit an employee");
	        editEmpButton.setBounds(400, 340, 300, 40);
	        editEmpButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	        editEmpButton.setFocusPainted(false);
	        editEmpButton.addActionListener(actionEvent -> {
	            try {
	                EditEmployee.editEmployee();
	            } catch (MongoException throwables) {
	                throwables.printStackTrace();
	            }
	        });
	        menuFrame.add(editEmpButton);

	        JButton deleteEmpButton = new JButton("Delete an employee");
	        deleteEmpButton.setBounds(400, 410, 300, 40);
	        deleteEmpButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	        deleteEmpButton.setFocusPainted(false);
	        deleteEmpButton.addActionListener(deleteEvent -> {
	            DeleteEmployee.deleteEmployee();
	        });
	        menuFrame.add(deleteEmpButton);

	        JButton exitButton = new JButton("Exit");
	        exitButton.setBounds(400, 480, 300, 40);
	        exitButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	        exitButton.setFocusPainted(false);

	        exitButton.addActionListener(actionEvent -> {
	            menuFrame.dispose();
	        });
	        menuFrame.add(exitButton);


	        menuFrame.setSize(1100,750);
	        menuFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	        menuFrame.setLayout(null);//using no layout managers
	        menuFrame.setVisible(true);//making the frame visible

	    }

	
}
