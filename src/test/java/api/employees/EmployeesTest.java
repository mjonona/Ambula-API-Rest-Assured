package api.employees;

import config.Config;
import models.employees.AddEmployeesRequest;
import models.employees.AddEmployeesResponse;
import models.comparison.ModelAssertions;
import org.junit.jupiter.api.Test;
import requests.skeleton.Endpoint;
import requests.ValidatedCrudeRequesters;
import specs.RequestSpecs;
import specs.ResponseSpecs;
import api.BaseTest;

public class EmployeesTest extends BaseTest {

    @Test
    public void addEmployee(){
        AddEmployeesRequest newEmployeeRequest = AddEmployeesRequest.getEmployer();

        AddEmployeesResponse newEmployee = new ValidatedCrudeRequesters<AddEmployeesResponse>(RequestSpecs.adminSpecs(), Endpoint.ADD_EMPLOYEE, ResponseSpecs.requestWasCreated()).post(newEmployeeRequest, Config.getProperty("medicalCenterId"));

        ModelAssertions.assertThatModels(newEmployeeRequest, newEmployee.getContent()).match();
    }

    @Test
    public void removeEmployee(){}

    @Test
    public void findEmployeeById(){}

    @Test
    public void findAllEmployees(){}

}
