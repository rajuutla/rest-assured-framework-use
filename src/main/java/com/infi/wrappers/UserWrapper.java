package com.infi.wrappers;

import com.infi.endpoints.UserEndPoint;
import com.infi.pojo.User;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class UserWrapper {
	
	
	public static Response createUser(User user) {
		
		String url1 = UserEndPoint.base_url + UserEndPoint.create_user_endpoint;
		
		Response res = given()
		.contentType(ContentType.JSON)
		.body(user)
		
		.when()
		.post(url1);
		
		return res;
		
	}
	
	public static Response getUserWithUserName(String userName) {
		
		String url1 = UserEndPoint.base_url + UserEndPoint.get_user_with_username;
		
		Response res = given()
		.contentType(ContentType.JSON)
		.pathParam("username", userName)
		
		.when()
		.get(url1);
		
		return res;
		
	}

}
