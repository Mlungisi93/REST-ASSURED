package com.expleo.restAssured;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class RequestSpecificationExample {
    private static RequestSpecBuilder builderReq;
    private static RequestSpecification requestSpec;
    private static ResponseSpecification responseSpec;
    private static ResponseSpecBuilder builderResp;


    @BeforeClass
    public static void init()
    {
     builderReq = new RequestSpecBuilder();
     requestSpec = builderReq
             .setBaseUri("http://services.groupkt.com")
             .setBasePath("/country/get/iso2code")
             .build();


    }

    @Test
    public void test001()
    {
        System.out.println("------------ Checking requestSpec ------------------------");
        requestSpec = given(requestSpec).log().all();
        requestSpec.when()
                .get("ZA")
                .then()
                .log()
                .headers();
        //Response response = given(requestSpec, re)

        System.out.println("------------ Checking responseSpec --------------");
        builderResp = new ResponseSpecBuilder();
        responseSpec = builderResp
                .expectStatusCode(200)
                .expectBody("RestResponse.result.name", equalTo("South Africa"))
                .build();
        Response response = given(requestSpec, responseSpec).get("ZA");
        response.prettyPrint();
        //System.out.println(response.body().prettyPrint());
    }
}
