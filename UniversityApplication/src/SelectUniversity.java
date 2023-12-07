import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

//This class represents the frame that will appear when the user wants
//to select a university to display on the map
public class SelectUniversity extends JFrame implements ActionListener{

	FontClass fonts = new FontClass();
	JLabel instructionsLabel = new JLabel("Select the universities you would like to see on the map:");
	JCheckBox[] uniCheckBoxes = new JCheckBox[17];
	static JButton submitButton = new JButton("Submit");
	Color buttonColor = new Color(57,90,154);
	
	public SelectUniversity() {
		setSize(800, 600);
		setVisible(true);
		setLayout(null);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(217,217,217));
		
		add(instructionsLabel);
		instructionsLabel.setFont(FontClass.medium25);
		instructionsLabel.setBounds(30, 20, 800, 25);
		
		//simplify this AND REMEMBER TO ASK ABOUT THE DIFFERENT CAMPUSES
		for (int uni = 0; uni < Map.universityArray.length; uni++) {
			uniCheckBoxes[uni] = new JCheckBox(Map.universityArray[uni].getName());
			uniCheckBoxes[uni].setBounds(40, 50 + (uni*30), 500, 25);
			uniCheckBoxes[uni].setFont(FontClass.regular16);
			add(uniCheckBoxes[uni]);
		}
		
		//creating the submit button
		add(submitButton);
		submitButton.setFont(FontClass.medium25);
		submitButton.setBounds(490, 480, 190, 70);
		submitButton.setBackground(buttonColor);
		submitButton.setBorderPainted(false);
		submitButton.addActionListener(this);
		submitButton.setOpaque(true);
		submitButton.setForeground(Color.white);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submitButton) {
			//set the frame visibility to false
			setVisible(false);
			//clear the map of all the points
			Map.clearMap();
			//go through all the checkboxes and see which ones were selected
			for (int i = 0; i < uniCheckBoxes.length; i++) {
				if (uniCheckBoxes[i].isSelected()) {
					//then go through all the points and if the point is for the university
					//the user picked, then have it visible
					for (SwingWaypoint w : Map.waypoints) {
						if (w.getText().equals(uniCheckBoxes[i].getText())) {
							w.getUniLogo().setVisible(true);
						}
					}
					System.out.println(uniCheckBoxes[i].getText());
					//go through and check which were selected
				}
			}
		}
		
	}
}
