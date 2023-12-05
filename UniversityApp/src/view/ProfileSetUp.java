package view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.FontClass;


public class ProfileSetUp extends JFrame {
	
	FontClass fonts = new FontClass();
	
	public ProfileSetUp() {
		
		//Set up the frame
		setSize(1280, 720); //size
		setTitle("Profile Set Up"); //title
		getContentPane().setBackground(Color.WHITE); //background colour
		setLayout(null);  //layout manager
		setLocationRelativeTo(null); //location of frame
		
		
		//Title label for the screen
		JLabel title = new JLabel("Set up your preferences to begin...");
		title.setFont(getFont());
		title.setBounds(0, 77, 1280, 65); 
		title.setForeground(new Color(50,50,50)); //change text colour
		title.setHorizontalAlignment(JTextField.LEFT); //align text
		title.setFont(FontClass.medium25); //set font
		add(title);
		
		//Title label for the contact info
		JLabel contactTitle = new JLabel("Contact Info");
		contactTitle.setFont(getFont());
		contactTitle.setBounds(0, 241, 1280, 65); 
		contactTitle.setForeground(new Color(50,50,50)); //change text colour
		contactTitle.setHorizontalAlignment(JTextField.LEFT); //align text
		contactTitle.setFont(FontClass.medium25); //set font
		add(contactTitle);
		
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		new ProfileSetUp();
	}
}
