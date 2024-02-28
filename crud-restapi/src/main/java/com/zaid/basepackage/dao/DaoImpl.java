package com.zaid.basepackage.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zaid.basepackage.repo.EmployeeRepo;
import com.zaid.basepackage.request.Employee;
@Component
public class DaoImpl implements DaoInterface {
	@Autowired
	private EmployeeRepo repo;

	@Override
	public Employee create(Employee employee) {
		repo.save(employee);
		Employee emp = repo.findById(employee.getId()).orElse(null);
		return emp;
	}

	@Override
	public Employee fetch(int id) {
		Employee emp = repo.findById(id).orElse(null);
		return emp;
	}

	@Override
	public Employee update(int id, Employee employee) {
		Employee fetch = repo.findById(id).orElse(null);
		if(fetch!=null) {
			fetch.setName(employee.getName()+fetch.getName());
			Employee updated = repo.save(fetch);
			System.out.println(updated);
			return updated;
			
		}else {
			return null;
			
		}
		
	}
	//demo class

	@Override
	public Employee delete(int id) {
		repo.deleteById(id);
		Employee employee = repo.findById(id).orElse(null);
		return employee;
	}

}
