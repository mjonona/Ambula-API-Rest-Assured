package api;

import config.Config;
import models.loginModels.CurrentUserResponseModel;
import models.loginModels.UserLoginRequestModel;
import models.loginModels.UserLoginResponseModel;
import org.junit.jupiter.api.Test;
import requests.CrudeRequesters;
import requests.skeleton.Endpoint;
import specs.RequestSpecs;
import specs.ResponseSpecs;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginUserTest extends BaseTest {

    @Test
    public void userLoginTest() {
        String medicalID = Config.getProperty("medicalCenterId");
        UserLoginRequestModel model = UserLoginRequestModel.builder().email("admin1x@mailinator.com").password("Tester09!").build();
        UserLoginResponseModel userLoginResponseModel = new CrudeRequesters(RequestSpecs.unAuth(), Endpoint.USER_LOGIN, ResponseSpecs.requestWasSuccess()).post(model, medicalID).extract().as(UserLoginResponseModel.class);
        System.out.println(userLoginResponseModel);


    }

    @Test
    public void currentMedicalCenterSetting() {

        String medicalID = Config.getProperty("medicalCenterId");
        CurrentUserResponseModel currentUserResponseModel = new CrudeRequesters(RequestSpecs.adminSpecs(), Endpoint.CURRENT_USER, ResponseSpecs.requestWasSuccess()).get(medicalID).extract().as(CurrentUserResponseModel.class);
        System.out.println(currentUserResponseModel);
    }
}
