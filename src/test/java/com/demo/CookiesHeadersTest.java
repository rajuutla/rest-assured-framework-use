package com.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class CookiesHeadersTest {
	
	@Test
	public void testCookies() {
		
		when().get("https://www.google.com")
		
		.then()
		.statusCode(200)
		.log().all()
		.cookie("AEC").equals("AUEFqZfsGL0Oj-uJulg54MpzW9SN7Q0kfv9XVp_4e4WiEap3b1k14ErvSPM");
		
	}
	
	
	@Test
	public void testHeaders() {
		
		when().get("https://www.google.com")
		
		.then()
		.statusCode(200)
		.log().all()
		.header("Content-Type", "text/html; charset=ISO-8859-1");
		
	}
	

}
