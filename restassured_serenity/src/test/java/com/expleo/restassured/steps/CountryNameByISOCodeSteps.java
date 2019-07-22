package com.expleo.restassured.steps;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import net.thucydides.core.annotations.Step;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class CountryNameByISOCodeSteps {
    private RequestSpecification reqSpec;
    private ResponseSpecification respSpec;

    @Step
    public void submitAValid2CharIsoCodeAs(String twoCharIsoCode, String countryName) {
        setReqSpec(twoCharIsoCode);
        setRespSpec(countryName);
    }

  @Step
    private void setReqSpec(String code) {
        reqSpec = new RequestSpecBuilder()
                .setBaseUri("http://services.groupkt.com")
                .setBasePath("/country/get/iso2code/")
                //.addPathParam("code",code) // TODO Remover if not required
                .build();
    }
 @Step
    private void setRespSpec(String expectedPathValue) {
   respSpec = new ResponseSpecBuilder()
           .expectStatusCode(200)
           .expectBody("RestResponse.result.name", equalTo(expectedPathValue))
           .build();
    }

    @Step("{0}")
    public void iRecieveTheCorrectCountryNameAs(String coName, String countryCode) {

        Response response = given(reqSpec, respSpec)
                .get(countryCode);
        response.then().log().all();

    }
}
