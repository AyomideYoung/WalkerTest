package com.walkertest.core;

/**
 * This class represents the answer to a question
 * @author Mask
 *
 * @param <K>
 * The type of object that represents the {@code Question}'s id
 * @param <V>
 * The type of object that represents the answer's raw data
 */
public class Answer<K, V> {

	/**
	 * Creates a new {@code Answer} instance
	 */
	public Answer() {}
	
	/**
	 * Creates a new {@code Answer} instance with {@code questionId} and 
	 * {@code answer} specified.
	 * @param questionId
	 * the id of the {@code Question} that this answer is meant for
	 * @param answer
	 * the raw data of the answer
	 */
	public Answer(K questionId, V answer) {
		this.answer = answer;
		this.questionId = questionId;
	}
	
	private K questionId;
	private V answer;
	
	/**
	 * Gets the id of the question this instance is supposed to answer
	 * @return
	 * the id of the question to be answered
	 */
	public K getQuestionId() {
		return questionId;
	}
	
	/**
	 * Sets the id of the question this instance is meant to answer
	 * @param questionId
	 * the id of the {@link com.walkertest.question.Question Question}
	 *  this instance is supposed to answer
	 */
	public void setQuestionId(K questionId) {
		this.questionId = questionId;
	}
	
	/**
	 * Gets the raw data of this answer
	 * @return
	 * the raw data of this {@code Answer} instance
	 */
	public V getAnswer() {
		return answer;
	}
	
	/**
	 * Sets the raw data of this {@code Answer}
	 * @param answer
	 * the required raw data for this answer
	 */
	public void setAnswer(V answer) {
		this.answer = answer;
	}
}
