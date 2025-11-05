package models.loginModels;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import models.BaseModel;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserLoginResponseModel extends BaseModel {
    private String accessToken;
    private String refreshToken;
    private String type;
}
