package com.mvc.SpringBootMVCDemo.repo;


import com.mvc.SpringBootMVCDemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    public Employee findByEmail(String email);

    // select password from employee where email=?
    @Query("select password from Employee where email=:email")
    public String findPasswordByEmployeeEmail(String email);
}
