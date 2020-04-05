package com.walkertest.core;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.walkertest.question.Question;

public class Part <K, V>{
	
	public Part(String nameOfPart) {
		this.nameOfPart = nameOfPart;
	}
	
	private String nameOfPart;
	private Map<K, Question<K, V>> questions = new HashMap<>();
	private Map<K, Answer<K, V>> answers = new HashMap<>();

	public String getNameOfPart() {
		return nameOfPart;
	}
	
	public void setNameOfPart(String nameOfPart) {
		this.nameOfPart = nameOfPart;
	}

	public Map<K, Question<K, V>> getQuestions() {
		return questions;
	}

	public void addQuestion(Question<K, V> newQuestion) {
		questions.put(newQuestion.getId(), newQuestion);
	}
	
	public Question<K, V> getQuestionById(K id){
		return questions.get(id);
	}

	public Set<Answer<K, V>> getAnswers() {
		Collection<Answer<K, V>> collection = answers.values();
		return collection.stream()
				.collect(Collectors.toSet());
	}

	public void setAnswers(Set<Answer<K, V>> answerSet) {
		answerSet.stream()
		.forEach(e -> answers.put(e.getQuestionId(), e));
	}
	
	public void addAnswer(Answer<K, V> answer) {
		answers.put(answer.getQuestionId(), answer);
	}
}
