package Model;

import java.util.List;

public class Program {

	//Instance variables
	String name;
	String university;
	String numAddress;
	String city;
	String postalCode;
	String programLink;
	int gradeRequirement;
	List<String> prerequisites;
	double cost;
	
	//Constructor
	public Program(String name, String university, String numAddress, String city, String postalCode,
			String programLink, int gradeRequirement, List<String> prerequisites) {
		super();
		this.name = name;
		this.university = university;
		this.numAddress = numAddress;
		this.city = city;
		this.postalCode = postalCode;
		this.programLink = programLink;
		this.gradeRequirement = gradeRequirement;
		this.prerequisites = prerequisites;
	}

	//GETTERS AND SETTERS
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getNumAddress() {
		return numAddress;
	}

	public void setNumAddress(String numAddress) {
		this.numAddress = numAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getProgramLink() {
		return programLink;
	}

	public void setProgramLink(String programLink) {
		this.programLink = programLink;
	}

	public int getGradeRequirement() {
		return gradeRequirement;
	}

	public void setGradeRequirement(int gradeRequirement) {
		this.gradeRequirement = gradeRequirement;
	}

	public List<String> getPrerequisites() {
		return prerequisites;
	}

	public void setPrerequisites(List<String> prerequisites) {
		this.prerequisites = prerequisites;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
	
	
}
