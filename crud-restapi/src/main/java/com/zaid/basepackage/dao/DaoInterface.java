package com.zaid.basepackage.dao;

import com.zaid.basepackage.request.Employee;

public interface DaoInterface {

	Employee create(Employee employee);

	Employee fetch(int id);

     Employee update(int id, Employee employee);

	Employee delete(int id );

}
