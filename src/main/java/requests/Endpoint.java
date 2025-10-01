package requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import models.BaseModel;
import models.Employees.AddEmployeesRequest;
import models.Employees.AddEmployeesResponse;
import models.LoginModels.CurrentUserResponseModel;
import models.LoginModels.UserLoginRequestModel;
import models.LoginModels.UserLoginResponseModel;

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
    CURRENT_USER (
            "/auth/current",
            BaseModel.class,
            CurrentUserResponseModel.class
    );

    private final String url;
    private final Class<? extends BaseModel> requestModel;
    private final Class<? extends BaseModel> responseModel;

}
