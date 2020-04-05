package com.walkertest.core;

/**
 * This class represents the user who took a test.
 * 
 *
 * @param <K>
 * the type of object to use as the user's id
 * @param <V>
 * the type of object that will contain the user's data
 */
public class User<K, V> {
	private K userId;
	private V profileData;
	
	/**
	 * Gets the id of the user
	 * @return
	 * the id of this user
	 */
	public K getUserId() {
		return userId;
	}
	
	/**
	 * Sets the id of this user
	 * @param userId
	 * the preferred id for this user
	 */
	public void setUserId(K userId) {
		this.userId = userId;
	}

	/**
	 * Gets the object containing the profile data for this user
	 * @return
	 * this user's profile data
	 */
	public V getProfileData() {
		return profileData;
	}

	/**
	 * Sets the profile data for this user
	 * @param profileData
	 * this user's profile data
	 */
	public void setProfileData(V profileData) {
		this.profileData = profileData;
	}
}
