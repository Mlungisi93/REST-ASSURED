package com.expleo.rest.Steps;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class APIBodySteps
{

    Response response;
    JsonPath jsonPath;

    @Step
    public String getToBaseURL(String baseURL, String city)
    {

        String message = "empty";

        try
        {
            response = SerenityRest.when().get(baseURL + "/" + city);
            message = "Base URL reached Successfully " +
                    "\n Base URL -> " + baseURL +
                    "\n City     -> " + city;
        }
        catch (Exception r)
        {
            message = "Base URL NOT reached, Failure " +
                    "\n Base URL -> " + baseURL +
                    "\n City     -> " + city;
        }
        return message;
    }
}
