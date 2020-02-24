package com.capgemini.Questions.service;

import java.sql.SQLException;

import com.capgemini.Questions.dto.Question;
import com.capgemini.Questions.dto.Test;
import com.capgemini.Questions.exception.OptionException;
import com.capgemini.Questions.exception.QuestionException;

public interface QuestionService {
	public void showAllQuestions() throws SQLException;
	//public void showAllOptions() throws SQLException;
	public void addQuestions() throws SQLException, QuestionException;
	public void deleteQuestions() throws SQLException, QuestionException;
	public void updateQuestions() throws SQLException;
	public void deleteOption() throws SQLException;
	void addOption() throws SQLException, OptionException;
	void viewQuestion(int questionId) throws SQLException;
	void viewOption(int id1) throws SQLException;
	void addTestQuestion(Test testId,Question questionId) throws SQLException;

}
