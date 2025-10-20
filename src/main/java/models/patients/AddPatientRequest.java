package models.patients;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import models.BaseModel;
import net.datafaker.Faker;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddPatientRequest extends BaseModel {
    private String firstName;
    private String lastName;
    private String birthday;
    private String branchId;
    private boolean sendSchedulingSequence;
    private String phoneNumber;
    private String lawFirmId;
    private String lawFirmName;
    private String lawyerId;
    private String lawyerName;
    private String caseManagerId;
    private String caseManagerName;

    /**
     * Возвращает пример объекта AddPatientRequest
     */
    public static AddPatientRequest getAddPatientModel() {

        Faker faker =new Faker();
        return AddPatientRequest.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .birthday("2025-10-01")
                .branchId("040167e8-5c57-4546-8753-0b32985133ec")
                .sendSchedulingSequence(false)
                .phoneNumber("18888888888")
                .lawFirmId(null)
                .lawFirmName(null)
                .lawyerId(null)
                .lawyerName(null)
                .caseManagerId(null)
                .caseManagerName(null)
                .build();
    }

public class AddPatientRequest {
}
