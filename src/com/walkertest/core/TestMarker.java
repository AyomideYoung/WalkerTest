package com.walkertest.core;

import java.util.*;
import com.walkertest.question.*;


public final class TestMarker {
	
	public static <K, V> Result<K, V> scoreTest(Test<K, V> test) {
		Map<Part<K, V>, Integer> scoresByPart = markByParts(test.getParts());
		return putIntoResult(test.getUser(), scoresByPart);
	}
	
	public static <K, V> Map<Part<K, V>, Integer> markByParts(Set<Part<K, V>> parts){
		Map<Part<K, V>, Integer> scoresByPart = new HashMap<>();
		
		for(Part<K, V> part : parts) {
			int score = markQuestionsForPart(part);
			scoresByPart.put(part, score);
		}
		
		return scoresByPart;
	}
	

	private static <K, V> Integer markQuestionsForPart(Part<K, V> part) {
		Set<Answer<K, V>> answers = part.getAnswers();
		int score = 0;
		
		for(Answer<K, V> answer: answers) {
			K questionId = answer.getQuestionId();
			Question<K, V> question = part.getQuestionById(questionId);
			if(question.isCorrectAnswer(answer.getAnswer()))
				score++;
		}
		
		return score;
	}
	
	private static <K, V> Result<K, V> putIntoResult(User<?, ?> user, Map<Part<K, V>, Integer> scoresByPart) {
		Result<K, V> result = new Result<>();
		result.setUser(user);
		result.setScoresByPart(scoresByPart);
		
		return result;
	}
}
