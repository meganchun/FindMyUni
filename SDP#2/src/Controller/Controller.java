package Controller;

public class Controller {

	Survey survey;
	Results results;
	
	public Controller() {
		survey = new Survey(this);
		getSurvey().createSurvey();
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public Results getResults() {
		return results;
	}

	public void setResults(Results results) {
		this.results = results;
	}
	
}
