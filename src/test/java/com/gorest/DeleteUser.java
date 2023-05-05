package com.gorest;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class DeleteUser {
	
	@Test
	public void goRestdeleteUser(ITestContext context) {
		
		
		String user_id = context.getAttribute("user_id_1").toString();
		
		given()
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer 9f33a2e244d16558635ca44c9ad37489ee30140c73e0af602a2ba11edfe8063d")
		.pathParam("user_id", user_id)
		
		.when()
		.delete("https://gorest.co.in/public/v2/users/{user_id}")
		
		.then()
		.statusCode(204)
		.log().all();
		
	}

}
