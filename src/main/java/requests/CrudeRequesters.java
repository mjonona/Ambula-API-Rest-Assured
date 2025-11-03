package requests;

import allure.AllureSteps;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.BaseModel;
import requests.skeleton.CrudEndpointInterfaces;
import requests.skeleton.Endpoint;
import requests.skeleton.HTTPRequest;

import static io.restassured.RestAssured.given;

public class CrudeRequesters extends HTTPRequest implements CrudEndpointInterfaces {

    public CrudeRequesters(RequestSpecification requestSpecification, Endpoint endpoint, ResponseSpecification responseSpecification) {
        super(requestSpecification, endpoint, responseSpecification);
    }


    @Override
    public ValidatableResponse post(BaseModel model, String id) {

        String buildPathPost = String.format(endpoint.getUrl(), id);

        if (id != null ) {
            return AllureSteps.log("POST METHOD for path "+ buildPathPost, () -> {
                return given().spec(requestSpecification).body(model).when().post(buildPathPost).then().spec(responseSpecification);
            });
        }

        return AllureSteps.log("POST METHOD for path "+ endpoint.getUrl(), () -> {
            return given().spec(requestSpecification).body(model).when().post(endpoint.getUrl()).then().spec(responseSpecification);
        });
    }

    @Override
    public ValidatableResponse get(String id) {
        return AllureSteps.log("GET METHOD with path "+endpoint.getUrl(), () -> {
            String formattedUrl = String.format(endpoint.getUrl(), id);
            return given().spec(requestSpecification)
                    .when().get(formattedUrl)
                    .then().spec(responseSpecification);
        });
    }

    @Override
    public ValidatableResponse update(BaseModel model, String id) {
        return AllureSteps.log("UPDATE METHOD with path "+endpoint.getUrl(), () -> {
            String formattedUrl = String.format(endpoint.getUrl(), id);
            return given().spec(requestSpecification)
                    .body(model)
                    .when().patch(formattedUrl)
                    .then().spec(responseSpecification);
        });
    }


    @Override
    public ValidatableResponse delete(String id) {
        return AllureSteps.log("DELETE METHOD with path "+endpoint.getUrl(), () -> {
            String formattedUrl = String.format(endpoint.getUrl(), id);
            return null;
        });
    }


}

//        return given().spec(requestSpecification).body(model).when().post(endpoint.getUrl()).then().spec(responseSpecification);
//
//        return given().spec(requestSpecification).when().get(endpoint.getUrl()).then().spec(responseSpecification);
