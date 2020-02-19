package com.capgemini.Questions.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import com.capgemini.Questions.dao.QuestionDao;
import com.capgemini.Questions.dao.QuestionDaoImpl;
import com.capgemini.Questions.dao.QuestionOptionDao;
import com.capgemini.Questions.dao.QuestionOptionsDaoImpl;
import com.capgemini.Questions.dto.Question;
import com.capgemini.Questions.dto.QuestionOptions;
import com.capgemini.Questions.exception.OptionException;
import com.capgemini.Questions.exception.QuestionException;

public class QuestionServiceImpl implements QuestionService {
	QuestionDao questiondao;
	QuestionOptionDao questionoptiondao;
	HashMap<Integer, Question> questionMap;
	HashMap<Integer, QuestionOptions> optionMap;
	Scanner input = new Scanner(System.in);
	Question question;
	QuestionOptions questionOptions;

	public QuestionServiceImpl() throws SQLException {
		questiondao = new QuestionDaoImpl();
		questionoptiondao = new QuestionOptionsDaoImpl();
	}

	@Override
	public void showAllQuestions() throws SQLException {
		questionMap = questiondao.getAllQuestions();
		Set<Integer> keyset = questionMap.keySet();
		for (Integer i : keyset) {
			System.out.println(questionMap.get(i));
		}
	}

	@Override
	public void showAllOptions() throws SQLException {
		System.out.println("Enter question id to view as a Question-Options: ");
		int questionId=input.nextInt();
		optionMap = questionoptiondao.getAllOptions(questionId);		
		questionoptiondao.getAllOptions(questionId);
		Set<Integer> keyset = optionMap.keySet();
		for (Integer i: keyset ) {
			System.out.println(optionMap.get(i));
		}
		//System.out.println("1."+questionOptions.getAns1()+" 2."+questionOptions.getAns2()+" 3."+questionOptions.getAns3()+" 4."+questionOptions.getAns4()+" 5."+questionOptions.getAns5());

	}

	@Override
	public void addQuestions() throws SQLException, QuestionException {
		question = null;
		question = new Question();
		System.out.println("Enter Question Id");
		int questionId = input.nextInt();
		if (questionId <= 0)
			throw new QuestionException("Invalid Question ID!!");
		else
			question.setQuestionId(questionId);

		System.out.println("Enter Question Title");
		input.nextLine();
		String questionTitle = input.nextLine();
		if (questionTitle.isEmpty())
			throw new QuestionException("Invalid Question Title!!");
		else
			question.setQuestionTitle(questionTitle);

		System.out.println("Enter Question Answer!");
		int questionAnswer = input.nextInt();
		if (questionAnswer <= 0)
			throw new QuestionException("Invalid Question Answer!!");
		else
			question.setQuestionAnswer(questionAnswer);
		System.out.println("Enter Question Marks");
		int questionMarks = input.nextInt();
		if (questionMarks <= 0)
			throw new QuestionException("Invalid Question Marks!!");
		else
			question.setQuestionMarks(questionMarks);

		if (questiondao.addQuestion(question))
			System.out.println("Question Added!");
		else
			System.out.println("Question Already present!");
	}

	@Override
	public void deleteQuestions() throws SQLException, QuestionException {
		question = null;
		question = new Question();
		System.out.println("Enter Question Id");
		int questionId = input.nextInt();
		if (questionId <= 0)
			throw new QuestionException("Invalid Question ID!!");
		else
			question.setQuestionId(questionId);
		if (questiondao.deleteQuestion(question))
			System.out.println("Question Deleted!");
		else
			System.out.println("Question does'nt Exists!");
	}

	@Override
	public void updateQuestions() throws SQLException {

	}

	@Override
	public void addOption(int questionId) throws SQLException,OptionException {
		questionOptions=null;
		questionOptions=new QuestionOptions();
		questionOptions.setId1(questionId);
		System.out.println("\nEnter Option 1:");
		input.nextLine();
		String ans1 = input.nextLine();
		if (ans1.isEmpty())
			throw new OptionException("Invalid Option String!!");
		else
			questionOptions.setAns1(ans1);
		System.out.println("\nEnter Option 2:");
		input.nextLine();
		String ans2 = input.nextLine();
		if (ans2.isEmpty())
			throw new OptionException("Invalid Option String!!");
		else
			questionOptions.setAns2(ans2);
		System.out.println("\nEnter Option 3:");
		input.nextLine();
		String ans3 = input.nextLine();
		if (ans3.isEmpty())
			throw new OptionException("Invalid Option String!!");
		else
			questionOptions.setAns3(ans3);
		System.out.println("\nEnter Option 4:");
		input.nextLine();
		String ans4 = input.nextLine();
		if (ans4.isEmpty())
			throw new OptionException("Invalid Option String!!");
		else
			questionOptions.setAns4(ans4);
		System.out.println("\nEnter Option 5:");
		input.nextLine();
		String ans5 = input.nextLine();
		if (ans5.isEmpty())
			throw new OptionException("Invalid Option String!!");
		else
			questionOptions.setAns5(ans5);
		
		
	}

	@Override
	public void deleteOption() {
		// TODO Auto-generated method stub
		
	}


}
