package view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Homepage extends JFrame {

	MenuBar menuBar = new MenuBar();
	JLabel uniImage = new JLabel(new ImageIcon("images/uniImage.png"));
	
	public Homepage() {
	
		//Set up the frame
		setSize(1280, 720); //size
		setTitle("Home");
		getContentPane().setBackground(Color.WHITE); //background colour
		setLayout(null);  //layout manager
		setLocationRelativeTo(null); //location of frame
		
		add(menuBar);
		
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new Homepage();
	}
}
