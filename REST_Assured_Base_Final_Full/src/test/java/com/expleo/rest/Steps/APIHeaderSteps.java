package com.expleo.rest.Steps;

import cucumber.api.Scenario;
import gherkin.lexer.Ca;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.SerenityReports;
import net.serenitybdd.core.SerenitySystemProperties;
import net.serenitybdd.core.model.FailureDetails;
import net.serenitybdd.cucumber.SerenityReporter;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class APIHeaderSteps
{
    Response response;
    JsonPath jsonPath;

    @Step
    public String getToBaseURI(String baseURI, String city)
    {
        String message = "empty";

        try
        {
            response = SerenityRest.when().get(baseURI + "/" + city);
            assertThat(true,is(equalTo(response != null)));
            message = "API reached succesfully => \n Base URI = " + baseURI + " \n City = " + city;
        }
        catch (Exception e)
        {
            message = "API reached Failure \n Base URI = " + baseURI + " \n City = " + city;
        }
        return message;
    }


    @Step
    public String verifyHTTPreturnCode(int expectedReturnCode)
    {
        int statusCode = 0;
        String message = "empty";

        try
        {
           statusCode = response.getStatusCode();
           assertThat(expectedReturnCode,is(equalTo(statusCode)));
           message = "http return code AS Expected => " + statusCode;
        }
        catch (Exception e)
        {
            message = "http return code Failure \n Expected => " + expectedReturnCode
            + "\n Actual => " + statusCode;
        }
        catch (AssertionError e)
        {
            message = "http return code Failure \n Expected => " + expectedReturnCode
                    + "\n Actual => " + statusCode;
        }
        return message;
    }

    @Step
    public String verifyStatusLine(String expectedResponse)
    {
       String message = "empty";
       String statusLine = "empty";
       String httpProtocol;

       try
       {
           statusLine = response.getStatusLine();
           System.out.println(response.getStatusLine());
           assertThat(expectedResponse,is(equalTo(statusLine)));
           message = "StatusLine as Expected => " + statusLine;
          // Serenity.ignoredStep();
       }
       catch (AssertionError e)
       {
           message = "StatusLine Failure!  \nExpected => " + expectedResponse +
                   "\n Actual => " + statusLine;
          // Serenity.pendingStep(message);
          // Serenity.ignoredStep(message);
       }
       return message;
    }

    @Step
    public String getServerContentType(String expectedContentType)
    {
        String contentType = "empty";
        String message = "empty";

        try
        {
            //System.out.print("Content-Type 2 -- ");
            contentType = response.header("Content-Type");
            assertThat(expectedContentType,is(equalTo(contentType)));
            message = "Content Type read Succesfully -> " + contentType;
        }
        catch (AssertionError e)
        {
            message = "Content Type read Failure!    -> " +
            "\n Expected = " + expectedContentType +
            "\n Actual   = " + contentType;
        }
        return message;
    }

    @Step
    public String getServer(String expectedServer)
    {
        String message = "empty";
        String serverType = "empty";

        try
        {
            serverType = response.header("Server");
            assertThat(expectedServer,is(serverType));
            message = "Server Type as Expected -> " + serverType;
        }
        catch (AssertionError e)
        {
            message = "Server Type read Failure! " +
                    "\n Expected = " + expectedServer +
                    "\n Actual   = " + serverType;
            //Serenity.pendingStep("Assertion Failure");
        }
        return message;
    }

    @Step
    public String report(String message)
    {
        return message;
    }
}
