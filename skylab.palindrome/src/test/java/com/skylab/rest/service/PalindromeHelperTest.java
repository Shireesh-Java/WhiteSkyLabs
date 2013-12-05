package com.skylab.rest.service;

import static org.fest.assertions.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class PalindromeHelperTest {

	@Test
	public void shouldReturnTrue_forValidPalindromeString() {
		PalindromeHelper helper = new PalindromeHelper();
		boolean isPalindrome = helper.isPalindromeString("Madam");
		assertThat(isPalindrome).isTrue();
	}
	
	@Test
	public void shouldReturnTrue_forValidPalindromeString_withSpaces() {
		PalindromeHelper helper = new PalindromeHelper();
		boolean isPalindrome = helper.isPalindromeString("Poor Dan is in a droop");
		assertThat(isPalindrome).isTrue();
	}
	
	@Test
	public void shouldReturnTrue_forValidPalindromeString_withSpecialChars() {
		PalindromeHelper helper = new PalindromeHelper();
		boolean isPalindrome = helper.isPalindromeString("Madam, I'm Adam");
		assertThat(isPalindrome).isTrue();
	}
	
	@Test
	public void shouldReturnTrue_forValidPalindromeString_withSpecialChars2() {
		PalindromeHelper helper = new PalindromeHelper();
		boolean isPalindrome = helper.isPalindromeString("Do geese see God?");
		assertThat(isPalindrome).isTrue();
	}
	
	@Test
	public void shouldReturnTrue_forValidPalindromeString_withNumbers() {
		PalindromeHelper helper = new PalindromeHelper();
		boolean isPalindrome = helper.isPalindromeString("1221");
		assertThat(isPalindrome).isTrue();
	}

	@Test
	public void shouldReturnFalse_forInValidPalindromeString() {
		PalindromeHelper helper = new PalindromeHelper();
		boolean isPalindrome = helper.isPalindromeString("madams");
		assertThat(isPalindrome).isFalse();
	}

	@Test
	public void shouldReturnFalse_forEmptyPalindromeString() {
		PalindromeHelper helper = new PalindromeHelper();
		boolean isPalindrome = helper.isPalindromeString("");
		assertThat(isPalindrome).isFalse();
	}

	@Test
	public void shouldReturnFalse_forNullPalindromeString() {
		PalindromeHelper helper = new PalindromeHelper();
		boolean isPalindrome = helper.isPalindromeString(null);
		assertThat(isPalindrome).isFalse();
	}
	
	@Test
	public void shouldCalulatePoints_BasedOnPalindromeString(){
		PalindromeHelper helper = new PalindromeHelper();
		int updatedScore = helper.calculatePoints(10, "Madam");
		assertThat(updatedScore).isEqualTo(12);
	}
	
	@Test
	public void shouldRegisterNewUser_WithIntialScoreZero(){
		Map<String, Integer> userPointsMapper = new HashMap<String, Integer>();
		PalindromeHelper helper = new PalindromeHelper();
		helper.registerUser(userPointsMapper, "user");
		assertThat(userPointsMapper.containsKey("user")).isTrue();
		assertThat(userPointsMapper.get("user")).isEqualTo(0);
		assertThat(userPointsMapper.containsKey("usera")).isFalse();
	}
	
	@Test
	public void shouldNotRegisterExistingUser(){
		Map<String, Integer> userPointsMapper = new HashMap<String, Integer>();
		userPointsMapper.put("user", 20);
		PalindromeHelper helper = new PalindromeHelper();
		helper.registerUser(userPointsMapper, "user");
		assertThat(userPointsMapper.containsKey("user")).isTrue();
		assertThat(userPointsMapper.get("user")).isEqualTo(20);
		assertThat(userPointsMapper.containsKey("usera")).isFalse();
	}
}
