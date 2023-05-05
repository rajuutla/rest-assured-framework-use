package com.gorest;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.*;

public class CreateUser {
	
	@Test
	public void goRestCreateUser(ITestContext context) {
		
		// POJO
		// HasMap
		// org.json
		
		Faker fakeData = new Faker();
		
		JSONObject data = new JSONObject();
		
		data.put("name", fakeData.name().fullName());
		data.put("gender", "male");
		data.put("email", fakeData.internet().emailAddress());
		data.put("status", "active");
		
		Response res = given()
		.contentType(ContentType.JSON)
		.body(data.toString())
		.header("Authorization", "Bearer 9f33a2e244d16558635ca44c9ad37489ee30140c73e0af602a2ba11edfe8063d")
		
		.when()
		.post("https://gorest.co.in/public/v2/users");
		
		int id_1 = res.jsonPath().getInt("id");
		System.out.println("User is created with id = "+id_1);
		context.setAttribute("user_id_1", id_1);
		
		
	}

}
