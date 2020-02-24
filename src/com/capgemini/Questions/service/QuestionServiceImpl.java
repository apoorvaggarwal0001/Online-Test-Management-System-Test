package com.capgemini.Questions.service;

import java.sql.SQLException;
import java.util.*;

import com.capgemini.Questions.dao.*;
import com.capgemini.Questions.dto.*;
import com.capgemini.Questions.dto.Question;
import com.capgemini.Questions.dto.Test;
import com.capgemini.Questions.exception.*;

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
		Question question= new Question();
		question.setQuestionId(1001);
		questionMap = questiondao.getAllQuestions();
		optionMap = questionoptiondao.getAllOptions(question.getQuestionId());
		Set<Integer> keyset = questionMap.keySet();
		Set<Integer> keyset1 = optionMap.keySet();
		for (Integer i : keyset) {
			System.out.println("\n"+questionMap.get(i));
			questionoptiondao.getAllOptions(question.getQuestionId());
				System.out.print("\n"+optionMap.get(i)+" ");
			System.out.println("\n");
		}
	}

//	@Override
//	public void showAllOptions() throws SQLException {
//		System.out.println("Enter question id to view as a Question-Options: ");
//		int questionId = input.nextInt();
//		optionMap = questionoptiondao.getAllOptions(questionId);
//		questionoptiondao.getAllOptions(questionId);
//		Set<Integer> keyset = optionMap.keySet();
//		for (Integer i : keyset) {
//			System.out.println(optionMap.get(i));
//		}
//	}

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
	public void addOption() throws SQLException, OptionException {
		questionOptions = null;
		questionOptions = new QuestionOptions();
		System.out.println("Enter Question Id:");
		int id1 = input.nextInt();
		questionOptions.setId1(id1);
		System.out.println("\nEnter Option 1:");
		input.nextLine();
		String ans1 = input.nextLine();
		if (ans1.isEmpty())
			throw new OptionException("Invalid Option String!!");
		else {
			questionOptions.setAns1(ans1);
		}
		System.out.println("\nEnter Option 2:");
		String ans2 = input.nextLine();
		if (ans2.isEmpty())
			throw new OptionException("Invalid Option String!!");
		else {
			questionOptions.setAns2(ans2);
		}
		System.out.println("\nEnter Option 3:");

		String ans3 = input.nextLine();
		if (ans3.isEmpty())
			throw new OptionException("Invalid Option String!!");
		else
			questionOptions.setAns3(ans3);
		System.out.println("\nEnter Option 4:");

		String ans4 = input.nextLine();
		if (ans4.isEmpty())
			throw new OptionException("Invalid Option String!!");
		else
			questionOptions.setAns4(ans4);
		System.out.println("\nEnter Option 5:");

		String ans5 = input.nextLine();
		if (ans5.isEmpty())
			throw new OptionException("Invalid Option String!!");
		else
			questionOptions.setAns5(ans5);

		if (questionoptiondao.addOption(id1))
			System.out.println("Question Added!");
		else
			System.out.println("Question Already present!");
	}

	@Override
	public void deleteOption() {
		// TODO Auto-generated method stub

	}

	@Override
	public void viewQuestion(int questionId) throws SQLException {
		questiondao.searchQuestion(questionId);
	}

	@Override
	public void viewOption(int id1) throws SQLException {
		questionoptiondao.viewOption(id1);
	}

	@Override
	public void addTestQuestion(Test testId, Question question) throws SQLException {
		QuestionOptions questionOptions = new QuestionOptions();
		HashMap<Integer, Question> questionMap = new HashMap<>();
		HashMap<Integer, QuestionOptions> optionsMap = new HashMap<>();
		Scanner input = new Scanner(System.in);
		viewQuestion(question.getQuestionId());
		questionOptions.setId1(question.getQuestionId());
		viewOption(questionOptions.getId1());
		question.setChosenAnswer(-1);
		while (question.getChosenAnswer() <= 0 || question.getChosenAnswer() > 5) {
			System.out.println("Enter Choice: (1-5)");
			question.setChosenAnswer(input.nextInt());
		}

	}
}
