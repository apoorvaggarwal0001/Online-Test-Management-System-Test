package com.capgemini.Questions.dao;

import java.sql.SQLException;
import java.util.HashMap;

import com.capgemini.Questions.dto.Question;

public interface QuestionDao {
	public HashMap<Integer, Question> getAllQuestions() throws SQLException;
	boolean addQuestion(Question question) throws SQLException;
	boolean deleteQuestion(Question question) throws SQLException;
	Question searchQuestion(int questionId) throws SQLException;
	boolean updateQuestion(int questionId) throws SQLException;
}
	