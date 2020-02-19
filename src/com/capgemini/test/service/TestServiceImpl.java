package com.capgemini.test.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import com.capgemini.Questions.dto.Question;
import com.capgemini.test.dao.TestDao;
import com.capgemini.test.dao.TestDaoImpl;
import com.capgemini.test.dto.Test;
import com.capgemini.test.exception.TestException;

public class TestServiceImpl implements TestService{
	TestDao testDao;
	Question question;
	HashMap<Integer, Test> hashMap;
	Test test=null;
	Scanner sc=new Scanner(System.in);
	
	int testId;
	String testTitle;
	int testDuration;
	int testTotalMarks;
	int testMarksScored;
	
	public TestServiceImpl() throws SQLException {
		testDao=new TestDaoImpl();
	}
	
	@Override
	public void showAllTests() throws SQLException {
		hashMap=testDao.getAllTests();
		//System.out.println(hashMap);
		Set<Integer> keyset=hashMap.keySet();
		for(Integer integer: keyset) {
			System.out.println(hashMap.get(integer));
		}
	}
	
	@Override
	public void insertTest() throws SQLException, TestException {
		
		System.out.println("<-- Add Test Data -->");
		System.out.println("Enter Test ID: ");
		test=null;
		test=new Test();
		testId=sc.nextInt();
		if(testId<=0)
			throw new TestException("Invalid Test ID (<0)");
		
		System.out.println("Enter Test Title: ");
		sc.nextLine();
		testTitle=sc.nextLine();
		if(testTitle.isEmpty())
			throw new TestException("Test Title is empty");
		
		System.out.println("Enter Test Duration: ");
		testDuration=sc.nextInt();
		if(testDuration<=0)
			throw new TestException("Invalid duration is empty");
		
		System.out.println("Enter Total marks: ");
		testTotalMarks=sc.nextInt();
		if(testTotalMarks<=0)
			throw new TestException("Invalid total marks (<0)");
		
		System.out.println("Enter marks scored: ");
		testMarksScored=sc.nextInt();
		if(testMarksScored<=0)
			throw new TestException("Invalid marks (<0)");
		
		test.setTestId(testId);
		test.setTestTitle(testTitle);
		test.setTestDuration(testDuration);
		test.setTestTotalMarks(testTotalMarks);
		test.setTestMarksScored(testMarksScored);
		
		if(testDao.AddTest(test))
			System.out.println("Test added");
		else
			System.out.println("Test already present");
	}
}
