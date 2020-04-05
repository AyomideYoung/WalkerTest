package com.walkertest.core;

import java.util.Set;

@FunctionalInterface
/**
 * This interface provides a guideline for packaging questions into
 * desired parts.
 * <p>
 * Implementing classes should arrange the {@code Question}s and group
 * them into {@code Part}s as required. The resulting {@code Part} should be
 * named for reference purposes later on
 *
 *  @param <K>
 * the type of object to use as the {@code Question}s' id
 * @param <V>
 * the type of object to use as the {@code Question}s' raw data
 */
public interface Packager<K, V> {
	/**
	 * Packages questions into labeled parts.
	 * <p>
	 * The {@code manager} parameter specified will be used by the 
	 * method to retrieve the questions for packaging or arrangement.
	 * @param manager
	 * the {@link QuestionsManager} instance to use for {@code Question}
	 * retrieval
	 * @return
	 * a set of {@link Part}s containing arranged {@code Question}s
	 */
	public Set<Part<K, V>> packageToParts(QuestionsManager<K, V> manager);
}
