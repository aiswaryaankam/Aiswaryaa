package com.imaginnovate.imaginnovate.service;

import java.util.List;

import com.imaginnovate.imaginnovate.Entity.employee;

public interface EmployeeService {
    employee createEmployee(employee employee);
    List<employee> getAllEmployees();
}



