package models.LoginModels;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import models.BaseModel;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserLoginRequestModel extends BaseModel {
    private String email;
    private String password;
}




