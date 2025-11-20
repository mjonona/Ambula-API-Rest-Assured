package api.patients;

import api.BaseTest;
import config.Config;
import org.junit.jupiter.api.Test;
import requests.CrudeRequesters;
import requests.skeleton.Endpoint;
import specs.RequestSpecs;
import specs.ResponseSpecs;

import java.util.UUID;

public class PatientsTest extends BaseTest {

    @Test

    public void addPatientTest() {

        String medicalCenterId = Config.getProperty("medicalCenterId");

        models.patients.AddPatientRequest patientRequestModel= models.patients.AddPatientRequest.getAddPatientModel();

        new CrudeRequesters(RequestSpecs.adminSpecs(), Endpoint.ADD_PATIENT, ResponseSpecs.requestWasCreated()).post(medicalCenterId, patientRequestModel);
    }
}
