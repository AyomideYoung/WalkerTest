package com.walkertest.question;

import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;

import com.walkertest.helpers.OptionHelper;

/**
 * {@code ObjectiveQuestion} is a subclass of {@code Question} that represents
 * questions in which the possible answers are predefined.
 *
 * @param <K>
 * the type of object to use as the question's id
 * @param <V>
 * the type of object that will contain the raw data of the question
 * and its {@code Option}s
 */
public class ObjectiveQuestion<K, V> implements Question<K, Option<String, V>> {

	/**
	 * Creates a new instance of {@code ObjectiveQuestion}.
	 * 
	 * @param rawQuestionData
	 * the question's data. This can be interpreted by any UI as the 
	 * programmer sees fit
	 * @param questionOptions
	 * a set of objects representing the question options
	 * @param correctAnswer
	 * the correct option
	 * @throws IllegalArgumentException
	 * if {@code correctAnswer} is not among {@code questionOptions}
	 */
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
	
	/**
	 * Checks to see if the {@code selectedOption} is the correct
	 * option
	 */
	@Override
	public boolean isCorrectAnswer(Option<String, V> selectedOption) {
		return correctAnswer.equals(selectedOption);
	}
	
	/**
	 * Gets the raw data of this {@code Question}.
	 * @return
	 * the raw question data
	 */
	public V getQuestionData() {
		return this.questionData;
	}
	
	/**
	 * Gets the correct answer (option) for this {@code Question}
	 * @return
	 * the correct option
	 */
	public Option<String, V> getCorrectAnswer(){
		return this.correctAnswer;
	}
	
	/**
	 * Gets all the options available for this question
	 * @return
	 * the options for this question
	 */
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
