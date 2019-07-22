package com.expleo.rest.Steps;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class WeatherSteps
{

    RequestSpecification requestSpecification;
    Response response;

    @Step
    public void getToBaseURI(String baseURI)
    {
        //Specify the base URL to the RESTful web services
        RestAssured.baseURI = baseURI;

        //Get the RequestSpecification of the request that you want to sent
        //to the server. The server is specified by the BaseURI that we have
        //specified in the above step.
        requestSpecification = RestAssured.given();
       // response = SerenityRest.when().request(Method.GET,baseURI + "/" + ci);
        //response = SerenityRest.when().get(baseURI + ci);
        //System.out.println("Re  " + response.getBody());

       /* response = SerenityRest.when().get(baseURI + "/" + ci);
        response.then().extract().headers();
        response.getBody().asString();*/

    }

    @Step
    public void sendCityNameToRequest(String cityName)
    {
        //response.then().statusCode(200);
        response = requestSpecification.get("/" + cityName.trim());
       // System.out.println("Response Body is =>  " + response.asString());
        System.out.println(response.getHeaders());
    }

    @Step
    public void verifyReturnCode(int expected)
    {
        int statusCode;

        statusCode = response.getStatusCode();
        System.out.println("Status Code " + statusCode);
        assertThat(expected, equalTo(statusCode));

    }

    @Step
    public void verifyCity(String expectedCity)
    {
        String bodyAsString = response.getBody().asString();

        assertThat(bodyAsString.contains(expectedCity),equalTo(true));
    }
}
