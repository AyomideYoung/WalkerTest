package com.walkertest.question;

public interface Question<K, T> {
	
	public void setId(K id);
	public K getId();
	public boolean isCorrectAnswer(T selectedAnswer);
}
