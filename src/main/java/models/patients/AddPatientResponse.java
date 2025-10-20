package models.patients;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import models.BaseModel;

/**
 * Модель ответа на создание пациента.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddPatientResponse extends BaseModel {
    private String status;
    private Object meta;
    private Content content;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Content {
        private String firstName;
        private String lastName;
        private String middleName;
        private String suffix;
        private String gender;
        private String birthday;

        private String address;
        private String city;
        private String state;
        private String zipCode;

        private String photo;
        private String notes;

        private String id;
        private String createdAt;          // например: "2025-10-09T11:51:44.547Z"
        private String updatedAt;

        private String medicalCenterId;
        private String branchId;
        private String appType;

        private String email;
        private Integer medicalId;
        private String ssn;

        private String emergencyContactName;
        private String emergencyContactPhone;

        private String lawFirmId;
        private String lawyerId;

        private String caseManagerId;
        private String caseManagerName;
        private String caseManagerEmail;

        private String sendLienToId;
        private String dateOfInjury;
        private String accidentType;

        private String additionalEmails;
        private String tags;
        private String referralSource;
        private String referralName;

        private boolean shareReports;
        private String reminderLanguage;
        private String surgeonId;
        private String chartTypeId;
        private String reasonForVisit;
        private boolean sendScheduleLink;

        // 🔹 Добавлено поле из предыдущего объекта-запроса
        private String phoneNumber;
    }
}
