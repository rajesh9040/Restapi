package restapi;

import io.restassured.http.ContentType;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;
import static org.hamcrest.Matchers.*;

public class Restapi {
    int id;
    Response _id; 
    

    @Test
    public void http() {
        given()
                .when().get("https://reqres.in/api/users/2")
                .then().statusCode(200 ).log().all();
    }

    @Test
    public void create() {
        HashMap map = new HashMap<>();
        map.put("name", "Rakesh");
        map.put("job", "Engineer");
        id = given()
                
                .contentType("application/json")
                .body(map)
                .when()
                .post("https://reqres.in/api/users").jsonPath().getInt("id");
               // .then()
               // .statusCode(201)
               // .extract()
              //  .path("id");
        
    }
    @Test
    public void orgJson() {
    	JSONObject data = new JSONObject();
       
        data.put("name", "Animesh");
        data.put("location", "Rourkela");
        given()
                
                .contentType("application/json")
                .body(data.toString())
                .when()
                .post("https://reqres.in/api/users")
               .then()
               .statusCode(201)
                .body("name",equalTo("Animesh")).body("location",equalTo("Rourkela")).header("Content-Type","application/json; charset=utf-8").log().all();
    }
    @Test(priority=4)
    public void Pojo() {
    	pojoPost data= new pojoPost();
       
        data.setName("Nitesh");
        data.setLocation("Rourkela");
        given()
                
                .contentType("application/json")
                .body(data)
                .when()
                .post("https://reqres.in/api/users")
               .then()
               .statusCode(201)
                .body("name",equalTo("Nitesh")).body("location",equalTo("Rourkela")).header("Content-Type","application/json; charset=utf-8").log().all();
    }
    @Test
    public void cooki() {
    	Response res=given().when().get("https://reqres.in/api/users");
    	Headers hea = new Headers();
    	for(Header head:hea) {
    		System.out.println(head.getName()+" "+head.getValue());
    	}
    	
    	Map<String,String> map = res.getCookies();
    	for(String re:map.keySet()) {
    		String str = res.getCookie(re);
    		System.out.println(str);
    	}	
    }	
    	
    	@Test(priority=1)
    	public void vialumia() {
    		HashMap ma = new  HashMap<>();
    		ma.put("email","palisv@gmail.com");
    		ma.put("password","blmbjofy");
     _id= given()
    				.body(ma).contentType("application/json").when().post("https://stage.api.vialumina.eu/api/login").jsonPath().get("_id");
     
    	
    		
    	
    	 	
} 	}
    
