package com.imaginnovate.imaginnovate.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.imaginnovate.imaginnovate.Entity.employee;
import com.imaginnovate.imaginnovate.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employees")
    public ResponseEntity<employee> createEmployee(@Validated @RequestBody employee employee) {
        employee savedEmployee = employeeService.createEmployee(employee);
        return ResponseEntity.ok(savedEmployee);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<employee>> getAllEmployees() {
        List<employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }
}
