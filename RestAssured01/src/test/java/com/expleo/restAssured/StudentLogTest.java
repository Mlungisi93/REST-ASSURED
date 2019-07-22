package com.expleo.restAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StudentLogTest {
    @BeforeClass
    public static void init()
    {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port=8080;
        RestAssured.basePath = "/student";
    }

    @Test
    public void test001()
    {
        System.out.println("----------------------------- Log Request Headers ----------------------------------");
        RestAssured.given()
                .log()
                .headers()
                .when()

                .get("/list")
                .then()
                .log()
               .headers()
                .statusCode(200);
    }

}
