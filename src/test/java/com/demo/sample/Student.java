package com.demo.sample;

public class Student {
	
	String firstName;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String[] getCourses() {
		return courses;
	}
	public void setCourses(String[] courses) {
		this.courses = courses;
	}
	String lastName;
	String email;
	String courses[];
	
	Student(String firstName, String lastName, String email, String[] courses){
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.courses = courses;
	}
	

}
