package com.expleo.restAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CountryGetTest {
    @BeforeClass
    public static void init()
    {
        RestAssured.baseURI = "http://services.groupkt.com";
        //RestAssured.port=8080;
        RestAssured.basePath = "/country/get/iso2code";
    }
    @Test
    public void getAllCountryInformation()
    {
        /*
         *given() setups
         *
         * .when() GET, PUT, POST, DELETE etc
         *
         * .then() Validation, extract response, extract headers,
         * cookies, extract the respone body
         *
         * OR
         *
         * given().when,then()......
         */

        Response response = given().when().get("/XX");
        System.out.println(""); // sout =  live template

        System.out.println("response= "+response.body().prettyPrint());
        /*System.out.println("***************************************************************************************");
        System.out.println("\nValidate status code = 200");

        //ValidatableResponse response2 =

        given().
                when()
                .get("/list")
                .then()
                .statusCode(201);*/
    }
}
