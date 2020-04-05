package test.walkertest;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.platform.commons.util.ReflectionUtils;

import com.walkertest.core.Answer;
import com.walkertest.core.Part;
import com.walkertest.core.Result;
import com.walkertest.core.TestMarker;
import com.walkertest.core.User;
import com.walkertest.question.ObjectiveQuestion;
import com.walkertest.question.Option;

public class TestMarkerTest {

	Part<Integer, Option<String, String>> part = new Part<>("Test part");
	String question1Data = "Can a penguin fly?";
	String question2Data = "Is the sun a star?";
	
	String option1 = "Yes";
	String option2 = "No";
	
	Set<String> options = new HashSet<>();
	ObjectiveQuestion<Integer, String> question1;
	ObjectiveQuestion<Integer, String> question2;
	
	Answer<Integer, Option<String, String>> answer1;
	Answer<Integer, Option<String, String>> answer2;
	Part<Integer, Option<String, String>> dummyPart = new Part<>("Dummy Question Part");
	
	@Before
	public void setUp() {
		options.add(option1);
		options.add(option2);
		
		question1 = new ObjectiveQuestion<>(question1Data, options, option2);
		question2 = new ObjectiveQuestion<>(question2Data, options, option1);
		
		question1.setId(1);
		question2.setId(2);
		
		answer1 = new Answer<>(1, question1.getCorrectAnswer());
		answer2 = new Answer<>(2, question2.getCorrectAnswer());
		
		part.addQuestion(question1);
		part.addQuestion(question2);
		
		part.addAnswer(answer1);
		part.addAnswer(answer2);
	}
	
	@Test
	public void testMarkQuestionsForPart() throws NoSuchMethodException, SecurityException {
		int score = 0;
		Method method = TestMarker.class.getDeclaredMethod("markQuestionsForPart", Part.class);
		score = (Integer)ReflectionUtils.invokeMethod(method, null, part);
		
		Assert.assertEquals(2, score);
		
	}
	
	@Test
	public void testMarkByParts() {
		Set<Part<Integer, Option<String, String>>> setOfParts = new HashSet<>();
		Map<Part<Integer, Option<String, String>>, Integer> expectedMapOfParts = new HashMap<>();
		Part<Integer, Option<String, String>> dummyPart = new Part<>("Dummy Question Part");
		
		setOfParts.add(part);
		setOfParts.add(dummyPart);
		Map<Part<Integer, Option<String, String>>, Integer> actualMapOfParts = TestMarker.markByParts(setOfParts);
		
		expectedMapOfParts.put(part, 2);
		expectedMapOfParts.put(dummyPart, 0);
		
		Assert.assertEquals(expectedMapOfParts, actualMapOfParts);
		
	}
	
	@Test
	public void testScoreTest() {
		com.walkertest.core.Test<Integer, Option<String, String>> mockTest = createMockTest();
		Result<Integer, Option<String, String>> expectedResult = new Result<>();
		Map<Part<Integer, Option<String, String>>, Integer> expectedMapOfParts = new HashMap<>();
		
		
		expectedMapOfParts.put(part, 2);
		expectedMapOfParts.put(dummyPart, 0);
		expectedResult.setUser(mockTest.getUser());
		expectedResult.setScoresByPart(expectedMapOfParts);
		
		Result<Integer, Option<String, String>> actualResult = TestMarker.scoreTest(mockTest);
		
		Assert.assertEquals(expectedResult, actualResult);
	}

	private com.walkertest.core.Test<Integer, Option<String, String>> createMockTest() {
		com.walkertest.core.Test<Integer, Option<String, String>> mockTest = new com.walkertest.core.Test<>();
		User<Object, Object> userStub = new User<>();
		
		Set<Part<Integer, Option<String, String>>> setOfParts = new HashSet<>();
		setOfParts.add(part);
		setOfParts.add(dummyPart);
		
		mockTest.setUser(userStub);
		mockTest.setParts(setOfParts);
		return mockTest;
	}
}
