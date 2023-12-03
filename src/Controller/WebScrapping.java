package Controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.HttpStatusException;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class WebScrapping {

	
	public static List<String[]> uniInfo = new ArrayList<String[]>();
	
	public WebScrapping() throws HttpStatusException, IOException {
		
	
	}
	

	public static void getData() throws IOException, HttpStatusException {


		for (int num = 250; num <= 750; num++) {

			try {

				String url = "https://www.ontariouniversitiesinfo.ca/programs/" + num;
				
				Document doc = Jsoup.connect(url).get();

				Elements dtTitle = doc.select("dt");
				Elements ddInfo = doc.select("dd");
				
				//get the div with the class name: template-heading (program name)
				Element programClass = doc.getElementsByClass("template-heading").first(); 
			
				//set counter to only get the program name once
				int numProgram = 1;
				
				String programName = null;
				String universityName = null;
				String gradeRange = null;
				String degree = null;
				
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
					
					//Get the grade range
					if (dt.contains("Grade Range")) {
 		
						gradeRange = removeTags(ddInfo.get(index)); //remove the tags
					}
					
					//Get the degree
					if (dt.contains("Degree")) {
						
						String fullText = ddInfo.get(index).toString(); //full text with tags
						
						degree = fullText.substring(fullText.indexOf("n>") + 2, fullText.indexOf("</span>")); //remove the tags
					}
					
					//get the program number if it is the first one that appears
					if (numProgram == 1)  {
						programName = programClass.text();
					}
					
					numProgram = 2; //change the number of program name appears
	
				}
				
				//ADD TO ENGINEERING FILE
				if (programName.indexOf("Engineering") != -1) {
					String[] info = {programName, universityName, gradeRange, degree}; 
					uniInfo.add(info);
				}
					
				//ADD TO COMPUTER SCIENCE FILE
				if (programName.indexOf("Computer Science") != -1) {
					String[] info = {programName, universityName, gradeRange, degree}; 
					uniInfo.add(info);
				}
				//ADD TO MATH FILE
				else if (degree.indexOf("Mathematics") != -1) {
					String[] info = {programName, universityName, gradeRange, degree}; 
					uniInfo.add(info);
				}
				
				
				//ADD TO SCIENCE FILE
				if (degree.indexOf("Science") != -1) {
					String[] info = {programName, universityName, gradeRange, degree}; 
					uniInfo.add(info);
				}
				
				
				//store the information into a string array {program name, university name, grade range}
			
				
				
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
		
		getData();
	}



}