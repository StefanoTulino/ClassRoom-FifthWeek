package com.corso.exercise1.repository;

import com.corso.classRoom.domain.Product;
import com.corso.exercise1.domain.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;

    Employee employee;

    @BeforeEach
    public void setup(){
        employee=new Employee("1","impiegato1","aaa",18);
    }

    @AfterEach
    public void tearDown(){
        employee=null;
    }

    @Test
    public void GetAllEmployees(){
        Employee employee1=new Employee("2","Andrea","bbb",18);
        Employee employee2=new Employee("3","Rossi","ccc",21);
        employeeRepository.save(employee1);
        employeeRepository.save(employee2);

        List<Employee> productList= (List<Employee>)  employeeRepository.findAll();
        assertEquals(2,productList.size());
    }

    @Test
    public void getById(){
        employeeRepository.save(employee);
        Employee fetchedEmployee= employeeRepository.findById(employee.getId()).get();
        //parametri di tipo Object
        assertEquals("1",employee.getId());
    }

    @Test
    public void DeleteAllEmployees(){
        Employee employee1=new Employee("2","Andrea","bbb",18);
        Employee employee2=new Employee("3","Rossi","ccc",21);
        employeeRepository.save(employee1);
        employeeRepository.save(employee2);

        employeeRepository.deleteAll();
        List<Employee> productList= (List<Employee>)  employeeRepository.findAll();
        assertEquals(0,productList.size());
    }

    @Test
    public void deleteById(){
        Employee employee1=new Employee("2","Andrea","bbb",18);
        employeeRepository.save(employee1);
        employeeRepository.deleteById(employee1.getId());
        assertEquals(Optional.empty(),employeeRepository.findById(employee1.getId()));
    }
}
