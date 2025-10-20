package api.patients;

import api.BaseTest;
import config.Config;
import io.restassured.response.ValidatableResponse;
import models.Employees.UpdatePatientRequest;
import models.patients.AddPatientRequest;
import models.patients.AddPatientResponse;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import requests.CrudeRequesters;
import requests.Endpoint;
import specs.RequestSpecs;
import specs.ResponseSpecs;

public class PatientCrudeTest extends BaseTest {
    private final String MC_ID = Config.getProperty("medicalCenterId");

    @Test
    void create_then_update_patient() {

        //Create

        AddPatientRequest addReq = AddPatientRequest.getAddPatientModel();

        ValidatableResponse createdV = new CrudeRequesters(RequestSpecs.adminSpecs(), Endpoint.ADD_PATIENT, ResponseSpecs.requestWasCreated()).post(addReq, MC_ID);


        AddPatientResponse created = createdV.extract().as(AddPatientResponse.class);
        String patientId = created.getContent().getId();

        //Update

        UpdatePatientRequest upReq = UpdatePatientRequest.getUpdatePatientModel();
        ValidatableResponse updated = new CrudeRequesters(
                RequestSpecs.adminSpecs(),
                Endpoint.UPDATE_PATIENT,
                ResponseSpecs.requestWasSuccess()
        ).update(upReq, MC_ID, patientId);

        //Get

        AddPatientResponse got = new CrudeRequesters(
                RequestSpecs.adminSpecs(),
                Endpoint.GET_PATIENT,
                ResponseSpecs.requestWasSuccess()
        ).get(MC_ID, patientId)
                .extract().as(AddPatientResponse.class);

        softly.assertThat(got.getContent().getId()).isEqualTo(patientId);

    }

    @Test

    public void updatePat() {

        //Create

        AddPatientRequest addReq = AddPatientRequest.getAddPatientModel();
        ValidatableResponse createdV = new CrudeRequesters(
                RequestSpecs.adminSpecs(),
                Endpoint.ADD_PATIENT,
                ResponseSpecs.requestWasCreated()
        ).post(addReq, MC_ID);

        AddPatientResponse created = createdV.extract().as(AddPatientResponse.class);
        String patientId = created.getContent().getId();
        //Update

        UpdatePatientRequest upReq = UpdatePatientRequest.getUpdatePatientModel();
        AddPatientResponse updated = new CrudeRequesters(
                RequestSpecs.adminSpecs(),
                Endpoint.UPDATE_PATIENT,
                ResponseSpecs.requestWasSuccess()
        ).update(upReq, MC_ID, patientId).extract().as(AddPatientResponse.class);


        System.out.println(updated);
        softly.assertThat(updated.getContent().getPhoneNumber()).isEqualTo(addReq.getPhoneNumber());
    }
}
