package com.zaid.basepackage.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zaid.basepackage.request.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
