package View;

import javax.swing.JPanel;

import Model.FontClass;
import model.FileReader;

import javax.swing.*;
import java.awt.*;

import Controller.*;
import Model.*;

public class ResultsGUIPanel extends JPanel {
	
	private FileReader importedPrograms = new FileReader();
	
	Survey survey;
	
	FontClass fonts;
	
	public ResultsGUIPanel() {
		
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		// may want to make this area fading images
		// https://stackoverflow.com/questions/20346661/java-fade-in-and-out-of-images
		JLabel image = new JLabel(new ImageIcon("Images/randomImage.png"));
		image.setSize(950,150);
//		image.setBounds(25,15,950,150);
		
		JPanel topResultsPanel = new JPanel();
		topResultsPanel.setSize(1000,1000);
//		topResultsPanel.setBounds(25,200,1000,1000);
		
		JLabel top = new JLabel("Top Results:");
		top.setFont(FontClass.semibold30);
		top.setSize(400,30);
		topResultsPanel.add(top);
//		top.setBounds(0,0,400,30);
		
		//best programs here
		ProgramPanel bestProgram = new ProgramPanel();
		
		JPanel similarResultsPanel = new JPanel();
		similarResultsPanel.setSize(1000,2000);
		
		JLabel similar = new JLabel("Similar Programs:");
		similar.setFont(FontClass.semibold30);
		similar.setBounds(25,585,400,30);
		similarResultsPanel.add(similar);
		
		// similar programs here
		
		add(image);
		add(topResultsPanel);
		add(similarResultsPanel);
		
		this.setSize(1015,5000);
		this.setVisible(true);
		this.setLayout(null);
		this.setBackground(new Color(243, 244, 245));

	}

}
