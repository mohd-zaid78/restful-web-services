package com.zaid.basepackage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zaid.basepackage.dao.DaoInterface;
import com.zaid.basepackage.request.Employee;

@Component
public class MyServiceImpl implements MyService {
	@Autowired
	private DaoInterface daoInterface;

	@Override
	public Employee create(Employee employee) {
		Employee emp = daoInterface.create(employee);
		return emp;
	}

	@Override
	public Employee fetch(int id) {
		Employee fetch = daoInterface.fetch(id);
		return fetch;
	}

	@Override
	public Employee update(int id, Employee employee) {
		Employee update = daoInterface.update(id,employee);
		return update;
	}

	@Override
	public Employee delete(int id) {
		Employee deleted = daoInterface.delete(id);
		return deleted;
	}

}
