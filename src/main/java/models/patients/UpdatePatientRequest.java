package models.patients;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import models.BaseModel;
import net.datafaker.Faker;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = false)

public class UpdatePatientRequest extends BaseModel {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    public static UpdatePatientRequest getUpdatePatientModel() {


        Faker faker =new Faker();
        String upFName=faker.name().firstName();
        String upLName=faker.name().lastName();


        return UpdatePatientRequest.builder()
                .firstName(upFName)
                .lastName(upLName)
                .phoneNumber("+18888888880")
                .build();

    }



}
