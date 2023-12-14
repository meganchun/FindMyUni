package View;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

import Model.FontClass;

public class MarksPanelGUI extends JPanel {
	

	FontClass fonts = new FontClass();
	
	JLabel courseNum = new JLabel("Course");
	
	String courses[] = {"Functions", "Chemistry", "Physics", "Biology"
			, "Intro to Comp Sci", "English"};
	
	DefaultComboBoxModel model = new DefaultComboBoxModel(courses);
	
	JComboBox courseDropdown = new JComboBox();
	
	JTextField gr11MarkPercent = new JTextField();
	
	boolean dot = false;
	
	public MarksPanelGUI() {
		
		// title for Course #
		courseNum.setBounds(0,0,200,30);
		courseNum.setFont(FontClass.medium25);
		
		// title for Mark
		JLabel gr11Mark = new JLabel("Mark:");
		gr11Mark.setBounds(380,0,100,30);
		gr11Mark.setFont(FontClass.medium25);
		
		// learned how to use combobox from https://www.javatpoint.com/java-jcombobox
		// dropdown where user can select an option

		courseDropdown.setModel(model);
		courseDropdown.setSelectedItem(null);
		courseDropdown.setBounds(0,30,330,40);
		courseDropdown.setFont(FontClass.medium20);
		courseDropdown.setBackground(new Color (255,255,255));
		
		// box where user will be able to input their mark
		gr11MarkPercent.setEditable(true);
		gr11MarkPercent.setBounds(380,30,120,40);
		gr11MarkPercent.setFont(FontClass.medium20);
		// https://www.youtube.com/watch?v=1HyMztaV4ME
		gr11MarkPercent.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
			    char vChar = e.getKeyChar();
			    if (gr11MarkPercent.getText().equals(""))
			        dot = false;
			    if (dot == false){
			        if (vChar == '.') dot = true;
			        else if (!(Character.isDigit(vChar)
			                || (vChar == KeyEvent.VK_BACK_SPACE)
			                || (vChar == KeyEvent.VK_DELETE))) {
			                e.consume();
			        }
			    } else {
			        if (!(Character.isDigit(vChar)
			                || (vChar == KeyEvent.VK_BACK_SPACE)
			                || (vChar == KeyEvent.VK_DELETE))) {
			                e.consume();
			        }
			    }
			    // https://stackoverflow.com/questions/3519151/how-to-limit-the-number-of-characters-in-jtextfield
			    if (gr11MarkPercent.getText().length() >= 4) // limit textfield to 4 characters
			    	 e.consume();
			}
		});
		
		this.add(courseNum);
		this.add(courseDropdown);
		this.add(gr11Mark);
		this.add(gr11MarkPercent);
		
		this.setBackground(new Color(243, 244, 245));
		this.setLayout(null);
		this.setSize(500,80);
		this.setVisible(true);		
		
	}

	public JLabel getCourseNum() {
		return courseNum;
	}

	public void setCourseNum(JLabel courseNum) {
		this.courseNum = courseNum;
	}

	public String[] getCourses() {
		return courses;
	}

	public void setCourses(String[] courses) {
		this.courses = courses;
	}

	public DefaultComboBoxModel getModel() {
		return model;
	}

	public void setModel(DefaultComboBoxModel model) {
		this.model = model;
	}

	public JComboBox getCourseDropdown() {
		return courseDropdown;
	}

	public void setCourseDropdown(JComboBox courseDropdown) {
		this.courseDropdown = courseDropdown;
	}

	public JTextField getGr11MarkPercent() {
		return gr11MarkPercent;
	}

	public void setGr11MarkPercent(JTextField gr11MarkPercent) {
		this.gr11MarkPercent = gr11MarkPercent;
	}

}
