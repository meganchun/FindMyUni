package View;
/* Megan Chun
 * 
 * External Source: https://stackoverflow.com/questions/22965783/how-to-hide-text-when-typing-in-inputdialog (password)
 */
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controller.FontClass;

public class LoginFrame extends JFrame implements KeyListener, ActionListener {

	FontClass fonts = new FontClass();
	
	JLabel logo = new JLabel(new ImageIcon("Images/logo.png"));
	JTextField username = new JTextField("  Username");
	JPasswordField password = new JPasswordField("");
	JLabel tempPassword = new JLabel("Password");
	JButton loginBtn = new JButton("Login");
	JButton signUp = new JButton("<HTML><U>Don’t have an account? Click here to sign up.</U></HTML>");
	
	public LoginFrame() {
	
		setSize(1200, 720);
		setTitle("Login");
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setLocationRelativeTo(null);
	
		logo.setBounds(0, 60, 1200, 97);
		logo.setHorizontalAlignment(JLabel.CENTER);
		add(logo);
		
		JLabel title = new JLabel("Welcome to,");
		title.setBounds(0, 160, 1200, 25);
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(FontClass.medium25);
		add(title);
		
		JLabel head = new JLabel("Find My Uni");
		head.setBounds(0, 190, 1200, 50);
		head.setHorizontalAlignment(JLabel.CENTER);
		head.setFont(FontClass.semibold50);
		add(head);
		
		//username textfield
		username.addKeyListener(this); //add key listener
		username.setBounds(350, 280, 500, 65); 
		username.setBackground(new Color(243, 244, 245)); //change background
		username.setForeground(new Color(105,105,105)); //change text colour
		username.setHorizontalAlignment(JTextField.LEFT); //align text
		username.setFont(FontClass.medium25); //set font
		username.setBorder(BorderFactory.createEmptyBorder()); //create transparent border
		add(username);
		
		//password textfield
		password.addKeyListener(this);  //add key listener
		password.setEchoChar('•'); 
		password.setBounds(350, 360, 500, 65);
		password.setBackground(new Color(243, 244, 245)); //change background
		password.setForeground(new Color(105,105,105)); //change text colour
		password.setHorizontalAlignment(JTextField.LEFT);  //align text
		password.setFont(FontClass.medium25); //set font
		password.setBorder(BorderFactory.createEmptyBorder());  //create transparent border
		add(password);

		//temporary place holder
		tempPassword.setForeground(new Color(105,105,105));
		tempPassword.setFont(FontClass.medium25);
		tempPassword.setBounds(10, 0, 500, 65);
		password.add(tempPassword);
		
		//login button
		
		loginBtn.setBounds(350, 480, 500, 65);
		loginBtn.setBackground(new Color(57, 90, 154));
		loginBtn.setForeground(Color.WHITE);
		loginBtn.setHorizontalAlignment(JTextField.CENTER); 
		loginBtn.setFont(FontClass.medium25);
		loginBtn.setOpaque(true);
		loginBtn.addActionListener(this);
		loginBtn.setBorder(BorderFactory.createEmptyBorder());
		add(loginBtn);
		
		signUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		signUp.addActionListener(this);
		signUp.setBounds(350, 580, 500, 20);
		signUp.setOpaque(false);
		signUp.setForeground(Color.BLACK);
		signUp.setBorder(BorderFactory.createEmptyBorder());
		signUp.setFont(FontClass.medium16);
		add(signUp);
		setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		System.out.println(e.getComponent().getY());
		
		//if the user is typing in the password field
		if (e.getComponent().getY() == 360) 
			tempPassword.setVisible(false);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == signUp) {
			new CreateAccount();
			this.dispose();
		}
		
		if (e.getSource() == loginBtn) {
			this.dispose();
		}
	}
}
