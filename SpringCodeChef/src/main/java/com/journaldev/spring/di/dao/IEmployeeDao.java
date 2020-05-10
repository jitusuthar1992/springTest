package com.journaldev.spring.di.dao;


import com.journaldev.spring.di.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeDao {

    List<Employee> getEmployees() ;

    Employee getEmployee(int id) ;

    Employee addEmployee(Employee employee) ;

    void updateEmployee(Employee employee) ;

    void deleteEmployee(int id) ;

    Employee search(String name);
}
