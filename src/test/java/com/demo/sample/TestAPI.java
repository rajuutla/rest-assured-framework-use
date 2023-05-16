package com.demo.sample;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class TestAPI {
	
	int userId;
	
	
	@Test (enabled=false)
	public void getSingleUser() {
		
		when()
		.get("https://reqres.in/api/users/2")
		
		.then()
		.statusCode(200)
		.log().all();
	}
	
	@Test
	public void createUser() {
		
		Map<String, String> userData = new HashMap<String, String>();
		userData.put("name", "Testing1");
		userData.put("job", "QA");
		
		userId = given()
				.contentType("application/json")
				.body(userData)
				
				.when()
				.post("https://reqres.in/api/users")
				.jsonPath().getInt("id");
		
	}
	
	@Test(dependsOnMethods= {"createUser"})
	public void updateUser() {
		
		Map<String, String> userData = new HashMap<String, String>();
		userData.put("name", "Testing1");
		userData.put("job", "QA1");
		
		
		given()
				.contentType("application/json")
				.body(userData)
				
				.when()
					.put("https://reqres.in/api/users/"+userId)
				
				.then()
				.log().all();
		
		//.then()
		//.statusCode(201)
		//.log().all();
		
	}
	
	
	@Test
	public void getStudents() {
		
		
		when()
		.get("http://localhost:3000/students")
		
		.then()
		.log().all();
		
	}


	@Test
	public void addStudents() {
		
		String[] courses = {"Ang", "React"};
		
		Student std1 = new Student("R", "L", "t@gmail.com", courses) ;
		
		
		given()
		.contentType("application/json")
		.body(std1)
		
		
		.when()
		.post("http://localhost:3000/students")
		
		.then()
		.log().all();
		
	}
}
