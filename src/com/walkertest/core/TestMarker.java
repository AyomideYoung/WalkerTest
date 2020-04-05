package com.walkertest.core;

import java.util.*;
import com.walkertest.question.*;

/**
 * The {@code TestMarker} class contains methods for marking {@code Test}s
 * 
 *
 */
public final class TestMarker {
	
	/**
	 * Marks a given {@code Test} instance and gives the {@code Result}.
	 * 
	 * @param <K>
	 * the type of object to use as the {@code Question}s' id
	 * @param <V>
	 * the type of object to use as the {@code Question}s' raw data
	 * @param test
	 * the {@code Test} instance to be marked
	 * @return
	 * a {@code Result} containing the scores obtained for this {@code Test}
	 */
	public static <K, V> Result<K, V> scoreTest(Test<K, V> test) {
		Map<Part<K, V>, Integer> scoresByPart = markByParts(test.getParts());
		return putIntoResult(test.getUser(), scoresByPart);
	}
	
	/**
	 * Marks the given Set of {@code Part}s. 
	 * <p>
	 * The result of the marking is given as a Map which
	 * uses {@code Part} as its key and an integer as its value.
	 * The integer value is the score obtained for that Part
	 * 
	 * @param <K>
	 * the type of object to use as the {@code Question}s' id
	 * @param <V>
	 * the type of object to use as the {@code Question}s' raw data
	 * @param parts
	 * the set of {@code Part}s to be marked
	 * @return
	 * a map in which the integer values represent the scores obtained
	 * for the respective {@code Part}
	 */
	public static <K, V> Map<Part<K, V>, Integer> markByParts(Set<Part<K, V>> parts){
		Map<Part<K, V>, Integer> scoresByPart = new HashMap<>();
		
		for(Part<K, V> part : parts) {
			int score = markQuestionsForPart(part);
			scoresByPart.put(part, score);
		}
		
		return scoresByPart;
	}
	

	/*
	 * Marks all the Questions for the given part
	 */
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
