package com.walkertest.core;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.walkertest.question.Question;

/**
 * The {@code Part} class represents a part of a Test.
 * <p>
 * It contains questions grouped according to parts for example,
 * if a test contains a section on chemistry it is expected that
 * the {@code Part} contains questions on chemistry. 
 * <p>
 * It is also important that the part is appropriately labeled
 * so as to distinguish it from other {@code Part}s. (Chemistry in this
 * case).
 * 
 * @param <K>
 * the type of object to use as the {@code Question}s' ids
 * @param <V>
 * the type of object to use as the {@code Question}s' raw data
 */
public class Part <K, V>{
	
	/**
	 * Creates a new instance of {@code Part} with a name
	 * @param nameOfPart
	 * the name of this Part
	 */
	public Part(String nameOfPart) {
		this.nameOfPart = nameOfPart;
	}
	
	private String nameOfPart;
	private Map<K, Question<K, V>> questions = new HashMap<>();
	private Map<K, Answer<K, V>> answers = new HashMap<>();

	/**
	 * Gets the name of this {@code Part}.
	 * @return
	 * the name of this {@code Part}
	 */
	public String getNameOfPart() {
		return nameOfPart;
	}
	
	/**
	 * Sets the name of this {@code Part}
	 * @param nameOfPart
	 * the name to assign to this {@code Part}
	 */
	public void setNameOfPart(String nameOfPart) {
		this.nameOfPart = nameOfPart;
	}

	/**
	 * Gets a map of all the questions present in this {@code Part}.
	 * @return
	 * a map of all the questions in this {@code Part}
	 */
	public Map<K, Question<K, V>> getQuestions() {
		return questions;
	}

	/**
	 * Adds a new question to this {@code Part}
	 * @param newQuestion
	 * the question to add
	 */
	public void addQuestion(Question<K, V> newQuestion) {
		questions.put(newQuestion.getId(), newQuestion);
	}
	
	/**
	 * Fetches a question by its identifier from this {@code Part}.
	 * 
	 * @param id
	 * the identifier of the required {@code Question}
	 * @return
	 * the {@code Question} with the specified id
	 */
	public Question<K, V> getQuestionById(K id){
		return questions.get(id);
	}

	/**
	 * Gets all the answers for the {@code Question}s in this
	 * {@code Part}.
	 * @return
	 * all the answers for the {@code Question}s in this
	 * {@code Part}
	 */
	public Set<Answer<K, V>> getAnswers() {
		Collection<Answer<K, V>> collection = answers.values();
		return collection.stream()
				.collect(Collectors.toSet());
	}

	/**
	 * Sets the answers for all the questions in this {@code Part}
	 * 
	 * @param answerSet
	 * the answers to be set for this part
	 */
	public void setAnswers(Set<Answer<K, V>> answerSet) {
		answerSet.stream()
		.forEach(e -> answers.put(e.getQuestionId(), e));
	}
	
	/**
	 * Adds a new answer to this {@code Part}.
	 * <p>
	 * If a previous {@code Answer} with the same {@code questionId}
	 * exists, the new addition overwrites the old {@code Answer}
	 * 
	 * @param answer
	 * the new {@code Answer}
	 */
	public void addAnswer(Answer<K, V> answer) {
		answers.put(answer.getQuestionId(), answer);
	}
}
