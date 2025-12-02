package sample.proj;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class NewTest {
	
	static int a;
	static String f,b,c;
	
    @Test(enabled = false)
    public void rest() {
        Response response = RestAssured
            .given()
                .baseUri("https://jsonplaceholder.typicode.com")
            .when()
                .get("/posts/1")
            .then()
                .statusCode(200)
                .extract().response();
        System.out.println("Response: " + response.asString());
	}
	@Test(enabled = false)
	public void AddTest() {
        Response addresponse = RestAssured.given().header("Content-Type", "application/json")
                .body("{ \"name\": \"John\", \"age\": 30 }")
                .when()
                .post("https://your-api-endpoint.com/api/users")
                .then().statusCode(200).extract().response();
        System.out.println("Add Response: " + addresponse);
        
        Response postresponse = RestAssured.given().header(null)
        		.body("null")
        		.when()
        		.put()
        		.then().statusCode(200).extract().response();
        
	}
	
	@Test(enabled = true)
	 //Print all odd number
    public void PrintOdd() throws IOException {
    	int count = 0;
    	for (int i = 1 ; i <= 20 ; i++) {
			if(i%2==1) {
				count = count+1;
			}
		}
    	//System.out.println(count);
    	String xlsx_path = "https.goolge.com";
    	
    	FileInputStream file = new FileInputStream(new File(xlsx_path));
    	Workbook wb = new XSSFWorkbook(file);
    	wb.getSheet("yogi");
    	
    }
	
	@Test(enabled = false)
	public void StrChar() {
		String original;
		java.util.Scanner in = new java.util.Scanner(System.in);
		
		original=in.nextLine();
		String rev = "";
		for(int i = original.length()-1;i>=0;i--) {
			rev += original.charAt(i);
		}
		System.out.println("Reversed string : "+rev);
	//Palindrome check
		if (original.equals(rev)) {
			System.out.println("String is palindrome");
		} else {
			System.out.println("String is not palindrome");
		}

		 int x, y, temp;
	        System.out.println("Enter x and y");
	       // Scanner in = new Scanner(System.in);
	        x = 5;
	        y = 6;
	        System.out.println("Before Swapping" + x + y);
	        temp = x;
	        x = y;
	        y = temp;
	        System.out.println("After Swapping" + x + y);
	}
}
