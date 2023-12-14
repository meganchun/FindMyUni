package View;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class SurveyGUIFrame extends JFrame {

	MenuBar menuBar;
	
	JScrollPane scroll = new JScrollPane();
	
	SurveyGUIPanel surveyGUIPanel = new SurveyGUIPanel();
	
	public SurveyGUIFrame() {
		
		// scroll wheel for the SurveyGUI panel
		scroll = new JScrollPane(surveyGUIPanel, scroll.VERTICAL_SCROLLBAR_ALWAYS, scroll.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.getVerticalScrollBar().setPreferredSize(new Dimension(15,0));
		// https://alvinalexander.com/blog/post/jfc-swing/how-increase-speed-jscrollpane-mouse-wheel/#:~:text=Just%20use%20the%20reference%20to,setUnitIncrement(16)%3B
		scroll.getVerticalScrollBar().setUnitIncrement(16);
		scroll.setBounds(0,137,1267,560);
		
		menuBar = new MenuBar();
		menuBar.setLocation(0,0);	
		
		this.add(scroll);
		this.add(menuBar);
		this.setLayout(null);
		this.setSize(1280,720);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}

	public SurveyGUIPanel getSurveyGUIPanel() {
		return surveyGUIPanel;
	}

	public void setSurveyGUIPanel(SurveyGUIPanel surveyGUIPanel) {
		this.surveyGUIPanel = surveyGUIPanel;
	}
	
}
