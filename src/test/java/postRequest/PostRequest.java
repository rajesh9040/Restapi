package postRequest;

import java.util.HashMap;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;
import static org.hamcrest.Matchers.*;


public class PostRequest {
	
	//using Hashmap
	@Test
	void Post(){
		
		HashMap map = new HashMap();
		map.put("name", "Rajesh");
		map.put("location", "Banglaore");
		 
		String str[]= {"c","c++"};
		map.put("courses","courseArr");
		
		given().contentType("application/json").body(map).when().
		post("https://reqres.in/api/users").jsonPath().getInt("id");
		
	}

}
