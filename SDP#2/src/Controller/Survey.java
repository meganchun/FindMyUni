package Controller;
import View.*;
import model.FileReader;
import model.ProgramPanel;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JComboBox;

import Model.*;

public class Survey {

	Controller controller;
	Results results;
	SurveyGUIFrame surveyGUI;
	ResultsGUIFrame resultsGUI;
	
	ArrayList<String> programs1 = new ArrayList<String>();
	
	FileReader importedPrograms = new FileReader();
	
	ProgramPanel[] programs = new ProgramPanel[importedPrograms.getProgramArray().size()];
	
	ProgramPanel bestPrograms;
	
	double weightedAverage;

	public Survey(Controller controller) {
		this.controller = controller;
		results = new Results(this);
//		double str1 = Double.parseDouble(surveyGUI.getSurveyGUIPanel().getMarksGUIsPanel().getGr11Marks()[1].getGr11MarkPercent().getText());
		
	}
	
	public void createSurvey() {
		surveyGUI = new SurveyGUIFrame();
		ActionListenersSurvey();
	}
	
	public void ActionListenersSurvey() {
		
    	surveyGUI.getSurveyGUIPanel().getMarksGUIsPanel().getSubmitButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				getSurveyGUI().dispose();
				calculateBestPrograms();
				getResults().createResults();
//				getController().createResults();
				
//				getController().createGame();
			}
    		
    	});
	}
	
	public int calculateBestPrograms() {
		
		int programNum = 0;
		
		for(int i = 0; i < importedPrograms.getProgramArray().size(); i++ ) {
			
			ProgramPanel currentProgram = programs[i];
			
			currentProgram  = new ProgramPanel(importedPrograms.getProgramArray().get(i).getName(),
					importedPrograms.getProgramArray().get(i).getUniversity(),
					false, 
					importedPrograms.getProgramArray().get(i),
					importedPrograms.getProgramArray().get(i).getGradeRequirement());
			
			Double reqGrade = Double.valueOf(importedPrograms.getProgramArray().get(i).getGradeRequirement());
			
			programNum++;
			
			// if the required grade of a program is less or equal to the user's average
			// and if the program falls under the user's preferred field
			// it will find the best out of those options / or maybe just take them all
			// and return the programNum to be used in the gui
			if (reqGrade <= getWeightedAverage() ) {
				
			}
			else {
				
			}
		}
		
		// will return the program # of the best program
		return programNum;
		
	}
	
	public double getWeightedAverage() {
		int totalGr11Courses = 0;
		double totalGr11Marks = 0;
		
		int totalGr12Courses = 0;
		double totalGr12Marks = 0;
		
		for (int i = 0; i < surveyGUI.getSurveyGUIPanel().getMarksGUIsPanel().getGr11Marks().length; i++) {	
			String currentGr11Course = (String) surveyGUI.getSurveyGUIPanel().getMarksGUIsPanel().getGr11Marks()[i].getCourseDropdown().getSelectedItem();		
			if (currentGr11Course != null) {
				programs1.add(currentGr11Course);
				totalGr11Courses++;
			}		
			
			String currentGr11Mark = surveyGUI.getSurveyGUIPanel().getMarksGUIsPanel().getGr11Marks()[i].getGr11MarkPercent().getText();
			if (!currentGr11Mark.isEmpty()) {
				Double calculation = Double.valueOf(currentGr11Mark);
				totalGr11Marks+=calculation;
			}
		}
		
		for (int i = 0; i < surveyGUI.getSurveyGUIPanel().getMarksGUIsPanel().getGr12Marks().length; i++) {	
			String currentGr12Course = (String) surveyGUI.getSurveyGUIPanel().getMarksGUIsPanel().getGr12Marks()[i].getCourseDropdown().getSelectedItem();
			
			if (currentGr12Course != null) {
				totalGr12Courses++;
			}		
			
			String currentGr12Mark = surveyGUI.getSurveyGUIPanel().getMarksGUIsPanel().getGr12Marks()[i].getGr11MarkPercent().getText();
			
			if (!currentGr12Mark.isEmpty()) {
				Double calculation = Double.valueOf(currentGr12Mark);
				totalGr12Marks+=calculation;
			}
		}
		
		double gr11Avg = totalGr11Marks / totalGr11Courses;
		System.out.println(gr11Avg);
		
		double gr12Avg = totalGr12Marks / totalGr12Courses;
		System.out.println(gr12Avg);
		
		weightedAverage = (gr11Avg*0.3 + gr12Avg*0.7);
		System.out.println(weightedAverage);
		return weightedAverage;
	}
	
	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public Results getResults() {
		return results;
	}

	public void setResults(Results results) {
		this.results = results;
	}

	public SurveyGUIFrame getSurveyGUI() {
		return surveyGUI;
	}

	public void setSurveyGUI(SurveyGUIFrame surveyGUI) {
		this.surveyGUI = surveyGUI;
	}

	public ResultsGUIFrame getResultsGUI() {
		return resultsGUI;
	}

	public void setResultsGUI(ResultsGUIFrame resultsGUI) {
		this.resultsGUI = resultsGUI;
	}

}
