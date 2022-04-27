package com.corso.exercise1.service;




import com.corso.exercise1.domain.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee e);
    List<Employee> getAllEmployees();
    Employee getEmlpoyeeByid(String id);
    Employee deleteEmployeeById(String id);

}
