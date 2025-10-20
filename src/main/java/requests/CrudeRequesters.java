package requests;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.BaseModel;

import static io.restassured.RestAssured.given;

public class CrudeRequesters extends HTTPRequest  implements CrudEndpointInterfaces {

    public CrudeRequesters(RequestSpecification requestSpecification, Endpoint endpoint, ResponseSpecification responseSpecification) {
        super(requestSpecification, endpoint, responseSpecification);
    }

    @Override
    public ValidatableResponse post(BaseModel model, Object... params) {
        String formattedUrl = String.format(endpoint.getUrl(), params);
        return given().spec(requestSpecification).body(model).when().post(formattedUrl).then().spec(responseSpecification);
    }

    @Override
    public ValidatableResponse get(Object... params) {
        String formattedUrl = String.format(endpoint.getUrl(), params);
        return null;
    }

    @Override
    public ValidatableResponse update(BaseModel model, Object... params) {
        String formattedUrl = String.format(endpoint.getUrl(), params);
        return null;
    }

    @Override
    public ValidatableResponse delete(Object... params) {
        String formattedUrl = String.format(endpoint.getUrl(), params);
        return null;
    }
}

//        return given().spec(requestSpecification).body(model).when().post(endpoint.getUrl()).then().spec(responseSpecification);
//
//        return given().spec(requestSpecification).when().get(endpoint.getUrl()).then().spec(responseSpecification);
