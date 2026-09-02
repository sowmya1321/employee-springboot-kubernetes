package com.example.employeeapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @GetMapping("/")
    public String home() {
        return "Employee application is running!";
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return List.of(
            new Employee(1, "Sowmya", "Java Developer"),
            new Employee(2, "John", "DevOps Engineer"),
            new Employee(3, "David", "Cloud Engineer")
        );
    }
}