package api;

import models.LoginModels.CurrentUserResponseModel;
import models.LoginModels.UserLoginRequestModel;
import models.LoginModels.UserLoginResponseModel;
import org.junit.jupiter.api.Test;
import requests.CrudeRequesters;
import requests.Endpoint;
import specs.RequestSpecs;
import specs.ResponseSpecs;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginUserTest extends BaseTest {

    @Test
    public void userLoginTest() {
        UserLoginRequestModel model = UserLoginRequestModel.builder().email("admin1x@mailinator.com").password("Tester09!").build();
        UserLoginResponseModel userLoginResponseModel = new CrudeRequesters(RequestSpecs.unAuth(), Endpoint.USER_LOGIN, ResponseSpecs.requestWasSuccess()).post(model).extract().as(UserLoginResponseModel.class);
        System.out.println(userLoginResponseModel);
    }

    @Test
    public void currentMedicalCenterSetting() {
        CurrentUserResponseModel currentUserResponseModel = new CrudeRequesters(RequestSpecs.adminSpecs(), Endpoint.CURRENT_USER, ResponseSpecs.requestWasSuccess()).get().extract().as(CurrentUserResponseModel.class);
        System.out.println(currentUserResponseModel);
    }
}
