package com.walkertest.question;

import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;

import com.walkertest.helpers.OptionHelper;

public class ObjectiveQuestion<K, V> implements Question<K, Option<String, V>> {

	public ObjectiveQuestion(V rawQuestionData, Set<V> questionOptions, V correctAnswer) {
		this.questionData = rawQuestionData;
		this.questionOptions = OptionHelper.createOptionSetWithAlphabeticalLabel(questionOptions);
		if(!questionOptions.contains(correctAnswer)) {
			throw new IllegalArgumentException("Specified correctAnswer is not a member of the questionOptions Set");
		} else {
			String correctAnswerIdentifier = getCorrectAnswerLabel(correctAnswer, this.questionOptions);
			this.correctAnswer = new Option<String, V>(correctAnswerIdentifier, correctAnswer);
		}
		
	}
	
	@NonNull
	private K id;
	private V questionData;
	private Set<Option<String, V>> questionOptions;
	private Option<String, V> correctAnswer;
	
	@Override
	public boolean isCorrectAnswer(Option<String, V> selectedOption) {
		return correctAnswer.equals(selectedOption);
	}
	
	public V getQuestionData() {
		return this.questionData;
	}
	
	public Option<String, V> getCorrectAnswer(){
		return this.correctAnswer;
	}
	
	public Set<Option<String, V>> getQuestionOptions(){
		return this.questionOptions;
	}
	
	private String getCorrectAnswerLabel(V correctAnswer, Set<Option<String, V>> questionOptions) {
		return questionOptions.stream()
				.filter(e -> matchesSpecifiedCorrectAnswer(e, correctAnswer))
				.map(e -> e.getLabel())
				.findFirst()
				.get();
	}
	
	private boolean matchesSpecifiedCorrectAnswer(Option<String, V> element, V specifiedCorrectAnswer) {
		return element.getData().equals(specifiedCorrectAnswer);
	}

	@Override
	public K getId() {
		return id;
	}

	@Override
	public void setId(K id) {
		this.id = id;
	}
}
