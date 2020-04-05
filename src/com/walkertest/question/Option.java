package com.walkertest.question;

public class Option<K, V> {
	private K label;
	private V data;
	
	
	public Option() {}
	
	public Option(K label, V data) {
		this.label = label;
		this.data = data;
	}
	
	public K getLabel() {
		return label;
	}
	
	public void setLabel(K label) {
		this.label = label;
	}
	
	public V getData() {
		return data;
	}
	
	public void setData(V data) {
		this.data = data;
	}
	

}
