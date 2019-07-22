package com.expleo.rest.StepDefs;

import com.expleo.rest.Steps.APIBodySteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class APIBodyStepDefs
{
    String baseURL = "http://restapi.demoqa.com/utilities/weather/city";
    String city = "Hyderabad";
    int expectedHTTPreturnCode = 200;
    @Steps
    APIBodySteps steps;

    @Given("^I send a request to the server$")
    public void iSendARequestToTheServer()
    {
        steps.getToBaseURL(baseURL,city);
    }

    @When("^I should get a sucessful response$")
    public void iShouldGetASucessfulResponse()
    {

    }

    @Then("^I should verify data$")
    public void iShouldVerifyData() {
    }
}
