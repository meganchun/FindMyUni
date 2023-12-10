package model;

import java.util.List;

public class Program {

	//Instance variables
	String name;
	String university;
	String address;
	String programLink;
	int gradeRequirement;
	List<String> prerequisites;
	double cost;
	
	//Constructor
	public Program(String name, String university, String address,
			String programLink, int gradeRequirement, List<String> prerequisites) {
		super();
		this.name = name;
		this.university = university;
		this.address = address;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
