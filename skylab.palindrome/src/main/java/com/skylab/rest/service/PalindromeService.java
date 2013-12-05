package com.skylab.rest.service;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/*
 * http://localhost:8080/palindrome/rest/game/palindrome?user=Shireesh&palindrome=Madam
 */
@Path("/game")
public class PalindromeService {
	final static Map<String, Integer> userPointsMapper = new HashMap<String, Integer>();
	@GET
	@Path("/palindrome")
	public Response playPalindrome(@QueryParam("user") String user,
			@QueryParam("palindrome") String palindrome) {

		PalindromeHelper helper = new PalindromeHelper();
		
		helper.registerUser(userPointsMapper,user);

		if (helper.isPalindromeString(palindrome)) {
			int existingPoints = userPointsMapper.get(user);
			int totalPointsScored = helper.calculatePoints(existingPoints,palindrome);
			userPointsMapper.put(user, totalPointsScored);
			return Response.status(200).entity("CONGRATULATIONS :: " + user + " Your Score Is :: " + totalPointsScored).build();
		}

		return Response.status(200).entity("NOT A PALINDROME : TRY AGAIN ").build();
	}
}
