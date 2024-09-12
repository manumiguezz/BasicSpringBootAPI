package com.manumiguezz.crudapplication.service;

import com.manumiguezz.crudapplication.dao.EmployeeDAO;
import com.manumiguezz.crudapplication.dao.EmployeeRepository;
import com.manumiguezz.crudapplication.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl (EmployeeRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee;

        if (result.isPresent()) {
            theEmployee = result.get();
        }
        else {
            throw new RuntimeException("Did not find employee id: " + theId);
        }

        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteByID(int theId) {
        employeeRepository.deleteById(theId);
    }
}
