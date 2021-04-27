package com.gtgsantos.example.carpooling.api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class DriverAPITestIT {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "http://localhost:" + port;
        // security and https implementation in future versions
    }


    @Test
    public void shouldReturn404ForDriverNotFoundWithGET() {
        given()
                .contentType(io.restassured.http.ContentType.JSON)
                .get("/drivers/1")
                .then()
                .statusCode(404);
    }

    @Test
    public void shouldReturn200AndCreateANewDriverWithPOST() {

       String creatDriverJson = "{ \"name\": \"Zé carioca\", \"birthDay\": \"2000-03-20\"}";

        given()
                .contentType(io.restassured.http.ContentType.JSON)
                .body(creatDriverJson)
                .post("/drivers")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("name", equalTo("Zé carioca"))
                .body("birthDay", equalTo("2000-03-20T00:00:00.000+00:00"));
    }

    @Test
    public void shouldReturn200AndReturnAJSONDriverObject() {

        shouldReturn200AndCreateANewDriverWithPOST();

        given()
                .contentType(io.restassured.http.ContentType.JSON)
                .get("/drivers/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("name", equalTo("Zé carioca"))
                .body("birthDay", equalTo("2000-03-20T00:00:00.000+00:00"));
    }


    @Test
    public void shouldReturn200AndReturnAUpdatedJSONDriverObject() {

        shouldReturn200AndCreateANewDriverWithPOST();

        String updatedDriver = "{ \"name\": \"Donald duck\", \"birthDay\": \"2001-01-22\"}";

        given()
                .contentType(io.restassured.http.ContentType.JSON)
                .body(updatedDriver)
                .put("/drivers/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("name", equalTo("Donald duck"))
                .body("birthDay", equalTo("2001-01-22T00:00:00.000+00:00"));
    }

    @Test
    public void shouldReturn200AndDeleteAJSONDriverObject() {

        shouldReturn200AndCreateANewDriverWithPOST();

        given()
                .contentType(io.restassured.http.ContentType.JSON)
                .delete("/drivers/1")
                .then()
                .statusCode(200);
    }
}
