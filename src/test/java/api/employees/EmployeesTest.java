package api.employees;

import Config.Config;
import models.Employees.AddEmployeesRequest;
import models.Employees.AddEmployeesResponse;
import org.junit.jupiter.api.Test;
import requests.CrudeRequesters;
import requests.Endpoint;
import specs.RequestSpecs;
import specs.ResponseSpecs;
import api.BaseTest;

public class EmployeesTest extends BaseTest {

    @Test
    public void addEmployee(){
        AddEmployeesRequest newEmployeeRequest = AddEmployeesRequest.getEmployer();

        AddEmployeesResponse newEmployee = new CrudeRequesters(RequestSpecs.adminSpecs(), Endpoint.ADD_EMPLOYEE, ResponseSpecs.requestWasCreated()).post(newEmployeeRequest, Config.getProperty("medicalCenterId")).extract().as(AddEmployeesResponse.class);

        softly.assertThat(newEmployeeRequest.getFirstName()).isEqualTo(newEmployee.getContent().getFirstName());
    }

    @Test
    public void removeEmployee(){}

    @Test
    public void findEmployeeById(){}

    @Test
    public void findAllEmployees(){}

}
