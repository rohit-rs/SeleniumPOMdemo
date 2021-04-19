package com.tricentis.demowebshop.utilities;

import com.tricentis.demowebshop.tests.BaseTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiUtils extends BaseTest {

	public static Response submitGETCall(String url) {
		return RestAssured.given().when().get(url);
	}
	
	
	

}
