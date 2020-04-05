package com.walkertest.question;

/**
 * Represents the option of a question
 *
 * @param <K>
 * the type to use as the option's label
 * @param <V>
 * the type that contains the option's information
 */
public class Option<K, V> {
	private K label;
	private V data;
	
	/**
	 * Creates an empty {@code Option} instance
	 */
	public Option() {}
	
	/**
	 * Creates a new {@code Option} instance with the label and 
	 * data specified
	 * @param label
	 * the {@code Option}'s label
	 * @param data
	 * the {@code Option}'s data
	 */
	public Option(K label, V data) {
		this.label = label;
		this.data = data;
	}
	
	/**
	 * Gets the label for this {@code Option}
	 * @return
	 * this {@code Option}'s label
	 */
	public K getLabel() {
		return label;
	}
	
	/**
	 * Sets the label for this {@code Option}
	 * @param label
	 * the new label for this {@code Option}
	 */
	public void setLabel(K label) {
		this.label = label;
	}
	
	/**
	 * Gets the data for this {@code Option}
	 * @return
	 * the data for this {@code Option}
	 */
	public V getData() {
		return data;
	}
	
	/**
	 * Sets the data for this {@code Option}.
	 * The data should contain the information the Option
	 * is supposed to convey
	 * @param data
	 * the data for this {@code Option}
	 */
	public void setData(V data) {
		this.data = data;
	}
	

}
