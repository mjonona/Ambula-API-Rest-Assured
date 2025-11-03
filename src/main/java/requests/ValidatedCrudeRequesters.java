package requests;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.BaseModel;
import requests.skeleton.CrudEndpointInterfaces;
import requests.skeleton.Endpoint;
import requests.skeleton.HTTPRequest;

public class ValidatedCrudeRequesters<T extends BaseModel> extends HTTPRequest implements CrudEndpointInterfaces {

    CrudeRequesters crudeRequesters;


    public ValidatedCrudeRequesters(RequestSpecification requestSpecification, Endpoint endpoint, ResponseSpecification responseSpecification) {
        super(requestSpecification, endpoint, responseSpecification);
        this.crudeRequesters = new CrudeRequesters(requestSpecification, endpoint, responseSpecification);
    }

    @Override
    public T post(BaseModel model, String id) {
        String postPath = String.format(endpoint.getUrl(), id);
        return (T) crudeRequesters.post(model, postPath).extract().as(endpoint.getResponseModel()) ;
    }

    @Override
    public T get(String id) {
        return (T) crudeRequesters.get(id).extract().as(endpoint.getResponseModel()) ;
    }

    @Override
    public Object update(BaseModel model, String id) {
        return null;
    }

    @Override
    public Object delete(String id) {
        return null;
    }
}
