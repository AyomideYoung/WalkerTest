package com.walkertest.core;

import java.util.HashMap;
import java.util.Map;

/**
 * The {@code Result} class represents the result for a test.
 * The scores obtained for each {@link Part} are given with
 * the {@link getScoresByPart()} method.
 * 
 *
 * @param <K>
 * the type of object to use as the {@code Question}s' ids
 * @param <V>
 * the type of object to use as the {@code Question}s' raw data
 */
public class Result <K, V>{
	private User<?, ?> user;
	private Map<Part<K, V>, Integer> scoresByPart = new HashMap<>();
	
	/**
	 * Gets the user that owns this {@code Result}
	 * @return
	 * the {@link User} that owns this result
	 */
	public User<?, ?> getUser() {
		return user;
	}
	
	/**
	 * Sets the user that owns this {@code Result}
	 * @param user
	 * the owner of this {@code Result}
	 */
	public void setUser(User<?, ?> user) {
		this.user = user;
	}

	/**
	 * Gets the scores of each {@code Part} taken during the test
	 * @return
	 * a map containing the scores for each part of a test
	 */
	public Map<Part<K, V>, Integer> getScoresByPart() {
		return scoresByPart;
	}

	/**
	 * Sets the scores of the parts of the marked test
	 * @param scoresByPart
	 * a map of the scores of each part of the test
	 */
	public void setScoresByPart(Map<Part<K, V>, Integer> scoresByPart) {
		this.scoresByPart = scoresByPart;
	}
	
	/*
	 * This method was overridden due to irregularities during unit tests
	 */
	@Override
	public boolean equals(Object other) {
		if(other instanceof Result) {
			Result<?, ?> otherResult = (Result<?, ?>)other;
			return otherResult.getUser().equals(this.getUser()) && 
					otherResult.getScoresByPart().equals(this.getScoresByPart());
		} else {
			return false;
		}
			
	}
}
