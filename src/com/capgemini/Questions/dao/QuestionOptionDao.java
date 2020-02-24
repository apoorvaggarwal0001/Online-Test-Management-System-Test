package com.capgemini.Questions.dao;

import java.sql.SQLException;
import java.util.HashMap;

import com.capgemini.Questions.dto.QuestionOptions;

public interface QuestionOptionDao {
	public HashMap<Integer, QuestionOptions> getAllOptions(int questionId) throws SQLException;
	boolean addOption(int id1) throws SQLException;
	boolean deleteOption(int questionId) throws SQLException;
	boolean updateOption(int questionId) throws SQLException; 
	public void viewOption(int id1) throws SQLException;

}
