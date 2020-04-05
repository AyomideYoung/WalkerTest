package test.walkertest;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import com.walkertest.question.ObjectiveQuestion;
import com.walkertest.question.Option;

public class ObjectiveQuestionTest {
	
	String questionData;
	Set<String> rawOptions;
	String rawCorrectAnswer;
	
	@Before
	public void setUp() {
		questionData = "What is the capital of Nigeria?";
		rawOptions = createOptions();
		rawCorrectAnswer = "Abuja";
	}
	
	private Set<String> createOptions(){
		String option1 = "Abia";
		String option2 = "Anambra";
		String option3 = "Abuja";
		String option4 = "Lagos";
		
		Set<String> options = new HashSet<>();
		options.add(option1);
		options.add(option2);
		options.add(option3);
		options.add(option4);
		
		return options;
	}
	
	@Test
	public void testCorrectAnswer() {
		ObjectiveQuestion<String, String> question = 
				new ObjectiveQuestion<>(questionData, rawOptions, rawCorrectAnswer);
		
		Option<String, String> correctOption = question.getCorrectAnswer();
		
		Assert.assertEquals(rawCorrectAnswer, correctOption.getData());
		
	}
}
