package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class ResultsGUIFrame extends JFrame {

	MenuBar menuBar;	
	
	ResultsGUIPanel results;
	
	JScrollPane scroll = new JScrollPane();
	
	SurveyGUIPanel surveyPanel;
	
	public ResultsGUIFrame() {
		
		menuBar = new MenuBar();
		menuBar.setLocation(0,0);	
		
		results = new ResultsGUIPanel();
		
		// scroll wheel for the SurveyGUI panel
		scroll = new JScrollPane(results, scroll.VERTICAL_SCROLLBAR_ALWAYS, scroll.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.getVerticalScrollBar().setPreferredSize(new Dimension(15,0));
		// https://alvinalexander.com/blog/post/jfc-swing/how-increase-speed-jscrollpane-mouse-wheel/#:~:text=Just%20use%20the%20reference%20to,setUnitIncrement(16)%3B
		scroll.getVerticalScrollBar().setUnitIncrement(16);
		scroll.setBounds(140,137,1000,560);
		
		this.add(menuBar);
		this.add(scroll);
		this.setLayout(null);
		this.setSize(1280,720);
		this.setVisible(true);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(255, 255, 255));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	private void calculateBestProgram() {
		
		for (int i = 0; i < surveyPanel.getMarksGUIsPanel().getGr11Marks().length; i++) {
			
			String currentCourse = (String) surveyPanel.getMarksGUIsPanel().getGr11Marks()[i].getCourseDropdown().getSelectedItem();
			System.out.println(currentCourse);
			
		}
	}
	
}
