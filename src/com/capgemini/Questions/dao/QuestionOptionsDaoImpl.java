package com.capgemini.Questions.dao;

import java.sql.*;
import java.util.HashMap;
import java.util.Scanner;

import com.capgemini.Questions.dto.Question;
import com.capgemini.Questions.dto.QuestionOptions;

public class QuestionOptionsDaoImpl implements QuestionOptionDao {
	Question question;
	Connection connection;
	Statement st;
	ResultSet rs;
	PreparedStatement pst;

	QuestionDao questiondao;
	QuestionOptions questionOptions;
	
	HashMap<Integer,QuestionOptions> optionMap;

	Scanner input = new Scanner(System.in);
	String ch;

	public QuestionOptionsDaoImpl() throws SQLException {
		connection = QuestionDB.myconnection();
		connection.setAutoCommit(false); // db changes will not be automatically saved!
	}

	@Override
	public HashMap<Integer, QuestionOptions> getAllOptions(int questionId) throws SQLException {
		st = connection.createStatement();
		rs = st.executeQuery("select * from questionoptions");
		optionMap=new HashMap<>();
		while (rs.next()) {
			questionOptions = null;
			questionOptions = new QuestionOptions();
			questionOptions.setAns1(rs.getString(2));
			questionOptions.setAns2(rs.getString(3));
			questionOptions.setAns3(rs.getString(4));
			questionOptions.setAns4(rs.getString(5));
			questionOptions.setAns5(rs.getString(6));
			optionMap.put(rs.getInt(1),questionOptions);
		}
		return optionMap;
	}

	@Override
	public boolean addOption(int id1) throws SQLException  {
			pst = null;
			questionOptions=null;
			questionOptions=new QuestionOptions();
			pst = connection.prepareStatement("insert into questionoptions values(?,?,?,?,?,?)");
			pst.setInt(1, id1);
			pst.setString(2, questionOptions.getAns1());
			pst.setString(3, questionOptions.getAns2());
			pst.setString(4, questionOptions.getAns3());
			pst.setString(5, questionOptions.getAns4());
			pst.setString(6, questionOptions.getAns5());

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

	@Override
	public boolean deleteOption(int questionId) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateOption(int questionId) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void viewOption(int id1) throws SQLException {
		pst = connection.prepareStatement("select*from questionoptions where id1=?");
		pst.setInt(1, id1);
		rs = null;
		rs = pst.executeQuery();
		if (rs.next()) {
			questionOptions = null;
			questionOptions = new QuestionOptions();
			questionOptions.setId1(rs.getInt(1));
			questionOptions.setAns1(rs.getString(2));
			questionOptions.setAns2(rs.getString(3));
			questionOptions.setAns3(rs.getString(4));
			questionOptions.setAns4(rs.getString(5));
			questionOptions.setAns5(rs.getString(6));
			
			System.out.println("\n\tOptions. "+"  1. "+rs.getString(2)+"  2. "+rs.getString(3)+"  3. "+rs.getString(4)+"  4. "+rs.getString(5)+"  5. "+rs.getString(6));
		}
		
	}

}
