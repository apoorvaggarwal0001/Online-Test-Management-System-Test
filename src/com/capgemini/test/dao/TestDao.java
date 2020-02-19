package com.capgemini.test.dao;

import java.sql.SQLException;
import java.time.LocalTime;
import java.util.HashMap;

import com.capgemini.Questions.dto.Question;
import com.capgemini.test.dto.Test;

public interface TestDao {
	public HashMap<Integer, Test> getAllTests() throws SQLException;
	public Question SearchQuestion(int questionId) throws SQLException;
	public boolean AddTestQuestion(Question question) throws SQLException;
	public boolean RemoveTestQuestion(int questionId) throws SQLException;
	public boolean AddTest(Test test) throws SQLException;
	//public float calculateTotalMarks(Test test);
}
