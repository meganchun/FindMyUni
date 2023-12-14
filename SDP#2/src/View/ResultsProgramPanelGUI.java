package View;

import Model.*;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ResultsProgramPanelGUI extends JPanel {
	
	private FileReader importedPrograms = new FileReader();
	
	private ProgramPanel[] programs = new ProgramPanel[importedPrograms.getProgramArray().size()];
	
	SurveyGUIPanel surveyPanel;
	
	String programName;
	String universityName;
	String grade;
	boolean favourite;
	
	FontClass fonts = new FontClass();
	
	JButton progName = new JButton(programName);
	
	JButton uniName = new JButton(universityName);
	
	JLabel gradeReq = new JLabel("Required: " + grade + "%");
	
	JButton favButton = new JButton(new ImageIcon("Images/favourite" + favourite + ".png"));
	
	JLabel uniImage = new JLabel(new ImageIcon("Images/" + universityName + ".png"));
	
	public ResultsProgramPanelGUI() {
		
		
		
		
		
		this.setLayout(null);
		this.setSize(950,260);
		this.setVisible(true);
	}
	
	private void calculateBestProgram() {
		
		for (int i = 0; i < surveyPanel.getMarksGUIsPanel().getGr11Marks().length; i++) {
			
			String currentCourse = (String) surveyPanel.getMarksGUIsPanel().getGr11Marks()[i].getCourseDropdown().getSelectedItem();
			
			
		}
		
	}
//	
//	private void addBottomPanel() {
//		
//		
//		programsScrollPane.setBounds(100,260,1080,360);
//		programsScrollPane.setBorder(null);
//		
//		programsPanel.setLayout(new BoxLayout(programsPanel, BoxLayout.Y_AXIS));
//					
//		int num = 0;
//			
//		for(int i = 0; i < importedPrograms.getProgramArray().size(); i++ ) {
//						
//			ProgramPanel currentProgram = programs[i];
//						
//			
//			currentProgram = new ProgramPanel(importedPrograms.getProgramArray().get(i).getName(),
//					importedPrograms.getProgramArray().get(i).getUniversity(), false, importedPrograms.getProgramArray().get(i),
//					importedPrograms.getProgramArray().get(i).getGradeRequirement());
//			currentProgram.add(currentProgram.getProgramBackground());
//			
//			currentProgram.getProgramBackground().add(currentProgram.getProgramName());
//			currentProgram.getProgramBackground().add(currentProgram.getUniversityName());
//			currentProgram.getProgramBackground().add(currentProgram.getFavouriteButton());
//			
//			currentProgram.getFavouriteButton().setFocusPainted(false);
//			currentProgram.getFavouriteButton().setContentAreaFilled(false);
//			currentProgram.getFavouriteButton().setBorderPainted(false);
//			
//			currentProgram.getProgramName().setBorderPainted(false);
//			currentProgram.getProgramName().setContentAreaFilled(false);
//			currentProgram.getProgramName().setFocusPainted(false);
//			currentProgram.getProgramName().setHorizontalAlignment(SwingConstants.LEFT);
//			
//			currentProgram.getUniversityName().setBorderPainted(false);
//			currentProgram.getUniversityName().setContentAreaFilled(false);
//			currentProgram.getUniversityName().setFocusPainted(false);
//			currentProgram.getUniversityName().setHorizontalAlignment(SwingConstants.LEFT);
//
//			
//			programs[i] = currentProgram;
//			this.add(currentProgram);
//			
//			num++;
//			
//			
//		}
//			
//		System.out.println(num);
//		
//		
//		programsScrollPane.setViewportView(programsPanel);
//		add(programsScrollPane);
//		
//		whiteSpace.setBounds(100,620,1080,20);
//		add(whiteSpace);
//		
//
//	}

}
