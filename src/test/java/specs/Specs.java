package specs;

import io.restassured.builder.ResponseSpecBuilder;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;


public class Specs {
    public static RequestSpecification request = with()
            .baseUri("https://reqres.in")
            .basePath("/api")
            .log().all()
            .contentType(ContentType.JSON);

    public static ResponseSpecification response = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();
    public static ResponseSpecification response2 = new ResponseSpecBuilder()
            .expectStatusCode(404)
            .build();
    public static ResponseSpecification response3 = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .build();

}
