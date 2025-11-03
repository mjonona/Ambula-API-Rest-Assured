package requests;

import allure.AllureSteps;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.BaseModel;
import requests.skeleton.CrudEndpointInterfaces;
import requests.skeleton.Endpoint;

import static io.restassured.RestAssured.given;

public class CrudeRequesters  implements CrudEndpointInterfaces {

    private final RequestSpecification requestSpecification;
    private final Endpoint endpoint;
    private final ResponseSpecification responseSpecification;


    public CrudeRequesters(RequestSpecification requestSpecification, Endpoint endpoint, ResponseSpecification responseSpecification) {

        this.requestSpecification = requestSpecification;
        this.endpoint = endpoint;
        this.responseSpecification = responseSpecification;
    }

    @Override
    public ValidatableResponse post(BaseModel model, Object... params) {
        if (params == null || params.length == 0) {
            return AllureSteps.log("POST METHOD for path "+ endpoint.getUrl(), () -> {
                return given().spec(requestSpecification).body(model).when().post(endpoint.getUrl()).then().spec(responseSpecification);
            });
        }

        return AllureSteps.log("POST METHOD for path "+ endpoint.getUrl(), () -> {
            String formattedUrl = String.format(endpoint.getUrl(), params);
            return given().spec(requestSpecification).body(model).when().post(formattedUrl).then().spec(responseSpecification);
        });
    }

    // requests/CrudeRequesters.java
    private String url(Object... params) {
        return (params == null || params.length == 0)
                ? endpoint.getUrl()
                : String.format(endpoint.getUrl(), params);
    }

    @Override
    public ValidatableResponse get(Object... params) {
        return AllureSteps.log("GET METHOD with path "+endpoint.getUrl(), () -> {
            String formattedUrl = String.format(endpoint.getUrl(), params);
            return given().spec(requestSpecification)
                    .when().get(formattedUrl)
                    .then().spec(responseSpecification);
        });
    }

    @Override
    public ValidatableResponse update(BaseModel model, Object... params) {
        return AllureSteps.log("UPDATE METHOD with path "+endpoint.getUrl(), () -> {
            String formattedUrl = String.format(endpoint.getUrl(), params);
            return given().spec(requestSpecification)
                    .body(model)
                    .when().patch(formattedUrl)
                    .then().spec(responseSpecification);
        });
    }


    @Override
    public ValidatableResponse delete(Object... params) {
        return AllureSteps.log("DELETE METHOD with path "+endpoint.getUrl(), () -> {
            String formattedUrl = String.format(endpoint.getUrl(), params);
            return null;
        });
    }


}

//        return given().spec(requestSpecification).body(model).when().post(endpoint.getUrl()).then().spec(responseSpecification);
//
//        return given().spec(requestSpecification).when().get(endpoint.getUrl()).then().spec(responseSpecification);
