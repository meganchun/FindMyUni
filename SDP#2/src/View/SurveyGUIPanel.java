package View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import java.awt.*;
import javax.swing.GroupLayout.Alignment;

import Model.FontClass;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SurveyGUIPanel extends JPanel {

	FontClass font = new FontClass();
	
	boolean dot = false;

	MarksPanelGUIs marksGUIsPanel;
	
	JTextField q1 = new JTextField();
	JTextField q2 = new JTextField();
	String monthlyWage[] = {"$0 to $500", "$500 to $1000", "$1000 to $1500"
			, "$1500 to $2000", "$2000+"};
	JComboBox q3 = new JComboBox(monthlyWage);
	JCheckBox q4ans1 = new JCheckBox("Parental Funding");
	JCheckBox q4ans2 = new JCheckBox("Scholarship");
	JCheckBox q4ans3 = new JCheckBox("Student Loans");
	JCheckBox q4ans4 = new JCheckBox("Personal Funding");
	String afterHS[] = {"Take a gap year", "Go to University", "Go to College"
	,"Start an Apprenticeship", "Get a Full-Time Job", "Start a Business"};
	JComboBox q5 = new JComboBox(afterHS);
	JTextField q6 = new JTextField();
	
	
	public SurveyGUIPanel() {
		
		JLabel mainTitle = new JLabel("Survey Page");
		mainTitle.setFont(FontClass.semibold30);
		
		JLabel finance = new JLabel("Financial Position");
		finance.setFont(FontClass.semibold25);
		
		JLabel q1Label = new JLabel("Current $ in Bank");
		q1Label.setFont(FontClass.medium20);
		
		// https://www.youtube.com/watch?v=1HyMztaV4ME
		q1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
			    char vChar = e.getKeyChar();
			    if (q1.getText().equals(""))
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
			}
		});
		
		q1.setEditable(true);
		q1.setFont(FontClass.medium20);
		
		JLabel q2Label = new JLabel("$ Willing to Spend");
		q2Label.setFont(FontClass.medium20);
		
		q2.setEditable(true);
		q2.setFont(FontClass.medium20);
		q2.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
			    char vChar = e.getKeyChar();
			    if (q2.getText().equals(""))
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
			}
		});
		
		JLabel q3Label = new JLabel("What's your monthly wage?");
		q3Label.setFont(FontClass.medium20);
		
		// dropdown where user can select an option
		q3.setSelectedItem(null);
		q3.setFont(FontClass.medium20);
		q3.setBackground(new Color (255,255,255));
		
		JLabel q4Label = new JLabel("How will you pay for your tuition?");
		q4Label.setFont(FontClass.medium20);
		
		// https://www.javatpoint.com/java-jcheckbox
		q4ans1.setFont(FontClass.regular16);
		q4ans1.setFocusable(false);
		
		q4ans2.setFont(FontClass.regular16);
		
		q4ans3.setFont(FontClass.regular16);
		
		q4ans4.setFont(FontClass.regular16);
		
		JLabel otherLabel = new JLabel("Other");
		otherLabel.setFont(FontClass.semibold25);
		
		JLabel q5Label = new JLabel("What will you do after Highschool?");
		q5Label.setFont(FontClass.medium20);
		
		q5.setSelectedItem(null);
		q5.setFont(FontClass.medium20);
		q5.setBackground(new Color (255,255,255));
		
		JLabel q6Label = new JLabel("How many hours do you work weekly?");
		q6Label.setFont(FontClass.medium20);
		
		q6.setEditable(true);
		q6.setFont(FontClass.medium20);
		q6.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c)) {
					e.consume();
				} 
			}
		});
		
		JLabel gr11Title = new JLabel("Grade 11 Marks:");
		gr11Title.setFont(FontClass.semibold25);
		
		JLabel gr12Title = new JLabel("Grade 12 Marks:");
		gr12Title.setFont(FontClass.semibold25);
		
		marksGUIsPanel = new MarksPanelGUIs();
		
		this.setBackground(new Color(243, 244, 245));
		this.setSize(1255,1850);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(55)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(finance, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
						.addComponent(q1Label, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent(q1, GroupLayout.PREFERRED_SIZE, 415, GroupLayout.PREFERRED_SIZE))
					.addGap(70)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(160)
							.addComponent(q2, GroupLayout.PREFERRED_SIZE, 415, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(160)
							.addComponent(q2Label, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
						.addComponent(mainTitle, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(55)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(q3Label, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
						.addComponent(q3, GroupLayout.PREFERRED_SIZE, 415, GroupLayout.PREFERRED_SIZE))
					.addGap(230)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(230)
							.addComponent(q4ans2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addComponent(q4ans1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(q4Label, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(q4ans3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addGap(210)
							.addComponent(q4ans4, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(55)
					.addComponent(otherLabel, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(55)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(q5Label, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
						.addComponent(q5, GroupLayout.PREFERRED_SIZE, 415, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(q6, GroupLayout.PREFERRED_SIZE, 415, GroupLayout.PREFERRED_SIZE)
						.addComponent(q6Label, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(55)
					.addComponent(gr11Title, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
					.addGap(345)
					.addComponent(gr12Title, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(55)
					.addComponent(marksGUIsPanel, GroupLayout.PREFERRED_SIZE, 1145, GroupLayout.PREFERRED_SIZE))

		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(140)
							.addComponent(finance, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addGap(15)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(q1Label, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(30)
									.addComponent(q1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(220)
							.addComponent(q2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(190)
							.addComponent(q2Label, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addComponent(mainTitle, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(q3Label, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(30)
							.addComponent(q3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(30)
									.addComponent(q4ans2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(30)
									.addComponent(q4ans1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
								.addComponent(q4Label, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(q4ans3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(q4ans4, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))))
					.addGap(50)
					.addComponent(otherLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(q5Label, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(30)
							.addComponent(q5, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(30)
							.addComponent(q6, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addComponent(q6Label, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(gr11Title, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(gr12Title, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(15)
					// will make it where the size will grow up to 1100
					.addComponent(marksGUIsPanel, GroupLayout.PREFERRED_SIZE, 1100, GroupLayout.PREFERRED_SIZE)
		));
		setLayout(groupLayout);
		this.setVisible(true);
	
	}

	public MarksPanelGUIs getMarksGUIsPanel() {
		return marksGUIsPanel;
	}

	public void setMarksGUIsPanel(MarksPanelGUIs marksGUIsPanel) {
		this.marksGUIsPanel = marksGUIsPanel;
	}

	public JTextField getQ1() {
		return q1;
	}

	public void setQ1(JTextField q1) {
		this.q1 = q1;
	}

	public JTextField getQ2() {
		return q2;
	}

	public void setQ2(JTextField q2) {
		this.q2 = q2;
	}

	public String[] getMonthlyWage() {
		return monthlyWage;
	}

	public void setMonthlyWage(String[] monthlyWage) {
		this.monthlyWage = monthlyWage;
	}

	public JComboBox getQ3() {
		return q3;
	}

	public void setQ3(JComboBox q3) {
		this.q3 = q3;
	}

	public JCheckBox getQ4ans1() {
		return q4ans1;
	}

	public void setQ4ans1(JCheckBox q4ans1) {
		this.q4ans1 = q4ans1;
	}

	public JCheckBox getQ4ans2() {
		return q4ans2;
	}

	public void setQ4ans2(JCheckBox q4ans2) {
		this.q4ans2 = q4ans2;
	}

	public JCheckBox getQ4ans3() {
		return q4ans3;
	}

	public void setQ4ans3(JCheckBox q4ans3) {
		this.q4ans3 = q4ans3;
	}

	public JCheckBox getQ4ans4() {
		return q4ans4;
	}

	public void setQ4ans4(JCheckBox q4ans4) {
		this.q4ans4 = q4ans4;
	}

	public String[] getAfterHS() {
		return afterHS;
	}

	public void setAfterHS(String[] afterHS) {
		this.afterHS = afterHS;
	}

	public JComboBox getQ5() {
		return q5;
	}

	public void setQ5(JComboBox q5) {
		this.q5 = q5;
	}

	public JTextField getQ6() {
		return q6;
	}

	public void setQ6(JTextField q6) {
		this.q6 = q6;
	}
}
