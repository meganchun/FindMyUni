/*
 * 
 * External Sources:
 * - https://stackoverflow.com/questions/30408174/jsoup-how-to-get-href (get href link)
 */
package controller;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.HttpStatusException;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import model.User;


public class WebScrapping {

	//Initialize a list of eng, math, comp sci and science program list 
	public static List<String[]> engPrograms = new ArrayList<String[]>();
	public static List<String[]> mathPrograms = new ArrayList<String[]>();
	public static List<String[]> compSciPrograms = new ArrayList<String[]>();
	public static List<String[]> sciPrograms = new ArrayList<String[]>();
	
	public final static String[] UNIVERSITIES = {"Brock","Guelph","McMaster","OCAD","Ontario Tech",
			"Queen's","Ryerson","Waterloo","Western","Laurier","Windsor","York"};
	
	public WebScrapping() throws HttpStatusException, IOException {
		
		getData();
		
		/*
		addToFile("data/compSciPrograms.txt", compSciPrograms);
		addToFile("data/engPrograms.txt", engPrograms);
		addToFile("data/mathPrograms.txt", mathPrograms);
		addToFile("data/sciencePrograms.txt", sciPrograms);
		
*/
	}
	

	public static void getData() throws IOException, HttpStatusException {


		for (int num = 300; num <= 500; num++) {

			try {

				String url = "https://www.ontariouniversitiesinfo.ca/programs/" + num;
				
				Document doc = Jsoup.connect(url).get();

				Elements dtTitle = doc.select("dt");
				Elements ddInfo = doc.select("dd");
				
				//get the div with the class name: template-heading 
				Element programClass = doc.getElementsByClass("template-heading").first(); 
				
				//get the div with the class name: tabbed-subsection-summary
				Element addressClass = doc.getElementsByClass("tabbed-subsection-summary").first(); 
				
				//get the link to the university program with the class name: program-apply offsite-noicon
				Element linkClass = doc.getElementsByClass("program-apply offsite-noicon").first(); 
			
				//attributes for each program
				String programName = null;
				String universityName = null;
				String gradeRange = null;
				String degree = null;
				
				String address = null;
				String programLink = null;
				List<String> prerequisites = null;
				double cost = 0;
				
				//set counter to only get the program name once
				int numProgram = 1;
				
				
				for (int index = 0; index < dtTitle.size(); index++) {
			
					String dt = dtTitle.get(index).toString();	

					//get the university name
					if (dt.contains("University")) {
				 	
						universityName = removeTags(ddInfo.get(index)); //remove the tags
					}
					
					//Get the grade range
					if (dt.contains("Grade Range")) {
 		
						gradeRange = removeTags(ddInfo.get(index)); //remove the tags
					}
					
				
					//Get the degree
					if (dt.contains("Degree")) {
						
						String fullText = ddInfo.get(index).toString(); //full text with tags
						degree = fullText.substring(fullText.indexOf("n>") + 2, fullText.indexOf("</span>")); //remove the tags
					}
					
					//get the program name
					programName = programClass.text();
					
					//Get the program link
					programLink = linkClass.attr("href");
					
					//get the address
					address = addressClass.text().substring(0, addressClass.text().indexOf(" Email")); //get only the string of the address not the email
	
				}
				
				//create a signal variable to flag when there is a valid university
				boolean validUni = false;
				
				//check to see if the program searched is at a university in Southern Ontario
				for (int i = 0; i < UNIVERSITIES.length; i++) {
					
					//if the university contains any of the university list
					if (universityName.contains(UNIVERSITIES[i])) {
						validUni = true;
						break;
					}
				}
				
				if (validUni) {
					
					//ADD TO ENGINEERING FILE
					if (programName.indexOf("Engineering") != -1) {
						
						//store the information into a string array {program name, university name, grade range}
						String[] info = {programName, universityName, gradeRange, degree}; 
						engPrograms.add(info);
					}
					 //ADD TO SCIENCE FILE
					else if (degree.indexOf("Science") != -1) {
						//store the information into a string array {program name, university name, grade range}
						String[] info = {programName, universityName, gradeRange, degree}; 
						sciPrograms.add(info);
					}
						
					//ADD TO COMPUTER SCIENCE FILE
					if (programName.indexOf("Computer Science") != -1) {
						
						//store the information into a string array {program name, university name, grade range}
						String[] info = {programName, universityName, gradeRange, degree}; 
						compSciPrograms.add(info);
					}
					//ADD TO MATH FILE
					else if (degree.indexOf("Mathematics") != -1) {
						
						//store the information into a string array {program name, university name, grade range}
						String[] info = {programName, universityName, gradeRange, degree}; 
						mathPrograms.add(info);
					}
				
				}
				
				
			} catch (HttpStatusException e1) {


			} catch (IOException e){}
		}
	}


	public static String removeTags(Element ddInfo) {
		
		//Initialize variables to remove <dt> and <dd>
		String croppedString  = "";
		int newLine = 0;

		//Initialize a counter to remove unnesscary new line and space
		int numberOnNewLine = 0;
		
		//loop through the length of the whole sting including the tags
		for (int ch = 0; ch < ddInfo.toString().length(); ch++ )  {
			//if the character is a new line, increment the line counter
			if (ddInfo.toString().charAt(ch) == '\n') {
				newLine++;
			}
			
			//only if it is on the 2nd line, add to the new string
			if (newLine == 1) {
				
				//increment the number of characters on the new line
				numberOnNewLine++;
				
				//if the number of the character of the new line is greater than 2...
				//add to the range only st
				if (numberOnNewLine > 2)
					croppedString += ddInfo.toString().charAt(ch);
			}
		}
		//return the cropped string
		return croppedString;
	}

	
	public static void main(String[] args) throws HttpStatusException, IOException {
		
		new WebScrapping();
		
		
	}
	
	public void addToFile(String fileName, List<String[]> programList) {
		
		FileWriter fr = null;
		try {
			fr = new FileWriter(fileName, true);
			
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		BufferedWriter br = new BufferedWriter(fr);
		try {
			
			
			//loop through all the programs for each field
			for (int i = 0; i < programList.size(); i++) {
				
				//loop through the different number of data types for each program
				for (int j = 0; j < programList.get(i).length; j++) {
		
					//append to the text file
					br.write(programList.get(i)[j]);
					
					//if it is not on the last data, add a comma to separate the data
					if (j != programList.get(i).length-1)
						br.write(",");
					else 
						br.write("\n");
				}
			}
			
			br.close();
			fr.close();
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}



}