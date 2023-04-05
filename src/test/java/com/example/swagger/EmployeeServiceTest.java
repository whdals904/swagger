package com.example.swagger;

import com.example.swagger.dto.Employee;
import com.example.swagger.service.EmployeeService;
import com.example.swagger.service.TestService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private EmployeeService empService = new EmployeeService();

    @Test
    public void Test1() {
        Employee emp = new Employee("E001", "Eric Simmons");
        Mockito.when(restTemplate.getForEntity("http://localhost:8080/employee/E001", Employee.class))
               .thenReturn(new ResponseEntity(emp, HttpStatus.OK));

        Employee employee = empService.getEmployee("E001");
        Assertions.assertEquals(emp, employee);
    }

    @Test
    public void Test2() {
        Employee emp = new Employee("E001", "Eric Simmons");
        Mockito.when(restTemplate.getForEntity("http://localhost:8080/employee/E002", Employee.class))
                .thenReturn(new ResponseEntity(emp, HttpStatus.OK));

        Employee employee = empService.getEmployee("E002");
        Assertions.assertEquals(emp, employee);
    }
}
