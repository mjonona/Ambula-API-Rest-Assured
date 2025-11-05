package requests.skeleton;

import models.BaseModel;
import models.employees.AddEmployeesRequest;
import models.employees.AddEmployeesResponse;
import models.employees.UpdatePatientRequest;
import models.loginModels.CurrentUserResponseModel;
import models.loginModels.UserLoginRequestModel;
import models.loginModels.UserLoginResponseModel;
import models.patients.AddPatientResponse;

public enum Endpoint {

    USER_LOGIN (
            "/auth/login",
            UserLoginRequestModel.class,
            UserLoginResponseModel.class
    ),
    ADD_EMPLOYEE (
            "/medical-centers/%s/employees",
            AddEmployeesRequest.class,
            AddEmployeesResponse.class
    ),
    UPDATE_PATIENT(
            "/medical-centers/%s/patients/%s",
            UpdatePatientRequest.class,
            AddPatientResponse.class
            ),
    GET_PATIENT("/medical-centers/%s/patients/%s",
            BaseModel.class,
            models.patients.AddPatientResponse.class),

    CURRENT_USER (
            "/auth/current",
            BaseModel.class,
            CurrentUserResponseModel.class
    ),
    ADD_PATIENT (
            "/medical-centers/%s/patients",
            models.patients.AddPatientRequest.class,
            AddEmployeesResponse.class
    );


    private final String url;
    private final Class<? extends BaseModel> requestModel;
    private final Class<? extends BaseModel> responseModel;


    Endpoint(String url, Class<? extends BaseModel> requestModel, Class<? extends BaseModel> responseModel) {
        this.url = url;
        this.requestModel = requestModel;
        this.responseModel = responseModel;
    }

    public String getUrl() {
        return url;
    }

    public Class<? extends BaseModel> getRequestModel() {
        return requestModel;
    }

    public Class<? extends BaseModel> getResponseModel() {
        return responseModel;
    }
}
