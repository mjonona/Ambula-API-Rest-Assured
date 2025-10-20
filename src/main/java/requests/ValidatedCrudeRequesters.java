package requests;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.BaseModel;

public class ValidatedCrudeRequesters<T extends BaseModel> extends HTTPRequest implements CrudEndpointInterfaces {

    CrudeRequesters crudeRequesters;


    public ValidatedCrudeRequesters(RequestSpecification requestSpecification, Endpoint endpoint, ResponseSpecification responseSpecification) {
        super(requestSpecification, endpoint, responseSpecification);
        this.crudeRequesters = new CrudeRequesters(requestSpecification, endpoint, responseSpecification);
    }

    @Override
    public T post(BaseModel model, Object... params) {
        return (T) crudeRequesters.post(model, params).extract().as(endpoint.getResponseModel()) ;
    }

    @Override
    public T get(Object... params) {
        return (T) crudeRequesters.get(params).extract().as(endpoint.getResponseModel()) ;
    }

    @Override
    public Object update(BaseModel model, Object... params) {
        return null;
    }

    @Override
    public Object delete(Object... params) {
        return null;
    }
}
