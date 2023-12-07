
import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;
import java.net.URI;


/**
 * A waypoint that is represented by a button on the map.
 *
 * @author Daniel Stahr
 */
public class SwingWaypoint extends DefaultWaypoint implements ActionListener {
	FontClass fonts = new FontClass();
	private final JButton uniLogo;
	private String text;

	JFrame uniFrame = new JFrame();
	JLabel uniNameLabel = new JLabel("");
	JLabel uniPicture = new JLabel(new ImageIcon());
	JLabel addressLabel = new JLabel("Address: ");
	JLabel uniAddress = new JLabel("");
	JLabel phoneLabel = new JLabel("Phone Number: ");
	JButton learnMore = new JButton("Learn More");
	
	String uniWebsite;

	public SwingWaypoint(String text, GeoPosition coord) {
		super(coord);
		this.text = text;

		// Get the path of the university's logo and scale the image
		ImageIcon logo = new ImageIcon("Logo/" + withoutDash(text) + "Logo.png");
		Image logoScaled = logo.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);

		// add the image to the button/waypoint
		uniLogo = new JButton(new ImageIcon(logoScaled));

		// style the button/waypoint
		uniLogo.setBorder(new EmptyBorder(0, 0, 0, 0));
		uniLogo.setOpaque(true);
		uniLogo.setSize(24, 24);
		uniLogo.addActionListener(this);
		uniLogo.setVisible(true);

		// style the frame that appears when you click on the university's waypoint
		uniFrame.setSize(600, 300);
		uniFrame.setLocationRelativeTo(null);
		uniFrame.setBackground(new Color(243, 244, 245));
		uniFrame.setLayout(null)		;//uniFrame.setLayout(new BorderLayout());

		// Style the label of the name of the university
		uniNameLabel.setBounds(0, 10, 600, 30);
		uniNameLabel.setHorizontalAlignment(JLabel.CENTER);
		uniNameLabel.setFont(FontClass.medium16);
		//uniNameLabel.setSize(1000, 30);
		uniFrame.add(uniNameLabel/*, BorderLayout.PAGE_START*/);

		// Style the picture of the university
		uniPicture.setBounds(20, 45, 270, 220);
		uniPicture.setSize(270, 220);
		uniFrame.add(uniPicture/*, BorderLayout.LINE_START*/);

		// Style the label of the address of the university
		addressLabel.setBounds(300, 50, 500, 20);
		addressLabel.setFont(FontClass.regular16);
		addressLabel.setSize(500, 20);	
		uniFrame.add(addressLabel/*, BorderLayout.LINE_END*/);
		
		uniAddress.setBounds(300, 80, 500, 20);
		uniAddress.setFont(FontClass.regular16);
		uniFrame.add(uniAddress);

		// Style the label of the phone number of the university
		phoneLabel.setBounds(300, 120, 500, 20);
		phoneLabel.setFont(FontClass.regular16);
		phoneLabel.setSize(500, 20);	
		uniFrame.add(phoneLabel/*, BorderLayout.LINE_END*/);

		// Style the label of the button that will take the user to the website of the
		// university
		learnMore.setFont(FontClass.regular16);
		learnMore.setBounds(300, 160, 200, 60);
		learnMore.setBackground(new Color(57, 90, 154));
		learnMore.setBorderPainted(false);
		learnMore.setOpaque(true);
		learnMore.setForeground(Color.white);
		learnMore.addActionListener(this);
		uniFrame.add(learnMore/*, BorderLayout.LINE_END*/);

		uniFrame.setVisible(false);
	}

	// This method will make sure that the same logo will be displayed
	// universities with multiple campuses
	public String withoutDash(String text) {
		if (text.contains("-")) {

			String withoutDash = text.substring(0, (text.indexOf("-") - 1));
			return withoutDash;
		} else
			return text;
	}

	JButton getUniLogo() {
		return uniLogo;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	// This will allow me to remove a waypoint in case the user does not want to see
	// it
	public void removeWaypoint() {
		uniLogo.setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == uniLogo) {
			//Create the panel for each university
			//Set the university's name as the title
			uniNameLabel.setText(text);
			//get the picture of the corresponding university and scale it so that
			//it will fit in the required dimensions
			ImageIcon campusPic = new ImageIcon("UniCampus/" + text + ".jpeg");
			Image campusPicScaled = campusPic.getImage().getScaledInstance(270, 220, Image.SCALE_SMOOTH);
			//set the image as the icon for the jlabel
			uniPicture.setIcon(new ImageIcon(campusPicScaled));
			
			//check every university in the array
			for (University university:Map.universityArray) {
				//if the university the user clicked on is the same as one in the university array
				//then display the appropriate information 
				if (text.equals(university.getName())) {
					uniAddress.setText(university.getAddress());
					phoneLabel.setText("Phone Number: " + university.getPhoneNumber());
					uniWebsite = university.getLink();
				}
			}
			uniFrame.setVisible(true);
		} 
		else if (e.getSource() == learnMore) {

			//If the user wants to learn more and visit the university's website
			//get the desktop and open the link in their desktop
			Desktop desktop = Desktop.getDesktop();
			
			try {
				desktop.browse(URI.create(uniWebsite));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}
}
