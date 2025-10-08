package api.patients;

import api.BaseTest;
import config.Config;
import org.junit.jupiter.api.Test;
import requests.CrudeRequesters;
import requests.Endpoint;
import specs.RequestSpecs;
import specs.ResponseSpecs;

public class PatientsTest extends BaseTest {

    @Test

    public void addPatientTest(){
        models.patients.AddPatientRequest patientRequestModel= models.patients.AddPatientRequest.getAddPatientModel();

        new CrudeRequesters(RequestSpecs.adminSpecs(), Endpoint.ADD_PATIENT, ResponseSpecs.requestWasCreated()).post(patientRequestModel, Config.getProperty("medicalCenterId"));
    }


}
