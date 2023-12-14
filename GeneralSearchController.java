	package controller;
	
	
	//File editing and reading
	//https://stackoverflow.com/questions/73788807/check-if-string-exists-in-text-file
	//https://www.beginwithjava.com/java/file-input-output/writing-text-file.html#:~:text=The%20simplest%20way%20to%20write,oceans%20to%20the%20text%20file.
	//https://www.tutorialspoint.com/how-to-delete-a-string-inside-a-file-txt-in-java
	
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.PrintWriter;
	import java.util.Arrays;
	import java.util.Comparator;
	import java.util.Scanner;
	
	import javax.swing.ImageIcon;
	
	import model.MoreInfoProgram;
	import model.MoreInfoUniversity;
	import model.ProgramPanel;
	import model.User;
	import view.GeneralSearchFrame;
	import view.SortByFrame;
	
	public class GeneralSearchController implements ActionListener {
			
		private GeneralSearchFrame frame = new GeneralSearchFrame();
		
		public GeneralSearchController(User user) {
			
			//Method to add action listeners to all the GUI swing objects:
			addActionListeners();
			
			readUsersProfile();
					
		}
	
		private void addActionListeners() {
			
			//Add action listeners to the filter button, sort options, and the search bar
			getFrame().getFilterButton().addActionListener(this);
			getFrame().getSortOptions().addActionListener(this);
			getFrame().getSearchButton().addActionListener(this);
			
			
			
			//Add action listeners to all the program panels.
			for(int i = 0; i < getFrame().getImportedPrograms().getProgramArray().size(); i++) {
				
				ProgramPanel currentProgram = getFrame().getPrograms()[i];
				
				currentProgram.getFavouriteButton().addActionListener(this);
				currentProgram.getUniversityName().addActionListener(this);
				currentProgram.getProgramName().addActionListener(this);
						}
			
		}
		
		public boolean checkProgram(String check) throws FileNotFoundException {
			
			
		    BufferedReader reader = new BufferedReader(new FileReader("data/hi"));
		    Scanner fileScanner = new Scanner(reader);
		 
		    boolean flag = false;
		    
		    //Continue reading whule the file has lines:
		    while (fileScanner.hasNextLine()) {
		    	
		    	fileScanner.useDelimiter("\r\n");
		 
		        String line = fileScanner.next();
		        
		        //If the current line has the program, set the flag to true and break out of the loop
		        if (line.contains(check)) {
		            flag = true;
		            break;
		        }
		        else {
		        	flag = false;
		        }
		    }
		    	    
		    return flag;
	
		}
		
	
		private void rewriteUsersProfile(String program) {
							
			try {
				
				//Check if the program already exists in the user's profile.
				
				
				//If it doesn't:
				if(!checkProgram(program)) {
				
					//Add the new program to the user's profile
					try {
						
						FileWriter fw = new FileWriter("data/hi",true);
						PrintWriter out = new PrintWriter(fw);
				        out.println(program);
				        out.close();
				       
						
						
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				//If it already exists, remove it.
				} else {
										
					try {
						
						 String filePath = "data/hi";
					      String result = fileToString(filePath);
					      System.out.println("Contents of the file: "+result);
					      //Replacing the word with desired one
					      result = result.replaceAll("\b" + program + "\b", "");
					      //Rewriting the contents of the file
					      PrintWriter writer = new PrintWriter(new File(filePath));
					      writer.append(result);
					      writer.flush();
	
	
	
						
						
					} catch (IOException e) {
						e.printStackTrace();
					}
	
	
					System.out.println("already exists");
					
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
		}
	
		private String fileToString(String filePath) throws FileNotFoundException {
			 String input = null;
		      Scanner sc = new Scanner(new File(filePath));
		      StringBuffer sb = new StringBuffer();
		      while (sc.hasNextLine()) {
		         input = sc.nextLine();
		         sb.append(input);
		      }
		      return sb.toString();
		}

		private void readUsersProfile() {
			
			
			String ignore = "";
			String hi = "";
			
			try {
	
				Scanner accountsFile = new Scanner(new File("data/accounts.txt"));
				
				accountsFile.useDelimiter(",|\r\n");
													
				// Iterate through all programs 
				for (int i = 0; i < 1; i++) {
					
					for(int f = 0; f < 9; f++) {
					ignore = accountsFile.next();
		
					}
					
					hi = accountsFile.next();
									
			
				}			
				
				System.out.println(hi);
				
			} catch (FileNotFoundException e) { // for errors or if there is no input
				System.out.println("File Error");
			}
			
		}
	
		@Override
		public void actionPerformed(ActionEvent event) {
	
			
			if(event.getSource() == getFrame().getFilterButton()) {
				
				new SortByFrame(this);
									
				
			}
			else if(event.getSource() == getFrame().getSearchButton()) {
				
				updateFrame();
				
			}
			
			
			else if(event.getSource() == getFrame().getSortOptions()) {
				
				String sortByOption = (String)getFrame().getSortOptions().getSelectedItem();
				
				if (sortByOption == "Programs (A-Z)") {
								
					Arrays.sort(getFrame().getPrograms(), Comparator.comparing(ProgramPanel::getProgName));
					
					updateFrame();
					
					
				
								
				}
				
				else if (sortByOption == "University (A-Z)") {
									
					Arrays.sort(getFrame().getPrograms(), Comparator.comparing(ProgramPanel::getUniName));
					
					updateFrame();
					
				
				}
				
				else if (sortByOption == "Grade Range (Low - High)") {
					
					Arrays.sort(getFrame().getPrograms(), Comparator.comparing(ProgramPanel::getGrade));
					
					updateFrame();
				}
	
			}
			
			//Handles any button click for a particular program.
			for(int i = 0; i < getFrame().getPrograms().length; i++) {
				
				
				ProgramPanel currentProgram = getFrame().getPrograms()[i];			
				
				
				//Checks if the favourite button was clicked:
				if (event.getSource() == currentProgram.getFavouriteButton()) {
					
					//Switch the state of the favourite option if it's clicked (true -> false, false -> true)
					currentProgram.setFavourite(!currentProgram.isFavourite());
					
					//Update the icon
					currentProgram.getFavouriteButton().setIcon(new ImageIcon("images/favourite" + currentProgram.isFavourite() + ".png"));
				
					
					//Add the program to the user's profile.
						
					rewriteUsersProfile(currentProgram.getProgName());
					
					
				}
				//Checks if the university name was clicked
				else if(event.getSource() == currentProgram.getUniversityName()) 
					
					new MoreInfoUniversity(getFrame().getPrograms()[i].getProgram());
									
		
				//Check if the program name was clicked
				else if(event.getSource() == currentProgram.getProgramName()) 
					
					new MoreInfoProgram(getFrame().getPrograms()[i].getProgram());				
					
				
			}
			
		}
	
		private void updateFrame() {
			
			//Remove all programs
			getFrame().getProgramsPanel().removeAll();
			
			//Get the text that's contained in the search field
			String search = getFrame().getSearchField().getText();
					
			//Check for all programs if they contain the text from the search field
			for(int i = 0; i < getFrame().getPrograms().length; i++) 
			
				//If either the program name or university matches what's in the search field, add that program to the panel
				if (getFrame().getPrograms()[i].getProgName().toLowerCase().contains(search.toLowerCase()) || 
						getFrame().getPrograms()[i].getUniName().toLowerCase().contains(search.toLowerCase())) 
					
					getFrame().getProgramsPanel().add(getFrame().getPrograms()[i]);	
					
				
			
			
			//Refresh the frame
			getFrame().repaint();
			getFrame().revalidate();
				
			
			
		}
	
		public GeneralSearchFrame getFrame() {
			return frame;
		}
	
		public void setFrame(GeneralSearchFrame frame) {
			this.frame = frame;
		}
		
	
	
	}
