package com.corso.exercise1.controller;


import com.corso.classRoom.domain.Product;
import com.corso.exercise1.domain.Employee;
import com.corso.exercise1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercise1")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("insert")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee saveE = employeeService.addEmployee(employee);
        return new ResponseEntity<>(saveE, HttpStatus.CREATED);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Employee>> getAllEmployees() {

        return new ResponseEntity<List<Employee>>(
                (List<Employee>) employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("employee/{id}")
    public ResponseEntity<Employee> getProductById(@PathVariable("id") String id) {
        return new ResponseEntity<>(employeeService.getEmlpoyeeByid(id), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Employee> deleteProduct(@PathVariable("id") String id) {
        ResponseEntity<Employee> responseEntity;
        Employee e = employeeService.deleteEmployeeById(id);
        return new ResponseEntity<Employee>(e, HttpStatus.OK);
    }
}
