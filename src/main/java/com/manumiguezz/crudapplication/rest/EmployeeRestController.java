package com.manumiguezz.crudapplication.rest;

import com.manumiguezz.crudapplication.dao.EmployeeDAO;
import com.manumiguezz.crudapplication.entity.Employee;
import com.manumiguezz.crudapplication.service.EmployeeService;
import com.manumiguezz.crudapplication.service.EmployeeServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController (EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }


}
