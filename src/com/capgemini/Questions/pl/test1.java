package com.capgemini.Questions.pl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;

import com.capgemini.Questions.dto.Question;
import com.capgemini.Questions.dto.QuestionOptions;
import com.capgemini.Questions.dto.Test;
import com.capgemini.Questions.service.QuestionService;
import com.capgemini.Questions.service.QuestionServiceImpl;

public class test1 {

	public static void main(String[] args) throws Exception {
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
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

	}

}
