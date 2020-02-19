package com.capgemini.Questions.dao;

import java.sql.*;
import java.util.HashMap;
import java.util.Scanner;

import com.capgemini.Questions.dto.Question;

public class QuestionDaoImpl implements QuestionDao{
	Connection connection;
	Statement st;
	ResultSet rs;
	PreparedStatement pst;

	HashMap<Integer, Question> questionMap;
	
	Question question;

	public QuestionDaoImpl() throws SQLException {
		connection = QuestionDB.myconnection();
		connection.setAutoCommit(false); // db changes will not be automatically saved!
	}

	@Override
	public HashMap<Integer, Question> getAllQuestions() throws SQLException {
		st = connection.createStatement();
		rs = st.executeQuery("select * from question1");
		questionMap = new HashMap<>();
		while (rs.next()) {
			question = null;
			question = new Question();
			
			question.setQuestionId(rs.getInt(1));
			question.setQuestionTitle(rs.getString(2));
			question.setQuestionAnswer(rs.getInt(3));
			question.setQuestionMarks(rs.getInt(4));

			questionMap.put(rs.getInt(1), question);
		}
		return questionMap;
		
	}
		
	Scanner input = new Scanner(System.in);
	String ch;

	@Override
	public boolean addQuestion(Question question1) throws SQLException {
		question = searchQuestion(question1.getQuestionId());
		if (question == null) {
			pst = null;
			
			pst=connection.prepareStatement("insert into Question1 values(?,?,?,?)");
			pst.setInt(1, question1.getQuestionId());
			pst.setString(2, question1.getQuestionTitle());
			pst.setInt(3, question1.getQuestionAnswer());
			pst.setFloat(4, question1.getQuestionMarks());

			int res = pst.executeUpdate();
			if (res == 1) {
				System.out.println("Commit (y/n):");
				ch = input.next();
				if (ch.equalsIgnoreCase("y"))
					connection.commit();
				else
					connection.rollback();
				return true;
			} else
				return false;

		}
		return false;
	}
	@Override
	public Question searchQuestion(int questionId) throws SQLException {
		pst = connection.prepareStatement("select*from Question1 where questionId=?");
		pst.setInt(1, questionId);
		rs = null;
		rs = pst.executeQuery();
		if (rs.next()) {
			question = null;
			question = new Question();
			question.setQuestionId(rs.getInt(1));
			question.setQuestionTitle(rs.getString(2));
			question.setQuestionMarks(rs.getFloat(3));
			question.setQuestionAnswer(rs.getInt(4));
		}
		return null;
	}
	
	@Override
	public boolean deleteQuestion(Question question1) throws SQLException {
		question = searchQuestion(question1.getQuestionId());
		if (question == null) {
			pst = null;
			pst=connection.prepareStatement("delete from Question1 where questionid=?");
			pst.setInt(1, question1.getQuestionId());
			int res = pst.executeUpdate();
			if (res == 1) {
				System.out.println("Commit (y/n):");
				ch = input.next();
				if (ch.equalsIgnoreCase("y"))
					connection.commit();
				else
					connection.rollback();
				return true;
			} else
				return false;
		}
		return false;
	}
	
	
	@Override
	public boolean updateQuestion(int questionId) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}	

}
