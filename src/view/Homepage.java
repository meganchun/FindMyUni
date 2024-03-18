package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.jsoup.HttpStatusException;

import controller.FontClass;
import model.User;

public class Homepage extends JFrame implements ActionListener  {

	MenuBar menuBar;
	UpcomingEvents events;
	
	JButton viewMapBtn = new JButton("View Map");
	
	public Homepage(User user) throws HttpStatusException, IOException {
		
		events = new UpcomingEvents(user);
		menuBar = new MenuBar(this);
	
		//Set up the frame
		setSize(1280, 720); //size
		setTitle("Home");
		getContentPane().setBackground(Color.WHITE); //background colour
		setLayout(null);  //layout manager
		setLocationRelativeTo(null); //location of frame
		
		add(menuBar);
		
		//add the university image
		JLabel uniImage = new JLabel(new ImageIcon("images/uniImage.png"));
		uniImage.setBounds(83,137,1114,173);
		add(uniImage);
		
		//add the subtitle of the page
		JLabel subTitle = new JLabel("Find the university for you.");
		subTitle.setBounds(0, 0, 1114, 173);
		subTitle.setForeground(Color.WHITE);
		subTitle.setHorizontalAlignment(JLabel.CENTER);
		subTitle.setFont(FontClass.semibold50);
		uniImage.add(subTitle);
		
		//add the map images
		JLabel map = new JLabel(new ImageIcon("images/mapImage.png"));
		map.setBounds(864,335,333,313);
		add(map);
		
		//login button
		viewMapBtn.addActionListener(this);
		viewMapBtn.setBounds(0, 330, 500, 100); //set bounds
		viewMapBtn.setBackground(new Color(57, 90, 154)); //change background
		viewMapBtn.setForeground(Color.WHITE); //change text colour
		viewMapBtn.setHorizontalAlignment(JTextField.CENTER);  //align text
		viewMapBtn.setFont(FontClass.medium25); //set font
		viewMapBtn.setOpaque(true);
		viewMapBtn.setBorder(BorderFactory.createEmptyBorder()); //create empty border
		map.add(viewMapBtn); //add to the screen
		
		//add the subtitle for the upcoming events
		JLabel eventsTitle = new JLabel("Hi "+user.getFirstName()+", check out upcoming events...");
		eventsTitle.setBounds(83, 335, 380, 30);
		eventsTitle.setHorizontalAlignment(JLabel.LEFT);
		eventsTitle.setFont(FontClass.medium20);
		add(eventsTitle);
		
		events.setBounds(83, 383, events.getWidth(), events.getHeight());
		add(events);
		
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
	}
	

}
