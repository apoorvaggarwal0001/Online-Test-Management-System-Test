package com.capgemini.test.dto;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Set;

public class Test {
	
	private int testId;
	private String testTitle;
	private int testDuration;
    private int testTotalMarks;
	private int testMarksScored;
	//private LocalTime startTime;
	//private LocalTime endTime;
	
	
	public Test(int testId, String testTitle, int testDuration, int testTotalMarks) {
		super();
		this.testId = testId;
		this.testTitle = testTitle;
		this.testDuration = testDuration;
		this.testTotalMarks = testTotalMarks;
	}
	
	public Test() {
		// TODO Auto-generated constructor stub
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public void setTestTitle(String testTitle) {
		this.testTitle = testTitle;
	}

	public void setTestDuration(int testDuration) {
		this.testDuration = testDuration;
	}

	@Override
	public String toString() {
		return "Test [testId=" + testId + ", testTitle=" + testTitle + ", testDuration=" + testDuration
				+ ", testTotalMarks=" + testTotalMarks + ", testMarksScored=" + testMarksScored + "]";
	}

	public void setTestTotalMarks(int testTotalMarks) {
		this.testTotalMarks = testTotalMarks;
	}

	public void setTestMarksScored(int testMarksScored) {
		this.testMarksScored = testMarksScored;
	}

//	public void setStartTime(Time time) {
//		this.startTime = startTime;
//	}
//
//	public void setEndTime(Time time) {
//		this.endTime = endTime;
//	}

	public int getTestId() {
		return testId;
	}
	public String getTestTitle() {
		return testTitle;
	}
	public int getTestDuration() {
		return testDuration;
	}

	public int getTestTotalMarks() {
		return testTotalMarks;
	}
	public int getTestMarksScored() {
		return testMarksScored;
	}

//	public LocalTime getStartTime() {
//		return startTime;
//	}
//	public LocalTime getEndTime() {
//		return endTime;
//	}
	
	
}
