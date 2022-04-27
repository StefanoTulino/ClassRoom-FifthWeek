package com.corso.exercise1.repository;

import com.corso.exercise1.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  EmployeeRepository extends JpaRepository<Employee,String> {

}
