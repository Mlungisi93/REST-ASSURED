package com.expleo.rest.StepDefs;

import com.expleo.rest.Steps.APIHeaderSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class APIHeaderStepDefs
{

    String baseURI = "http://restapi.demoqa.com/utilities/weather/city";
    String city = "Hyderabad";
    int returnCode = 201;
    String expectedStatusLine = "HTTP/1.2 300 LK";
    String contentType = "application/json";
    String serverType = "nginx/1.12.3";

    @Steps
    APIHeaderSteps steps;

    @Given("^I send a request to the api$")
    public void iSendARequestToTheApi()
    {
        steps.report(steps.getToBaseURI(baseURI,city));
    }

    @When("^the response is returned succesfully$")
    public void theResponseIsReturnedSuccesfully()
    {
        steps.report(steps.verifyHTTPreturnCode(returnCode));
        steps.getServerContentType(contentType);
        steps.getServer(serverType);
    }

    @Then("^verify the status line$")
    public void verifyTheStatusLine()
    {
        steps.report(steps.verifyStatusLine(expectedStatusLine));
    }
}
