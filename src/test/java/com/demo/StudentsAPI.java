package com.demo;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;


import com.github.javafaker.Faker;
import org.json.*;


public class StudentsAPI {
	
	
	@Test
	public void getStudents() {
		
		when()
		.get("http://localhost:3000/students")
		
		.then()
		.statusCode(200)
		.log().all();
	}
	
	
	@Test
	public void createUser() {
		
		/*   // With HashMap
		 * java.util.Map<Object, Object> studentData = new java.util.HashMap<Object,
		 * Object>();
		 * 
		 * String[] courses = {"RestAssured", "Selenium"};
		 * 
		 * studentData.put("email", "avinash.1@gmail.com");
		 * studentData.put("first_name", "avinash.1@gmail.com");
		 * studentData.put("last_name", "avinash.1@gmail.com");
		 * studentData.put("courses",courses);
		 */
		
		/*  // With POJO
		 * String[] courses = {"RestAssured", "Selenium"}; Student std1 = new Student();
		 * 
		 * std1.setCourses(courses); std1.setFirstName("Avinash0");
		 * std1.setLastName("T"); std1.setEmail("avinash.77@gmail.com");
		 */
		
		JSONObject data = new JSONObject();
		
		Faker fakeData = new Faker();
		fakeData.internet().emailAddress();
		
		
		data.put("first_name", fakeData.name().firstName());
		data.put("last_name", fakeData.name().lastName());
		data.put("email", fakeData.internet().emailAddress());
		
		given()
		.contentType(ContentType.JSON)
		.body(data.toString())
		
		.when()
		.post("http://localhost:3000/students")
		
		.then()
		.statusCode(201)
		.log().all();
		
	}
	
	
	@Test
	public void udpateStudent() {
		java.util.Map<Object, Object> studentData = new java.util.HashMap<Object, Object>();
		
		String[] courses = {"RestAssured", "Selenium"};
		
		studentData.put("email", "avinash.1@gmail.com");
		studentData.put("first_name", "Avinash");
		studentData.put("last_name", "last");
		studentData.put("courses",courses);
		
		
		given()
		.contentType(ContentType.JSON)
		.body(studentData)
		
		.when()
		.put("http://localhost:3000/students/7")
		
		.then()
		.statusCode(200)
		.log().all();
		
	}
	
	@Test
	public void deleteStudents() {
		
		when()
		.delete("http://localhost:3000/students/7")
		
		.then()
		.statusCode(200)
		.log().all();
	}
	

}
