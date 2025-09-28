package requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import models.BaseModel;
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
            BaseModel.class,
            BaseModel.class
    ),
    CURRENT_USER (
            "/auth/current",
            BaseModel.class,
            CurrentUserResponseModel.class
    );



    // request specs header

    // url path
    // request model
    // response model

    //  respoonse specs status.code


    private final String url;
    private final Class<? extends BaseModel> requestModel;
    private final Class<? extends BaseModel> responseModel;

}
