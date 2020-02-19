package com.capgemini.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.HashMap;

import com.capgemini.Questions.dto.Question;
import com.capgemini.test.dto.Test;
import com.capgemini.test.util.DatabaseUtil;

public class TestDaoImpl implements TestDao{
	Connection connection;
	Statement st;
	ResultSet rs;
	PreparedStatement pst;
	Test test;
	Question question;

	HashMap<Integer, Test>hashMap;
	
	public TestDaoImpl() throws SQLException{
		connection=DatabaseUtil.myConnection();
	}
	
	@Override
	public HashMap<Integer, Test> getAllTests() throws SQLException {
		st=connection.createStatement();
		rs=st.executeQuery("select * from test");
		hashMap=new HashMap<>();
		while(rs.next()) {
			test=null;
			test=new Test();
			test.setTestId(rs.getInt(1));
			test.setTestTitle(rs.getString(2));
			test.setTestDuration(rs.getInt(3));
			test.setTestTotalMarks(rs.getInt(4));
			test.setTestMarksScored(rs.getInt(5));
			hashMap.put(rs.getInt(1), test);
			//System.out.println(hashMap);
		}
		return hashMap;
	}
	
	@Override
	public Question SearchQuestion(int questionId) throws SQLException {
		pst=connection.prepareStatement("select * from question where questionId=?");
		pst.setInt(1, questionId);
			rs=null;
			rs=pst.executeQuery();
			if(rs.next()) {
				question=null;
				question=new  Question();
				
				question.setQuestionId(rs.getInt(1));
				question.setQuestionTitle(rs.getString(2));
				question.setQuestionAnswer(rs.getInt(3));
				question.setQuestionMarks(rs.getFloat(4));
				question.setChosenAnswer(rs.getInt(5));
				question.setMarksScored(rs.getFloat(6));
			}
			return question;
	}

	@Override
	public boolean AddTestQuestion(Question question1) throws SQLException {
		question=SearchQuestion(question1.getQuestionId());
		if(question==null)
		{
			pst=connection.prepareStatement("insert into test values(?,?,?)");
			pst.setInt(1, question1.getQuestionId());
			pst.setString(2, question1.getQuestionTitle());
			pst.setFloat(4, question1.getQuestionMarks());
			int res=pst.executeUpdate();
			if(res==1)
				return true;
			else
				return false;
		}
		return false;
	}

	@Override
	public boolean RemoveTestQuestion(int questionId) throws SQLException {
		question=SearchQuestion(questionId);
		if(question!=null)
		{
			pst=connection.prepareStatement("delete from test where questionid=?");
			pst.setInt(1, question.getQuestionId());
		}
		return false;
	}

	@Override
	public boolean AddTest(Test test1) throws SQLException {

			pst=connection.prepareStatement("insert into test values(?,?,?,?,?)");
			pst.setInt(1, test1.getTestId());
			pst.setString(2, test1.getTestTitle());
			pst.setInt(3, test1.getTestDuration());
			pst.setInt(4, test1.getTestTotalMarks());
			pst.setInt(5, test1.getTestMarksScored());
			int res=pst.executeUpdate();
			if(res==1)
				return true;
			else
				return false;
	}
}
