package com.capgemini.Questions.dto;

import java.util.HashMap;

public class QuestionOptions extends Question{
	int id1;
	String ans1;
	String ans2;
	String ans3;
	String ans4;
	String ans5;
	
	public QuestionOptions(int questionId, String[] questionOption, String questionTitle, int questionAnswer,
			float questionMarks, int chosenAnswer, int id1, String ans1, String ans2, String ans3, String ans4,
			String ans5) {
		super(questionId, questionOption, questionTitle, questionAnswer, questionMarks, chosenAnswer);
		this.id1 = id1;
		this.ans1 = ans1;
		this.ans2 = ans2;
		this.ans3 = ans3;
		this.ans4 = ans4;
		this.ans5 = ans5;
	}

	@Override
	public String toString() {
		return "Options : 1." + ans1 + ", 2." + ans2 + ", 3." + ans3 + ", 4." + ans4
				+ ", 5." + ans5;
	}

	public QuestionOptions(int questionId, String[] questionOption, String questionTitle, int questionAnswer,
			float questionMarks, int chosenAnswer, int id1) {
		super(questionId, questionOption, questionTitle, questionAnswer, questionMarks, chosenAnswer);
		this.id1 = id1;
	}
	public int getId1() {
		return id1;
	}
	public void setId1(int id1) {
		this.id1 = id1;
	}
	public String getAns1() {
		return ans1;
	}
	public void setAns1(String ans1) {
		this.ans1 = ans1;
	}
	public String getAns2() {
		return ans2;
	}
	public void setAns2(String ans2) {
		this.ans2 = ans2;
	}
	public String getAns3() {
		return ans3;
	}
	public void setAns3(String ans3) {
		this.ans3 = ans3;
	}
	public String getAns4() {
		return ans4;
	}
	public void setAns4(String ans4) {
		this.ans4 = ans4;
	}
	public String getAns5() {
		return ans5;
	}
	public void setAns5(String ans5) {
		this.ans5 = ans5;
	}
	public QuestionOptions() {
	}

}
