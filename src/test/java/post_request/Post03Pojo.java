package post_request;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceholderPojo;

import static io.restassured.RestAssured.given;

public class Post03Pojo extends JsonplaceholderBaseUrl {
    /*
         Given
            https://jsonplaceholder.typicode.com/todos
            {
            "userId": 55,
            "title": "Tidy your room",
            "completed": false
            }
        When
            I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */

    @Test
    public void post03Pojo() {
        //Set the Url
        spec.pathParam("first","todos");

        //Set the Expected Data
        JsonPlaceholderPojo expectedData = new JsonPlaceholderPojo(55,"Tidy your room",false);
        System.out.println("expectedData = " + expectedData);

        //Send the Post Request and Get the Response
        Response response =given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.prettyPrint();

        //Do Assertion
        JsonPlaceholderPojo actualData=response.as(JsonPlaceholderPojo.class);
        System.out.println("actualData = " + actualData);
    }
}
