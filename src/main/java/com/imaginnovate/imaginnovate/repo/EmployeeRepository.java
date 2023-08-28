package com.imaginnovate.imaginnovate.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imaginnovate.imaginnovate.Entity.employee;

public interface EmployeeRepository extends JpaRepository<employee, Long>{

}
