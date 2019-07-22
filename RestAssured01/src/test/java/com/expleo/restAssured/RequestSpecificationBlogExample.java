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

public class RequestSpecificationBlogExample {
    private static RequestSpecBuilder builderReq;
    private static RequestSpecification requestSpec;
    private static ResponseSpecification responseSpec;
    private static ResponseSpecBuilder builderResp;


    @BeforeClass
    public static void init()
    {
     builderReq = new RequestSpecBuilder();
     requestSpec = builderReq
             .setBaseUri("http://10.9.10.139:3000")
             .setBasePath("posts")
             .build();


    }

    @Test
    public void test001()
    {
        System.out.println("------------ Checking requestSpec ------------------------");
        requestSpec = given(requestSpec).log().all();
        requestSpec.when()
                .get("1")
                .then()
                .log()
                .headers();
        //Response response = given(requestSpec, re)

        System.out.println("------------ Checking responseSpec --------------");
        builderResp = new ResponseSpecBuilder();
        responseSpec = builderResp
                .expectStatusCode(200)
                .expectBody("title", equalTo("Training"))
                .build();

        Response response = given(requestSpec.when().log().body(), responseSpec).get("1");
        System.out.println("Response = "+response.then().log().body());;
        //System.out.println(response.body().prettyPrint());
    }
}
