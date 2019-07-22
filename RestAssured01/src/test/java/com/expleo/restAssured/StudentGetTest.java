package com.expleo.restAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.Validatable;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StudentGetTest {
    @BeforeClass
    public static void init()
    {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port=8080;
        RestAssured.basePath = "/student";
    }
@Test
    public void getAllStudentInformation()
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

        Response response = given().when().get("/list");
        System.out.println(""); // sout =  live template

        System.out.println("response= "+response.body().prettyPrint());
        System.out.println("***************************************************************************************");

        //ValidatableResponse response2 =

                given().
                        when()
                        .get("/list")
                        .then()
                        .statusCode(201);
        System.out.println("\nValidate status code = 200");

    }

    @Test
    public void getStudentInfo()
    {
        Response  response = given().when().get("/3");

        System.out.println("Response = "+response.body().prettyPrint());
        System.out.println("******************************************************");

        given().
                when()
                .get("/15555")
                .then()
                .statusCode(200);
        System.out.println("\n Status code = 200");
    }

    @Test
    public void getStudentsFromFA()
    {
        //Response response = given().when().get("/list?programme=Financial Analysis&limit=2");
        //second way

        //System.out.println("response = " + response.prettyPeek());

        Response response2 = given().param("programme", "Financial Analysis")
                .param("limit", 2).when().get("/list");
        System.out.println("response = " + response2.body().prettyPrint());
    }

    @Test
    public void getStudentsFromMedicine()
    {
       // get the first 4 students from programme "medicine: using addparam
        Response response2 = given().param("programme", "Medicine")
                .param("limit", 4).when().get("/list");
        response2.body().prettyPrint();
    }


}
