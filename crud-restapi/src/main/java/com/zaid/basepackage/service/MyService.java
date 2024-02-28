package com.zaid.basepackage.service;

import com.zaid.basepackage.request.Employee;

public interface MyService {

     Employee create(Employee employee);

	Employee fetch(int id);

	Employee update(int id, Employee employee);

	Employee delete(int id);

}
