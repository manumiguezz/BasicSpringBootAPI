package com.manumiguezz.crudapplication.service;

import com.manumiguezz.crudapplication.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
}
