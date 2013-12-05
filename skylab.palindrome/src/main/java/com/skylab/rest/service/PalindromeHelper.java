package com.skylab.rest.service;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class PalindromeHelper {

	public boolean isPalindromeString(final String palindromeString) {
		
		if (StringUtils.isBlank(palindromeString)) {
			return false;
		}
		String escapedGivenString = palindromeString.replaceAll("[^A-Za-z]", "").toLowerCase();
		String reverseEscapedString = new StringBuilder(palindromeString.replaceAll("[^A-Za-z]", "").toLowerCase()).reverse().toString();
		
		if (escapedGivenString.equals(reverseEscapedString)) {
			return true;
		}
		return false;
	}

	public int calculatePoints(final int existingPoints, final String palindrome) {
		int pointsScored = palindrome.length() / 2;
		return existingPoints + pointsScored;
	}

	public void registerUser(final Map<String, Integer> userPointsMapper,
			final String user) {
		if (!userPointsMapper.containsKey(user)) {
			userPointsMapper.put(user, 0);
		}
	}
}
