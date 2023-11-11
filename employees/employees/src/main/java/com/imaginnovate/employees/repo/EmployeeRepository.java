package com.imaginnovate.employees.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imaginnovate.employees.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
