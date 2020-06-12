package com.test.jenkins;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTest {
	@BeforeClass
	public void initialize() {
		
		RestAssured.baseURI="https://reqres.in/";
	}
	
	@Test
	public void reqresGetSingleUser() {
		
		RequestSpecification req = RestAssured.given();
		Response res = req.when().get("api/users/2");
		res.prettyPeek();		
	}
	//using Rest Assured with BDD
		@Test
		public void reqresCreateUser() {
			
			given()
			.header("Content-Type", "application/json")
			.body("{\r\n" + 
					"    \"name\": \"dipti\",\r\n" + 
					"    \"job\": \"leader\"\r\n" + 
					"}")
			.when().post("api/users")
			.then()
				.assertThat().statusCode(201).extract().response().prettyPeek();	
			
		}
		

}
