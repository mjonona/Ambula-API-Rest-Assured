package api.employees;

import config.Config;
import models.employees.AddEmployeesRequest;
import models.employees.AddEmployeesResponse;
import models.comparison.ModelAssertions;
import org.junit.jupiter.api.Test;
import requests.CrudeRequesters;
import requests.skeleton.Endpoint;
import requests.ValidatedCrudeRequesters;
import specs.RequestSpecs;
import specs.ResponseSpecs;
import api.BaseTest;

public class EmployeesTest extends BaseTest {

    @Test
    public void addEmployee(){

        String medicalCenterID = Config.getProperty("medicalCenterId");


        AddEmployeesRequest newEmployeeRequest = AddEmployeesRequest.getEmployer();

        AddEmployeesResponse newEmployee = new CrudeRequesters(RequestSpecs.adminSpecs(), Endpoint.ADD_EMPLOYEE, ResponseSpecs.requestWasCreated()).post(medicalCenterID, newEmployeeRequest).extract().as(AddEmployeesResponse.class);

        ModelAssertions.assertThatModels(newEmployeeRequest, newEmployee.getContent()).match();
    }

    @Test
    public void removeEmployee(){}

    @Test
    public void findEmployeeById(){}

    @Test
    public void findAllEmployees(){}

}
