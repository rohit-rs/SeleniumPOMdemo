/**
 * 
 */
package com.tricentis.demowebshop.tests;

import org.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.tricentis.demowebshop.utilities.ApiUtils;

/**
 * @author Rohit Srivastav
 *
 */
public class FoodOutletAPITests extends BaseTest {

	private String url = "https://jsonmock.hackerrank.com/api/food_outlets";
	
	
	@Test
	public void verifyPageNumberAndNumberOfPagesForDenver() {
		test = extent.createTest("Verify page number and number of pages for city Denver");
		response = ApiUtils.submitGETCall(url + "?city=denver");
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.jsonPath().getInt("page"), 1);
		Assert.assertEquals(response.jsonPath().getInt("total_pages"), 4);
	}
	
	
	@Test
	public void getTopRatedRestaurentForDenverFromPage1() {
		test = extent.createTest("Verify number of top rated restaurant in Denver on page 1");
		response = ApiUtils.submitGETCall(url + "?city=denver&page=1");
		JSONArray ja = new JSONArray(response.jsonPath().getList("data"));
		int objCount = ja.length();
		double maxRating = 0.0;
		//Get max rating from the first page
		for (int i = 0; i < objCount; i++) {
			double rating = ja.getJSONObject(i).getJSONObject("user_rating").getDouble("average_rating");
			if (rating > maxRating) {
				maxRating = rating;
			}
		}
		//Print top rated restaurant names
		int topRatedResCount = 0;
		for (int i = 0; i < objCount; i++) {
			double rating = ja.getJSONObject(i).getJSONObject("user_rating").getDouble("average_rating");
			if (rating == maxRating) {
				System.out.println(ja.getJSONObject(i).get("name"));
				topRatedResCount++;
			}
		}
		Assert.assertEquals(topRatedResCount, 4);
		
	}
	
	

}
