package com.walkertest.core;

import java.util.Set;

import com.walkertest.question.Question;

/**
 * The {@code Loader} class is responsible for loading {@code Question}s.
 *
 * @param <K>
 * the type of object to use as the Question's id
 * @param <T>
 * the type of object to use as the Question's raw data
 */
public abstract class Loader <K, T> {
	
	/**
	 * The name of the {@code Loader} instance
	 */
	public String name;
	
	/**
	 * Contains the logic to load questions
	 * @return
	 * a set of {@code Questions}
	 */
	public abstract Set<? extends Question<K, T>> loadQuestions();
	
	/**
	 * Sets the name of the {@code Loader} instance.
	 * @param name
	 * The required name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the name of the {@code Loader} instance.
	 * @return
	 * the name of this {@code Loader} instance
	 */
	public String getName() {
		return name;
	}
}
