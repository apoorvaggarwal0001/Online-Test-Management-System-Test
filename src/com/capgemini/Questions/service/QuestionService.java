package com.capgemini.Questions.service;

import java.sql.SQLException;

import com.capgemini.Questions.exception.OptionException;
import com.capgemini.Questions.exception.QuestionException;

public interface QuestionService {
	public void showAllQuestions() throws SQLException;
	public void showAllOptions() throws SQLException;
	public void addQuestions() throws SQLException, QuestionException;
	public void deleteQuestions() throws SQLException, QuestionException;
	public void updateQuestions() throws SQLException;
	public void deleteOption() throws SQLException;
	void addOption(int questionId) throws SQLException, OptionException, OptionException;

}
