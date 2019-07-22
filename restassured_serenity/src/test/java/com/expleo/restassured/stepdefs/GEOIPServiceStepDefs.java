package com.expleo.restassured.stepdefs;

import com.expleo.restassured.steps.CountryNameByISOCodeSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class GEOIPServiceStepDefs {
    String twoCharIsoCode = "ZA";
    String countryName = "South Africa";

    @Steps
    CountryNameByISOCodeSteps testSteps;

    @Given("^I am using valid two character ISO codes$")
    public void iAmUsingValidTwoCharacterISOCodes() {
 //Nothing really needed here
    }

    @When("^I submit a valid ISO code$")
    public void iSubmitAValidISOCode() {
        testSteps.submitAValid2CharIsoCodeAs(twoCharIsoCode, "[My New Rest Testing Product nedb, My New Rest Testing Product now, My New Rest Testing Product, Created Apple4, Created Apple3, Created Apple, Amazing Pillow 2.0 just created, Samsung Galaxy Tab 10.1, Sumsung J6 plus, Amazing Pillow and 200, Amazing Pillow and 200, Amazing Pillow and 200, Amazing Pillow and 200, Amazing Pillow 2.0, Amazing Pillow 2.0, Amazing Pillow 2.0 updated2, Rolex Watch, Bristol Shoes, Nike Shoes for Men, Amanda Waller Shirt, Wallet, Another product, Abercrombie Allen Brook Shirt, Abercrombie Lake Arnold Shirt, Huawei Y300, Spalding Watch, Lenovo Laptop, Google Nexus 4, Samsung Galaxy S4, Bench Shirt]");
    }

    @Then("^I recieve the correct country$")
    public void iRecieveTheCorrectCountry() {
        testSteps.iRecieveTheCorrectCountryNameAs("My New Rest Testing Product nedb","read.php");

    }
}
