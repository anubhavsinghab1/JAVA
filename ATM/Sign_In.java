package ATM;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class Sign_In {
	
	static MongoClient mongo =new MongoClient("localhost",27017);
	static MongoDatabase database=mongo.getDatabase("Bank");
	static MongoCollection<Document> conn=database.getCollection("customer");
	static MongoCollection<Document> coll=Sign_In.database.getCollection("Account");

    static public boolean login(String atmcardno, String pin) throws MongoException {
    	Bson filter=and(eq("Card No",atmcardno));
    	MongoCursor<Document> cursor =conn.find(filter).iterator();
    	
        if(cursor.hasNext()){
        	Bson filt =and(eq("Atm Pin",pin));
        	 MongoCursor<Document> curs =conn.find(filt).iterator();
            if(curs.hasNext()){
                return true;
            }
            else {
                JFrame popup = new JFrame("Invalid password");
                JLabel popupMsg = new JLabel("The pin you entered is invalid.");
                popupMsg.setBounds(20,10,300,50);
                popupMsg.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                popup.add(popupMsg);

                JButton button = new JButton("OK");
                button.setBounds(130,60,70,20);
                button.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                button.addActionListener(actionEvent2 -> {
                    popup.dispose();
                });
                popup.add(button);

                popup.setLayout(null);
                popup.setBounds(400,300,350, 150);
                popup.setVisible(true);
                return false;
            }
        }
        else {
            JFrame popup = new JFrame("Invalid Atm Number");
            JLabel popupMsg = new JLabel("No account ! Open Account");
            popupMsg.setBounds(80,10,500,50);
            popupMsg.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            popup.add(popupMsg);

            JButton button = new JButton("OK");
            button.setBounds(145,60,70,20);
            button.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            button.addActionListener(actionEvent2 -> {
                popup.dispose();
            });
            popup.add(button);

            popup.setLayout(null);
            popup.setBounds(400,300,400, 150);
            popup.setVisible(true);
            return false;
        }
    }

	public static JFrame loginFrame;



	
}
