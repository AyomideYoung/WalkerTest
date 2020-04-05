package com.walkertest.core;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents the test for a specific user
 * 
 *
 * @param <K>
 * The type of object to be used as the key for all {@code Question}s
 * @param <V>
 * The type of object that will contain the raw data for all {@code Question}s
 * 
 */
public class Test <K, V>{
	private User<?, ?> user;
	
	private Set<Part<K, V>> parts = new HashSet<>();
	
	/**
	 * Returns all the {@link Part Parts} contained in this {@code Test}
	 * @return
	 * a set of {@code Part}s containing all the Questions for this Test
	 */
	public Set<Part<K, V>> getParts() {
		return parts;
	}
	
	/**
	 * Sets all of the {@link Part Parts} for this Test
	 * @param parts
	 * the set of question {@code Part}s assigned for this Test
	 */
	public void setParts(Set<Part<K, V>> parts) {
		this.parts = parts;
	}

	/**
	 * Gets the {@link User} that owns the test
	 * @return
	 * the {@code User} that owns the test
	 */
	public User<?, ?> getUser() {
		return user;
	}

	/**
	 * Sets the {@link User} that owns the test
	 * @param user
	 * The user that owns the Test
	 */
	public void setUser(User<?, ?> user) {
		this.user = user;
	}
}
