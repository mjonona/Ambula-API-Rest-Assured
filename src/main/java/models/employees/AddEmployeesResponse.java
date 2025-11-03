package models.employees;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import models.BaseModel;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@JsonIgnoreProperties(ignoreUnknown = true)
public class AddEmployeesResponse extends BaseModel {
    private String status;
    private Object meta;
    private Content content;    // payload, bellow

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    //@JsonIgnoreProperties(ignoreUnknown = true)
    public static class Content {
        private String firstName;
        private String lastName;
        private String gender;
        private String birthday;
        private String address;
        private String city;
        private String state;
        private String zipCode;
        private String photo;
        private String notes;

        private String id;
        private String createdAt;
        private String updatedAt;

        private String email;
        private String phoneNumber;
        private String role;
        private String npi;
        private String ein;

        private List<Weekday> weekdays;

        private String pinCode;
        private String medicalCenterId;

        private List<String> platforms;

        @JsonProperty("branchesId")
        private List<String> branchesId;

        private List<String> permissions;

        private Object settings;
        private String deletedAt;

        @JsonProperty("isBillingProviderSameAsProvider")
        private boolean billingProviderSameAsProvider;

        @JsonProperty("isDailySchedule")
        private boolean dailySchedule;

        private String timezone;
        private String positionTitle;
        private String specialities;
        private String profileImageName;
        private String profileInformation;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    //@JsonIgnoreProperties(ignoreUnknown = true)
    public static class Weekday {
        private boolean checked;
        private String startTime;
        private String endTime;
        @JsonProperty("branchesId")
        private List<String> branchesId;
    }
}
