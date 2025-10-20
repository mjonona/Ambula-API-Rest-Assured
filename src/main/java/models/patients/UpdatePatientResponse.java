package models.patients;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import config.Config;
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
@JsonIgnoreProperties(ignoreUnknown = true)

public class UpdatePatientResponse extends BaseModel {
    private String status;
    private Object meta;
    private AddPatientResponse.Content content;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Content {
        private String id;
        private String firstName;
        private String lastName;
        private String email;
        private String phoneNumber;
        // добавь сюда те поля, что реально приходят
    }
}
