package com.gorest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ListAllUsers {
	
	
	@Test
	public void goRestListUsers() {
		
		
		when()
		.get("https://gorest.co.in/public/v2/users")
		
		.then()
		.statusCode(200)
		.log().all();
		
		
	}

}
