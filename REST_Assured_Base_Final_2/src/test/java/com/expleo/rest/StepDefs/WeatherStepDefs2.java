package com.expleo.rest.StepDefs;

import com.expleo.rest.Steps.WeatherSteps2;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class WeatherStepDefs2
{

    String baseURI = "http://restapi.demoqa.com/utilities/weather/city";
    String city = "Hyderabad";

    @Steps
    WeatherSteps2 steps2;


    @Given("^I send the URIs$")
    public void iSendTheURIs()
    {
        steps2.getToBaseURI(baseURI,city);
    }

    @When("^I send cities name to the request$")
    public void iSendCitiesNameToTheRequest()
    {
        steps2.verifyReturnCode(200);
    }

    @Then("^the Response should contain the cities name$")
    public void theResponseShouldContainTheCitiesName()
    {
        steps2.verifyReturnCity(city);
    }
}
