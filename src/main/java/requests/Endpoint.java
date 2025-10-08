package requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import models.BaseModel;
import models.Employees.AddEmployeesRequest;
import models.Employees.AddEmployeesResponse;
import models.LoginModels.CurrentUserResponseModel;
import models.LoginModels.UserLoginRequestModel;
import models.LoginModels.UserLoginResponseModel;
import models.patients.AddPatientResponse;
import models.patients.UpdatePatientRequest;

@AllArgsConstructor
@Getter
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

}
