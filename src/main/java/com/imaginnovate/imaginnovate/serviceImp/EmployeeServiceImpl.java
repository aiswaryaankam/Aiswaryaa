package com.imaginnovate.imaginnovate.serviceImp;

import org.springframework.stereotype.Service;

import com.imaginnovate.imaginnovate.Entity.employee;
import com.imaginnovate.imaginnovate.repo.EmployeeRepository;
import com.imaginnovate.imaginnovate.service.EmployeeService;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    private static final double TAX_RATE_1 = 0.05;
    private static final double TAX_RATE_2 = 0.10;
    private static final double TAX_RATE_3 = 0.20;
    private static final double CESS_RATE = 0.02;

    @Override
    public employee createEmployee(employee employee) {
		return employee;
        // Implement data validation and save to the repository
   
    }

    @Override
    public List<employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    private double calculateTaxAmount(double yearlySalary) {
        if (yearlySalary <= 250000) {
            return 0;
        } else if (yearlySalary <= 500000) {
            return (yearlySalary - 250000) * TAX_RATE_1;
        } else if (yearlySalary <= 1000000) {
            return 12500 + (yearlySalary - 500000) * TAX_RATE_2;
        } else {
            return 112500 + (yearlySalary - 1000000) * TAX_RATE_3;
        }
    }

    private double calculateCessAmount(double yearlySalary) {
        if (yearlySalary > 2500000) {
            return yearlySalary * CESS_RATE;
        }
        return 0;
    }

    private double calculateYearlySalary(employee employee) {
        Calendar dojCalendar = Calendar.getInstance();
        dojCalendar.setTime(employee.getDoj());

        Calendar now = Calendar.getInstance();
        int currentYear = now.get(Calendar.YEAR);

        double totalSalary = employee.getSalary() * (currentYear - dojCalendar.get(Calendar.YEAR) + 1);

        if (dojCalendar.get(Calendar.MONTH) > Calendar.APRIL ||
            (dojCalendar.get(Calendar.MONTH) == Calendar.APRIL && dojCalendar.get(Calendar.DAY_OF_MONTH) > 15)) {
            totalSalary -= employee.getSalary();
        }

        return totalSalary;
    }
}


