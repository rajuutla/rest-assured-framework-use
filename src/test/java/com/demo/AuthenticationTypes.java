package com.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class AuthenticationTypes {
	
	@Test
	public void testBearerToken()
	{
		
		given()
		.headers("Authorization", "Bearer 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")
		
		.when()
		.get("https://api.github.com/user/repos")
		
		.then()
		.statusCode(200)
		.log().all();
		
	}
	
	@Test
	public void testBasicAuthentication()
	{
		
		given()
		.auth().basic("postman", "password")
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		
		.then()
		.statusCode(200)
		.log().all();
		
	}
	
	@Test
	public void testBasicDigestAuthentication()
	{
		
		given()
		.auth().digest("postman", "password")
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		
		.then()
		.statusCode(200)
		.log().all();
		
	}

}
