package com.expleo.rest.Steps;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class WeatherSteps2
{
    Response response;
    JsonPath jsonPath;

    @Step("I send the baseURI as {0} and \ncity as {1}")
    public void getToBaseURI(String baseURI, String city)
    {
        response =SerenityRest.when().get(baseURI + "/" + city);

    }

    @Step("Verify the Expected {0} http return code")
    public void verifyReturnCode(int expected)
    {
        int r;

        r = response.getStatusCode();
        //response.then().statusCode(expected);
        System.out.println("Status Line " + response.getStatusLine() + "\n");

        assertThat(expected,is(equalTo(r)));
    }


    @Step("Verify the Expected \"{0}\" city returned from Query")
    public void verifyReturnCity(String expectedCity)
    {
        jsonPath = response.jsonPath();
        String city = jsonPath.get("City");

        System.out.println("City is => " + city);
        assertThat(expectedCity,is(equalTo(city)));
    }


}
