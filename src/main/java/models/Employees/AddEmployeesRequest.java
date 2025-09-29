package models.Employees;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import models.BaseModel;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class AddEmployeesRequest extends BaseModel {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    private String password;
    private String confirmPassword;

    @Singular("platform")
    private List<String> platforms;

    @JsonProperty("branchesId")
    @Singular("branchId")
    private List<String> branchesId;

    private String timezone;
    private String role;

    @Singular("permission")
    private List<String> permissions;

    @JsonProperty("isBillingProviderSameAsProvider")
    private boolean billingProviderSameAsProvider;

    private String medicalCenterId;
    private String status;


}
