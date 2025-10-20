package api.employees;

import models.Employees.AddEmployeesRequest;
import models.Employees.AddEmployeesResponse;
import models.comparison.ModelAssertions;
import org.junit.jupiter.api.Test;
import requests.CrudeRequesters;
import requests.Endpoint;
import requests.ValidatedCrudeRequesters;
import specs.RequestSpecs;
import specs.ResponseSpecs;
import api.BaseTest;

public class EmployeesTest extends BaseTest {

    @Test
    public void addEmployee(){
        AddEmployeesRequest newEmployeeRequest = AddEmployeesRequest.getEmployer();

        AddEmployeesResponse newEmployee = new ValidatedCrudeRequesters<AddEmployeesResponse>(RequestSpecs.adminSpecs(), Endpoint.ADD_EMPLOYEE, ResponseSpecs.requestWasCreated()).post(newEmployeeRequest, config.Config.getProperty("medicalCenterId"));

        ModelAssertions.assertThatModels(newEmployeeRequest, newEmployee.getContent()).match();
    }

    @Test
    public void removeEmployee(){}

    @Test
    public void findEmployeeById(){}

    @Test
    public void findAllEmployees(){}

}
