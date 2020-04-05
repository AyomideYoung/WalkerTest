package com.walkertest.question;

/**
 * An object representing a question
 * 
 * @param <K>
 * the type of object to be the question's id
 * @param <T>
 * the type of object to use as the answer
 */
public interface Question<K, T> {
	
	/**
	 * Sets the id of this question
	 * @param id
	 * the preferred id for this question
	 */
	public void setId(K id);
	
	/**
	 * Gets the id of this question
	 * @return
	 * this {@code Question}'s id
	 */
	public K getId();
	
	/**
	 * Verifies if {@code selectedAnswer} is the correct answer
	 * @param selectedAnswer
	 * the selectedAnswer
	 * @return
	 * true if the selected answer is the correct one
	 */
	public boolean isCorrectAnswer(T selectedAnswer);
}
