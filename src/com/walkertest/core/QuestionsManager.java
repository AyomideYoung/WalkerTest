package com.walkertest.core;

import java.util.*;

import com.walkertest.question.Question;


/**
 * This class is responsible for keeping track of the {@link com.walkertest.question.Question Question}s and
 * their {@link Loader}s.
 * It also uses a packager which contains the logic required to group the questions
 * into the required parts.
 *
 * @param <K>
 * The object to use as the {@code Question}'s id 
 * @param <V>
 * The type of object that will contain the {@code Question} and {@code Answer}'s
 * raw data
 * 
 */
public class QuestionsManager <K, V> {
	
	private Map<Loader<K,V>, Set<? extends Question<K, V>>> questionsByLoader = new HashMap<>();
	private Packager<K, V> packager;
	
	/**
	 * Creates a new instance of {@code QuestionsManager}.
	 * @param packager
	 * the packager to be used in grouping {@code Question}s into required 
	 * {@code Part}s.
	 */
	public QuestionsManager(Packager<K, V> packager) {
		this.packager = packager;
	}
	
	/**
	 * Adds a new {@code Loader} to the manager.
	 * <p>
	 * This method automatically calls the {@code loadQuestions} method of the 
	 * given loader
	 * @param loader
	 * the new {@code Loader}
	 */
	public void addLoader(Loader<K, V> loader) {
		Set<? extends Question<K, V>> loadedQuestions = loader.loadQuestions();
		questionsByLoader.put(loader, loadedQuestions);
	}

	/**
	 * Returns all the Questions that were loaded by the specified Loader.
	 * <br>
	 * If the loader is not recognized by the manager, an {@code IllegalArgumentException}
	 * is thrown
	 * @param loader
	 * loader used in loading the questions
	 * @return
	 * the Questions loaded by the given loader
	 */
	public Set<? extends Question<K, V>> getQuestionsByLoader(Loader<K, V> loader){
		if(!questionsByLoader.containsKey(loader)) {
			throw new IllegalArgumentException("Loader is not recognized. Try adding the loader first");
		}
		
		return questionsByLoader.get(loader);
	}
	
	/**
	 * Confirms if the loader has been added to the manager
	 * @param loader
	 * the loader to be verified
	 * @return
	 * true if the manager recognizes the loader
	 */
	public boolean isLoaderRecognized(Loader<K, V> loader) {
		return questionsByLoader.containsKey(loader);
	}
	
	/**
	 * Packages the loadedQuestions according to the rules
	 * specified by the {@code Packager}
	 * @return
	 * a map of Parts 
	 */
	public Set<Part<K, V>> packageToParts(){
		return packager.packageToParts(this);
	}
	
}
