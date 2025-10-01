package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

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
}
