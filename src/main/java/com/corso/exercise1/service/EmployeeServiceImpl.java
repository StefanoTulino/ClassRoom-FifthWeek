package com.corso.exercise1.service;

import com.corso.exercise1.domain.Employee;
import com.corso.exercise1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements  EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee e) {
        return employeeRepository.save(e);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmlpoyeeByid(String id) {
        return employeeRepository.getById(id);
    }

    @Override
    public Employee deleteEmployeeById(String id) {
        Employee e= employeeRepository.getById(id);
        if(e!=null){
            employeeRepository.deleteById(id);
        }
        return e;
    }
}
