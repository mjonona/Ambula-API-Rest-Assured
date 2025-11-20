package api.patients;

import api.BaseTest;
import config.Config;
import io.restassured.response.ValidatableResponse;
import models.employees.UpdatePatientRequest;
import models.patients.AddPatientRequest;
import models.patients.AddPatientResponse;
import org.junit.jupiter.api.Test;
import requests.CrudeRequesters;
import requests.skeleton.Endpoint;
import specs.RequestSpecs;
import specs.ResponseSpecs;

public class PatientCrudeTest extends BaseTest {
    private final String MC_ID = Config.getProperty("medicalCenterId");

    @Test
    void create_then_update_patient() {

        //Create

        AddPatientRequest addPatientRequestModel = AddPatientRequest.getAddPatientModel();

        ValidatableResponse createdV = new CrudeRequesters(RequestSpecs.adminSpecs(), Endpoint.ADD_PATIENT, ResponseSpecs.requestWasCreated()).post(MC_ID, addPatientRequestModel);


        AddPatientResponse created = createdV.extract().as(AddPatientResponse.class);
        String patientId = created.getContent().getId();

        //Update

        UpdatePatientRequest upReq = UpdatePatientRequest.getUpdatePatientModel();
        new CrudeRequesters(
                RequestSpecs.adminSpecs(),
                Endpoint.UPDATE_PATIENT,
                ResponseSpecs.requestWasSuccess()
        ).patch(MC_ID, upReq, patientId);

        //Get

        AddPatientResponse got = new CrudeRequesters(
                RequestSpecs.adminSpecs(),
                Endpoint.GET_PATIENT,
                ResponseSpecs.requestWasSuccess()
        ).get(MC_ID, patientId)
                .extract().as(AddPatientResponse.class);

        softly.assertThat(got.getContent().getId()).isEqualTo(patientId);
    }
}
