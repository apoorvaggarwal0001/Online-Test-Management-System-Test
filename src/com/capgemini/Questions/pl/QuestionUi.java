package com.capgemini.Questions.pl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;

import com.capgemini.Questions.dao.QuestionDao;
import com.capgemini.Questions.dto.Question;
import com.capgemini.Questions.dto.QuestionOptions;
import com.capgemini.Questions.dto.Test;
import com.capgemini.Questions.exception.OptionException;
import com.capgemini.Questions.exception.QuestionException;
import com.capgemini.Questions.service.QuestionService;
import com.capgemini.Questions.service.QuestionServiceImpl;

public class QuestionUi {
	QuestionDao questiondao;
	Question question;
	Test test1;

	public static void main(String[] args) throws QuestionException, OptionException {

//		Scanner input = new Scanner(System.in);

//		QuestionService service = null;
//		String ch = "yes";
		// --------------------------------------------------------------------------------------------------------------------------
//		try {
//			service = new  QuestionServiceImpl();
//			
//		}catch(SQLException e1) {
//			System.err.println(e1.getMessage());
//		}
//		
//		while (ch.equalsIgnoreCase("yes")) {
//			System.out.println("Select Operation:");
//			System.out.println("1. Add Question");
//			System.out.println("2. Show All Questions");
//			System.out.println("3. Delete Question");
//			System.out.println("4. View as a Question & Options");
//			System.out.println("5. Add option");
//
//			
//			int op=input.nextInt();
//			switch(op) {
//			case 1: try {
//				service.addQuestions();
//			}catch(SQLException e1) {
//				System.out.println(e1.getMessage());
//			}
//				break;
//			
//			case 2: 
//				try {
//				service.showAllQuestions();
//			}catch(SQLException e) {
//				System.err.println(e.getMessage());
//			}
//				break;
//				
//			case 3: try {service.deleteQuestions();
//			}catch(SQLException e) {
//				System.err.println(e.getMessage());
//			}
//			break;
//			case 4: try {
//				service.showAllOptions();
//			}catch(SQLException e1) {
//				System.out.println(e1.getMessage());
//			}
//				break;
//				
//			case 5: try {
//				service.addOption();
//			}catch(SQLException e1) {
//				System.out.println(e1.getMessage());
//			}
//				break;
//			
//				
//			default: break;
//			}
//			System.out.println("\nCONTINUE  (Y-yes/N-no): ");
//			ch=input.next();
//		}
//		
		System.out.println("--------------------TEST-------------------\n");
		QuestionService service = null;
		Scanner input = new Scanner(System.in);
		Question question = new Question();
		QuestionOptions options = new QuestionOptions();
		HashMap<Integer, Question> questionMap = new HashMap<>();
		HashMap<Integer, QuestionOptions> optionsMap = new HashMap<>();
		try {
			service = new QuestionServiceImpl();
		} catch (SQLException e1) {
			System.err.println(e1.getMessage());
		}
		try {
			question.setQuestionId(1001);
			Test test1 = null;
			service.addTestQuestion(test1, question);
			System.out.println("\n\n");
			service.showAllQuestions();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

	}

}
