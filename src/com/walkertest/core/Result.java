package com.walkertest.core;

import java.util.HashMap;
import java.util.Map;

public class Result <K, V>{
	private User<?, ?> user;
	private Map<Part<K, V>, Integer> scoresByPart = new HashMap<>();
	
	public User<?, ?> getUser() {
		return user;
	}
	
	public void setUser(User<?, ?> user) {
		this.user = user;
	}

	public Map<Part<K, V>, Integer> getScoresByPart() {
		return scoresByPart;
	}

	public void setScoresByPart(Map<Part<K, V>, Integer> scoresByPart) {
		this.scoresByPart = scoresByPart;
	}
	
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
