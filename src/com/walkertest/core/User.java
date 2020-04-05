package com.walkertest.core;

public class User<K, V> {
	private K userId;
	private V profileData;
	
	public K getUserId() {
		return userId;
	}
	
	public void setUserId(K userId) {
		this.userId = userId;
	}

	public V getProfileData() {
		return profileData;
	}

	public void setProfileData(V profileData) {
		this.profileData = profileData;
	}
}
