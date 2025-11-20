package requests;

import allure.AllureSteps;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.BaseModel;
import requests.skeleton.CrudEndpointInterfaces;
import requests.skeleton.Endpoint;
import requests.skeleton.HTTPRequest;

import java.util.Arrays;

import static io.restassured.RestAssured.given;

public class CrudeRequesters extends HTTPRequest implements CrudEndpointInterfaces {

    public CrudeRequesters(RequestSpecification requestSpecification, Endpoint endpoint, ResponseSpecification responseSpecification) {
        super(requestSpecification, endpoint, responseSpecification);
    }


    @Override
    public ValidatableResponse post(String medicalCenterID, BaseModel model, String... id) {

        if (id == null) {
            String buildPathPost = String.format(endpoint.getUrl(), medicalCenterID);
            return AllureSteps.log("POST METHOD for path "+ buildPathPost, () -> {
                return given().spec(requestSpecification).body(model).when().post(buildPathPost).then().spec(responseSpecification);
            });
        }
        String buildPathPost = String.format(endpoint.getUrl(), medicalCenterID, id);
        return AllureSteps.log("POST METHOD for path " + buildPathPost, () -> {
            return given().spec(requestSpecification).body(model).when().post(buildPathPost).then().spec(responseSpecification);
        });
    }


    @Override
    public ValidatableResponse get(String medicalCenterID, String id) {

        if (id == null) {
            String buildPathGet = String.format(endpoint.getUrl(), medicalCenterID);
            return AllureSteps.log("Get data from "+endpoint.getUrl(), () -> {
                return given().spec(requestSpecification).when().get(buildPathGet).then().spec(responseSpecification);
            });
        }

        return AllureSteps.log("GET METHOD with path "+endpoint.getUrl(), () -> {
            String formattedUrl = String.format(endpoint.getUrl(), medicalCenterID, id);
            return given().spec(requestSpecification)
                    .when().get(formattedUrl)
                    .then().spec(responseSpecification);
        });
    }


    @Override
    public ValidatableResponse update(String medicalCenterID, BaseModel model, String... id) {

        if (id == null) {
            String buildPathUpdate = String.format(endpoint.getUrl(), medicalCenterID);
            return AllureSteps.log("Update with path "+endpoint.getUrl(), () -> {
                return given().spec(requestSpecification).body(model).when().put(buildPathUpdate).then().spec(responseSpecification);
            });
        }

        return AllureSteps.log("UPDATE METHOD with path "+endpoint.getUrl(), () -> {
            String formattedUrl = String.format(endpoint.getUrl(), medicalCenterID, id);
            return given().spec(requestSpecification)
                    .body(model)
                    .when().put(formattedUrl)
                    .then().spec(responseSpecification);
        });
    }


    @Override
    public Object patch(String medicalCenterID, BaseModel model, String id) {
        if (id == null) {
            String buildPathUpdate = String.format(endpoint.getUrl(), medicalCenterID);
            return AllureSteps.log("Update with path "+endpoint.getUrl(), () -> {
                return given().spec(requestSpecification).body(model).when().patch(buildPathUpdate).then().spec(responseSpecification);
            });
        }
        return AllureSteps.log("UPDATE METHOD with path "+endpoint.getUrl(), () -> {
            String formattedUrl = String.format(endpoint.getUrl(), medicalCenterID, id);
            return given().spec(requestSpecification)
                    .body(model)
                    .when().patch(formattedUrl)
                    .then().spec(responseSpecification);
        });
    }


    @Override
    public ValidatableResponse delete(String medicalCenterID, String id) {

        String buildPathDelete = String.format(endpoint.getUrl(), medicalCenterID, id);
        return AllureSteps.log("DELETE METHOD with path "+endpoint.getUrl(), () -> {
            return given().spec(requestSpecification).when().delete(buildPathDelete).then().spec(responseSpecification);
        });
    }
}

