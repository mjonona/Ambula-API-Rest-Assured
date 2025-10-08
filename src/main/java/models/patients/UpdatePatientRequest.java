package models.Employees;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import models.BaseModel;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = false)

public class UpdatePatientRequest extends BaseModel {

    private String firstName;
    private String lastName;
    private String phoneNUmber;
    private String email;



}
