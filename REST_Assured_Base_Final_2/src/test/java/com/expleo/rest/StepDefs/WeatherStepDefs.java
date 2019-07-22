package com.expleo.rest.StepDefs;

import com.expleo.rest.Steps.WeatherSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class WeatherStepDefs {

    String baseURI = "http://restapi.demoqa.com/utilities/weather/city";
    String city = "Hyderabad";
    @Steps
    WeatherSteps steps;

    @Given("^I send the URI$")
    public void iSendTheURI()
    {

       // steps = new WeatherSteps();
        steps.getToBaseURI(baseURI);
    }

    @When("^I send city name to the request$")
    public void iSendCityNameToTheRequest()
    {
        steps.sendCityNameToRequest(city);
    }

    @Then("^Response should contain name of city$")
    public void responseShouldContainNameOfCity()
    {
        steps.verifyReturnCode(200);
        steps.verifyCity(city);
    }
}
