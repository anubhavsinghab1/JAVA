package EmployeeManagement;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCursor;

public class DeleteEmployee {

	 public static void deleteEmployee(){

	        Menu.menuFrame.setVisible(false);

	        JFrame frame = new JFrame("Delete Employee");

	        JLabel label = new JLabel("Enter employee id");
	        label.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        label.setBounds(250,200,200,50);
	        frame.add(label);

	        JTextField idVal = new JTextField();
	        idVal.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        idVal.setBounds(500,200,200,50);
	        frame.add(idVal);
	        idVal.addKeyListener(new KeyAdapter() {
	            public void keyTyped(KeyEvent e) {
	                char c = e.getKeyChar();
	                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
	                    e.consume();  // if it's not a number, ignore the event
	                }
	            }
	        });

	        JButton backButton = new JButton("Back");
	        backButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	        backButton.setBounds(275, 400, 150,40);
	        backButton.setFocusPainted(false);

	        backButton.addActionListener(actionListener -> {
	           Menu.menuFrame.setVisible(true);
	            frame.dispose();

	        });
	        frame.add(backButton);

	        JButton submitButton = new JButton("Delete");
	        submitButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	        submitButton.setBounds(525, 400, 150,40);
	        submitButton.setFocusPainted(false);

	        submitButton.addActionListener(actionEvent -> {
	            int id = Integer.parseInt(idVal.getText());
	           
	            try {
	            	 Bson fil =and(eq("Employee_Id",id));
	            	 MongoCursor<Document> cur =Menu.coll.find(fil).iterator();
//	              
	                if (cur.hasNext()) {
	                    Menu.coll.deleteOne(fil);
	                    Menu.menuFrame.setVisible(true);
	                    frame.dispose();

	                }
	                else{
	                    JFrame popup = new JFrame("Invalid ID");
	                    JLabel popupMsg = new JLabel("The ID you entered is invalid.");
	                    popupMsg.setBounds(45,20,300, 20);
	                    popupMsg.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	                    popup.add(popupMsg);

	                    JButton button = new JButton("OK");
	                    button.setBounds(120,60,70,20);
	                    button.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	                    button.addActionListener(actionEvent2 -> {
	                        popup.dispose();
	                    });
	                    popup.add(button);

	                    popup.setLayout(null);
	                    popup.setBounds(400,300,350, 150);;
	                    popup.setVisible(true);

	                }
	            } catch (MongoException throwables) {
	                throwables.printStackTrace();
	            }

	        });

	        frame.add(submitButton);

	        frame.setLayout(null);
	        frame.setSize(new Dimension(1100,750));
	        frame.setVisible(true);
	    }

	
}
