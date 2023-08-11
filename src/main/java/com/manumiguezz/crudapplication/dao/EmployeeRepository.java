package com.manumiguezz.crudapplication.dao;

import com.manumiguezz.crudapplication.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository  extends JpaRepository<Employee, Integer> {
}
