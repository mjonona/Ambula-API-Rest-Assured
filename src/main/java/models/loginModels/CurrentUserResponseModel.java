package models.loginModels;

import models.BaseModel;

import lombok.Data;
import java.util.List;

@Data
public class CurrentUserResponseModel extends BaseModel {
    private String status;
    private Object meta; // можно заменить на отдельную модель, если структура фиксированная
    private Content content;

    @Data
    public static class Content {
        private String firstName;
        private String lastName;
        private String gender;
        private String birthday;
        private String address;
        private String city;
        private String state;
        private String zipCode;
        private String phoneNumber;
        private String photo;
        private String notes;
        private String id;
        private String createdAt;
        private String updatedAt;
        private String email;
        private String role;
        private String npi;
        private String ein;
        private List<Weekday> weekdays;
        private String pinCode;
        private String medicalCenterId;
        private MedicalCenter medicalCenter;
        private List<String> platforms;
        private List<String> branchesId;
        private List<String> permissions;
        private Settings settings;
        private String deletedAt;
        private boolean isBillingProviderSameAsProvider;
        private boolean isDailySchedule;
        private String timezone;
        private String positionTitle;
        private List<String> specialities;
        private String profileImageName;
        private String profileInformation;
    }

    @Data
    public static class Weekday {
        private boolean checked;
        private String startTime;
        private String endTime;
    }

    @Data
    public static class MedicalCenter {
        private String id;
        private String phoneNumber;
        private String email;
        private List<String> specialities;
        private int type;
        private String name;
        private List<String> appTypes;
        private String bookingId;
        private int plan;
        private String logoPath;
        private String notificationEmail;
        private boolean canNotify;
        private boolean onlyAdminCanAddTemplates;
        private boolean hideReports;
        private boolean hidePdfPageFooter;
        private boolean requiredDemographics;
        private boolean requiredAttorney;
        private String address;
        private String city;
        private String state;
        private String zipCode;
        private String faxNumber;
        private String aiSummarizeInstruction;
        private int timezone;
        private String facility;
        private WorkingHours workingHours;
        private Object settings; // или отдельная модель
        private List<VisitStatus> visitStatuses;
        private String bannerImagePath;
        private int branchCount;
        private String bannerImageName;
        private String profileImagePath;
        private String profileImageName;
        private String profileInformation;
        private boolean hasTelehealth;
        private String website;
        private List<String> languages;
    }

    @Data
    public static class WorkingHours {
        private String startTime;
        private String endTime;
    }

    @Data
    public static class VisitStatus {
        private int status;
        private String color;
    }

    @Data
    public static class Settings {
        private RxUserSettings rxUserSettings;
        private UserEmailSettings userEmailSettings;
    }

    @Data
    public static class RxUserSettings {
        private String userId;
        private String password;
    }

    @Data
    public static class UserEmailSettings {
        private String domain;
        private String email;
        private String password;
    }
}