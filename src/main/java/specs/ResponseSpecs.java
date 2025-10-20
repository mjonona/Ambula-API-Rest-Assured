package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import models.patients.AddPatientResponse;
import org.apache.http.HttpStatus;
import requests.CrudeRequesters;
import requests.Endpoint;

public class ResponseSpecs {

    private static ResponseSpecBuilder defaultResponse() {
        return new ResponseSpecBuilder();
    }

    public static ResponseSpecification requestWasSuccess() {
        return defaultResponse().expectStatusCode(HttpStatus.SC_OK).build();
    }

    public static ResponseSpecification requestWasCreated() {
        return defaultResponse().expectStatusCode(HttpStatus.SC_CREATED).build();
    }
    public static ResponseSpecification requestNoContent() {
        return new ResponseSpecBuilder().expectStatusCode(204).build();


    }

}
