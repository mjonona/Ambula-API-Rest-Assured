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
    public T post(String medicalCenterID, BaseModel model, String... id) {
        return (T) crudeRequesters.post(medicalCenterID, model, id).extract().as(endpoint.getResponseModel());
    }

    @Override
    public T get(String medicalCenterID, String id) {
        return (T) crudeRequesters.get(medicalCenterID, id).extract().as(endpoint.getResponseModel());
    }

    @Override
    public T update(String medicalCenterID, BaseModel model, String... id) {
        return (T) crudeRequesters.update(medicalCenterID, model, id).extract().as(endpoint.getResponseModel())  ;
    }

    @Override
    public T patch(String medicalCenterID, BaseModel model, String id) {
        return (T) crudeRequesters.patch(medicalCenterID, model, id) ;
    }

    @Override
    public T delete(String medicalCenterID, String id) {
        return (T) crudeRequesters.delete(medicalCenterID, id) ;
    }
}
