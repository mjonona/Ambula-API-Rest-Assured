package models.employees;

import config.Config;
import config.data.Platforms;
import config.data.TimeZone;
import config.data.UserPermission;
import config.data.UserRole;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import models.BaseModel;
import net.datafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

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


    public static AddEmployeesRequest getEmployer() {

        Faker faker = new Faker();

        String password = RandomStringUtils.randomAlphabetic(2).toUpperCase() +
                RandomStringUtils.randomAlphabetic(4).toLowerCase() +
                RandomStringUtils.randomAlphanumeric(2).toUpperCase() + "!";

        return AddEmployeesRequest.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .phoneNumber("8888888888")
                .password(password)
                .confirmPassword(password)
                .platforms(List.of(Platforms.office.toString(), Platforms.asc.toString(), Platforms.billing.toString()))
                .branchesId(List.of(Config.getProperty("branchId1"), Config.getProperty("branchId2"), Config.getProperty("branchId3"), Config.getProperty("branchId4")))
                .timezone(TimeZone.getDefaultDenverTimeZone())
                .role(UserRole.SURGEON.toString())
                .permissions(List.of(UserPermission.ADMIN.toString(), UserPermission.SURGEON.toString()))
                .medicalCenterId(Config.getProperty("medicalCenterId"))
                .status("approved")
                .billingProviderSameAsProvider(true).build();
    }
}
