package specs;

import config.Config;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import models.LoginModels.UserLoginRequestModel;
import models.LoginModels.UserLoginResponseModel;
import requests.CrudeRequesters;
import requests.Endpoint;

import java.util.List;

public class RequestSpecs {

    private static RequestSpecBuilder defaultRequest() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .addHeader("emr-app-type", "office")
                .setBaseUri(Config.getProperty("baseUrl"))
                .addFilters(List.of(new RequestLoggingFilter(), new ResponseLoggingFilter()));
    }

    public static RequestSpecification unAuth() {
        return defaultRequest().build();
    }

    public static RequestSpecification adminSpecs() {
        UserLoginRequestModel model = UserLoginRequestModel.builder().email(Config.getProperty("adminEmail")).password(Config.getProperty("adminPassword")).build();
        UserLoginResponseModel userData = new CrudeRequesters(RequestSpecs.unAuth(), Endpoint.USER_LOGIN, ResponseSpecs.requestWasSuccess()).post(model).extract().as(UserLoginResponseModel.class);
        String token = userData.getType().toUpperCase()+" "+userData.getAccessToken();
        return defaultRequest().addHeader("Authorization", token).build();
    }

    public static RequestSpecification userSpecs(String email, String password) {
        UserLoginRequestModel model = UserLoginRequestModel.builder().email(email).password(password).build();
        UserLoginResponseModel userData = new CrudeRequesters(RequestSpecs.unAuth(), Endpoint.USER_LOGIN, ResponseSpecs.requestWasSuccess()).post(model).extract().as(UserLoginResponseModel.class);
        String token = userData.getType()+" "+userData.getAccessToken();
        return defaultRequest().addHeader("Authorization", token).build();
    }
}
