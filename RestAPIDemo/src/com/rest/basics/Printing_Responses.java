package com.rest.basics;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;

public class Printing_Responses {

	public static void main(String[] args) {
		JsonPath js=new JsonPath(AddPlace.printres());
		
//		1. Print No of courses returned by API
		System.out.println(js.getInt("courses.size()"));
//		2.Print Purchase Amount
		System.out.println(js.getInt("dashboard.purchaseAmount"));
//		3. Print Title of the first course
		System.out.println(js.getString("courses[0].title"));
//		4. Print All course titles and their respective Prices
		for(int i=0;i<3;i++) {
			System.out.println(js.getString("courses["+i+"].title")+"="+js.getInt("courses["+i+"].price"));
		}
//		5. Print no of copies sold by RPA Course
		for(int i=0;i<3;i++) {
			if(js.getString("courses["+i+"].title").contains("RPA")){
				System.out.println(js.getString("courses["+i+"].copies"));
			}
		}
//		6. Verify if Sum of all Course prices matches with Purchase Amount
		int purchase_amt=js.getInt("dashboard.purchaseAmount");
		int verify_amt=0;
		for(int i=0;i<3;i++) {
			verify_amt=verify_amt+(js.getInt("courses["+i+"].price")*js.getInt("courses["+i+"].copies"));
			}
		System.out.println(purchase_amt+"  "+verify_amt);
		Assert.assertEquals(purchase_amt, 910);
		}
	
}
