package com.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class FirstRestAssuredTest {
	
	
	@Test
	public void getSingleUser()
	{
		// https://reqres.in/api/users/2
		
		
		//given().
		 // Prerequisties - set Header, cookies, authentication etc.,
		
		when().get("https://reqres.in/api/users/2")
		
		// Actions - get, post, put, delete
		
		.then()
		.statusCode(200);
		//.body("data.first_name", equalTo("Janet"))
		//.log().all();
		 // Validations - status code, header, response body validations
	}

}
