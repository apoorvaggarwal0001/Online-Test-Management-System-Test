package com.capgemini.Questions.dto;

public class Question extends Test{
	int questionId;		
	String questionOption[];
	String questionTitle;	
	int questionAnswer;
	float questionMarks;
	int chosenAnswer;
	float marksScored;
	public int getQuestionId() {
		return questionId;
	}
	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionTitle=" + questionTitle + ", questionAnswer="
				+ questionAnswer + ", questionMarks=" + questionMarks + "]";
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String[] getQuestionOption() {
		return questionOption;
	}
	public void setQuestionOption(String[] questionOption) {
		this.questionOption = questionOption;
	}
	public String getQuestionTitle() {
		return questionTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	public int getQuestionAnswer() {
		return questionAnswer;
	}
	public void setQuestionAnswer(int questionAnswer) {
		this.questionAnswer = questionAnswer;
	}
	public float getQuestionMarks() {
		return questionMarks;
	}
	public void setQuestionMarks(float questionMarks) {
		this.questionMarks = questionMarks;
	}
	public int getChosenAnswer() {
		return chosenAnswer;
	}
	public void setChosenAnswer(int chosenAnswer) {
		this.chosenAnswer = chosenAnswer;
	}
	public float getMarksScored() {
		return marksScored;
	}
	public void setMarksScored(float marksScored) {
		this.marksScored = marksScored;
	}

	public Question(int questionId, String[] questionOption, String questionTitle, int questionAnswer,
			float questionMarks, int chosenAnswer) {
		super();
		this.questionId = questionId;
		this.questionOption = questionOption;
		this.questionTitle = questionTitle;
		this.questionAnswer = questionAnswer;
		this.questionMarks = questionMarks;
		this.chosenAnswer = chosenAnswer;
	}
	public Question() {
		// TODO Auto-generated constructor stub
	}
	
}
