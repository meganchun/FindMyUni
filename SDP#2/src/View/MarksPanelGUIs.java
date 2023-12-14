package View;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.FontClass;

public class MarksPanelGUIs extends JPanel implements ActionListener {
	
	MarksPanelGUI marksGUIPanel;
	SurveyGUIFrame surveyGUI;
	
	MarksPanelGUI[] gr11Marks = new MarksPanelGUI[10];
	
	MarksPanelGUI[] gr12Marks = new MarksPanelGUI[10];

	JButton[] addGr11Button = new JButton[4];
	
	JButton[] addGr12Button = new JButton[4];

	JButton submitButton = new JButton("Submit");
	
	FontClass font = new FontClass();
	
	String gr11Courses[] = {"Drama", "Music - Band", "Music - Vocal/Choral", "Repertoire", "Media Arts", "Visual Arts", 
			"Accounting Fundamentals", "Business Marketing",    
			"Geography", "History", "Canadian Law", "Philosophy", 
			"Intro to Computer Programming", "Intro to Computer Science", 
			"Co-op", 
			"English", "Presentation & Speaking", "English - 2nd Language", "French - 2nd Language",
			"Special Education", 
			"Health Fitness", "Health Physical Education", 
			"Interdisciplinary Studies", 
			"Functions & Applications", "Functions", "Math for Work & Everyday Life", 
			"Biology", "Chemistry", "Physics", 
			"Intro to APS", 
			"Construction Engineering", "Technolohy Design", "Hospitality & Tourism", "Communications Technology", "Health Care", "Hairstyling & Asthetics"};
	
	String gr12Courses[] = {"Drama", "Music - Band", "Music - Vocal/Choral", "Repertoire", "Media Arts", "Visual Arts", 
			"Accounting Principles", "International Business", "Business Leadership", "Analysing Economic Issues",
			"World Issues", "History", "Canadian Law", "Philosophy", 
			"Computer Science", 
			"Co-op", 
			"English", "English - 2nd Language", "French - 2nd Language",
			"Special Education", 
			"Health Fitness", "Health P.E. Leadership", "Health Physical Education", "Kinesiology", 
			"Calculus and Vectors", "Data Management", "Math for Work & Everyday Life", "Advanced Functions",
			"Biology", "Chemistry", "Physics", 
			"Nutrition and Health", "Families in Canada", "Fashion", "Challenge & Change in Society",
			"Construction Technology", "Technology Design", "Hospitality & Tourism", "Communications Technology", "Health Care"};
	
	DefaultComboBoxModel gr11 = new DefaultComboBoxModel(gr11Courses);
	
	DefaultComboBoxModel gr12 = new DefaultComboBoxModel(gr12Courses);
	
	int x = 510;
	int y = 690;
	
	public MarksPanelGUIs() {

		for (int i = 0; i < gr11Marks.length; i++) {
			gr11Marks[i] = new MarksPanelGUI();
			gr11Marks[i].getCourseNum().setText("Course " + (i+1) + ":");
			gr11Marks[i].setLocation(0,0+90*i);
			gr11 = new DefaultComboBoxModel(gr11Courses);
			gr11Marks[i].getCourseDropdown().setModel(gr11);
			gr11Marks[i].getCourseDropdown().setSelectedItem(null);
			this.add(gr11Marks[i]);
			
			if (i > 5) {
				gr11Marks[i].setVisible(false);
			}
		}
		
		for (int i = 0; i < gr12Marks.length; i++) {
			gr12Marks[i] = new MarksPanelGUI();
			gr12Marks[i].getCourseNum().setText("Course " + (i+1) + ":");
			gr12Marks[i].setLocation(645,0+90*i);
			gr12 = new DefaultComboBoxModel(gr12Courses);
			gr12Marks[i].getCourseDropdown().setModel(gr12);
			gr12Marks[i].getCourseDropdown().setSelectedItem(null);;
			this.add(gr12Marks[i]);
			
			if (i > 5) {
				gr12Marks[i].setVisible(false);
			}
		}
		
		// adding buttons for grade 11
		for (int i = 0; i < addGr11Button.length; i++) {
			addGr11Button[i] = new JButton();
			addGr11Button[i].setBounds(150,540+i*90,200,80);
			addGr11Button[i].addActionListener(this);
			this.add(addGr11Button[i]);
			
			if (i > 0) {
				addGr11Button[i].setVisible(false);
			}
		}
		
		// adding button for grade 12
		for (int i = 0; i < addGr12Button.length; i++) {
			addGr12Button[i] = new JButton();
			addGr12Button[i].setBounds(795,540+i*90,200,80);
			addGr12Button[i].addActionListener(this);
			this.add(addGr12Button[i]);
			
			if (i > 0) {
				addGr12Button[i].setVisible(false);
			}
		}
		
		submitButton.setBounds(x,y,130,70);
		submitButton.setBackground(new Color(57, 90, 154));
		submitButton.setForeground(Color.white);
		submitButton.setFont(FontClass.medium20);
//		submitButton.setBorder(new RoundedBorder(50));
		submitButton.addActionListener(this);
		add(submitButton);
	    
		this.setBackground(new Color(243, 244, 245));
		this.setSize(1145,1100);
		this.setLayout(null);
		this.setVisible(true);
		
	}
	
	// Getters and setters
	public MarksPanelGUI getMarksGUIPanel() {
		return marksGUIPanel;
	}

	public void setMarksGUIPanel(MarksPanelGUI marksGUIPanel) {
		this.marksGUIPanel = marksGUIPanel;
	}

	public MarksPanelGUI[] getGr11Marks() {
		return gr11Marks;
	}

	public void setGr11Marks(MarksPanelGUI[] gr11Marks) {
		this.gr11Marks = gr11Marks;
	}

	public MarksPanelGUI[] getGr12Marks() {
		return gr12Marks;
	}

	public void setGr12Marks(MarksPanelGUI[] gr12Marks) {
		this.gr12Marks = gr12Marks;
	}

	public JButton[] getAddGr11Button() {
		return addGr11Button;
	}

	public void setAddGr11Button(JButton[] addGr11Button) {
		this.addGr11Button = addGr11Button;
	}

	public JButton[] getAddGr12Button() {
		return addGr12Button;
	}

	public void setAddGr12Button(JButton[] addGr12Button) {
		this.addGr12Button = addGr12Button;
	}

	public JButton getSubmitButton() {
		return submitButton;
	}

	public void setSubmitButton(JButton submitButton) {
		this.submitButton = submitButton;
	}

	public String[] getGr11Courses() {
		return gr11Courses;
	}

	public void setGr11Courses(String[] gr11Courses) {
		this.gr11Courses = gr11Courses;
	}

	public String[] getGr12Courses() {
		return gr12Courses;
	}

	public void setGr12Courses(String[] gr12Courses) {
		this.gr12Courses = gr12Courses;
	}

	public DefaultComboBoxModel getGr11() {
		return gr11;
	}

	public void setGr11(DefaultComboBoxModel gr11) {
		this.gr11 = gr11;
	}

	public DefaultComboBoxModel getGr12() {
		return gr12;
	}

	public void setGr12(DefaultComboBoxModel gr12) {
		this.gr12 = gr12;
	}

	public SurveyGUIFrame getSurveyGUI() {
		return surveyGUI;
	}

	public void setSurveyGUI(SurveyGUIFrame surveyGUI) {
		this.surveyGUI = surveyGUI;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
//		if (e.getSource() == submitButton) {
//			getSurveyGUI().dispose();
//		}
		
		for (int i = 0; i < addGr11Button.length; i++) {
			if (e.getSource() == addGr11Button[i]) {
					getGr11Marks()[i+6].setVisible(true);
					getAddGr11Button()[i].setVisible(false);
					getAddGr11Button()[i+1].setVisible(true);
					if (y == 690+90*i) {
						y = 690+90*(i+1);
						getSubmitButton().setLocation(510,y);
					}
//					surveyGUI.getSurveyGUIPanel().setPreferredSize(new Dimension(1255,1850+90*i+1));
			}
		}

		for (int i = 0; i < addGr12Button.length; i++) {
			if (e.getSource() == addGr12Button[i]) {
					getGr12Marks()[i+6].setVisible(true);
					getAddGr12Button()[i].setVisible(false);
					getAddGr12Button()[i+1].setVisible(true);
					if (y == 690+90*i) {
						y = 690+90*(i+1);
						getSubmitButton().setLocation(510,y);
					}
//					surveyGUI.getSurveyGUIPanel().setPreferredSize(new Dimension(1255,1850+90*i+1));
			}		
		}
	}

}
