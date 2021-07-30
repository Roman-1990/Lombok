package tests;


import org.junit.jupiter.api.Test;
import specs.Specs;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.*;



public class ReqresTests {

    @Test
    void listUserTest() {
        given()
                .spec(Specs.request)
                .when()
                .get("/unknown")
                .then()
                .spec(Specs.response)
                .log().body()
                .body("total", is(12));
    }

    @Test
    void singleUserTest() {
        given()
                .spec(Specs.request)
                .when()
                .get("/unknown/2")
                .then()
                .spec(Specs.response)
                .log().body();

    }

    @Test
    void singleUserNotFoundTest() {
        given()
                .spec(Specs.request)
                .when()
                .get("/users/23")
                .then()
                .spec(Specs.response2);

    }
    @Test
    void createTest() {
        given()
                .spec(Specs.request)
                .body("{\"name\": \"morpheus\"," +
                        "\"job\": \"leader\"}")
                .when()
                .post("/users")
                .then()
                .spec(Specs.response3)
                .body("name", is("morpheus"))
                .body("job", is("leader"));
    }
    @Test
    void registerSuccessfulTest() {
        given()
                .spec(Specs.request)
               .body("{\"email\": \"eve.holt@reqres.in\"," +
                        "\"password\": \"pistol\"}")
                .when()
                .post("/register")
                .then()
                .spec(Specs.response)
                .log().body()
                .body("token", is("QpwL5tke4Pnpja7X4"));

    }
    @Test
    void listUserTestGroovy() {
        given()
                .spec(Specs.request)
                .when()
                .get("/unknown")
                .then()
                .spec(Specs.response)
                .log().body()
                .body("data.findAll{it.id > 2}.id",
                        hasItem(3));

    }

}
