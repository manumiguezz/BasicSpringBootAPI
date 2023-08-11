package com.manumiguezz.crudapplication.dao;

import com.manumiguezz.crudapplication.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
