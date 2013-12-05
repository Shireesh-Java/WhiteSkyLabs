package com.skylab.rest.service;

import static org.fest.assertions.Assertions.assertThat;

import javax.ws.rs.core.Response;

import org.testng.annotations.Test;

public class PalindromeServiceTest {
	@Test
	public void testService() {
		PalindromeService service = new PalindromeService();
		Response res = service.playPalindrome("user", "madam");
		assertThat(res.getEntity()).isEqualTo(
				"CONGRATULATIONS :: user Your Score Is :: 2");
	}
}
