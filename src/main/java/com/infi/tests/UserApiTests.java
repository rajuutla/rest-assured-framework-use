package com.infi.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.infi.pojo.User;
import com.infi.wrappers.UserWrapper;

import io.restassured.response.Response;

import com.github.javafaker.Faker;

public class UserApiTests {
	
	User user = null;
	Faker fakeData = new Faker();
	
	@BeforeClass
	public void getUserData() {
		
		user = new User();
		user.setId(fakeData.idNumber().hashCode());
		user.setEmail(fakeData.internet().emailAddress());
		user.setFirstName(fakeData.name().firstName());
		user.setLastName(fakeData.name().lastName());
		user.setPassword(fakeData.internet().password());
		user.setPhone(fakeData.phoneNumber().toString());
		user.setUserStatus(0);
		user.setUserName("test123");
		
	}
	
	
	@Test
	public void petStoreCreateUser() {
		
		Response res = UserWrapper.createUser(user);
		
		Assert.assertEquals(200, res.getStatusCode());
		res.then().log().all();
		
	}
	
	@Test
	public void petStoreGetUserWithUserName() {
		
		Response res = UserWrapper.getUserWithUserName("test123");
		
		res.then().log().all();
		Assert.assertEquals(200, res.getStatusCode());
	}
	
	
	

}
