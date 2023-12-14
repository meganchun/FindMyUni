package Controller;
import View.*;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JComboBox;

import Model.*;

public class Results {
	
	Survey survey;
	Controller controller;
	SurveyGUIFrame surveyGUI;
	ResultsGUIFrame resultsGUI;

	public Results(Survey survey) {
		this.survey = survey;
	}

	public void createResults() {
		resultsGUI = new ResultsGUIFrame();
		ActionListenersResults();
	}
	
	public void ActionListenersResults() {
		

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
