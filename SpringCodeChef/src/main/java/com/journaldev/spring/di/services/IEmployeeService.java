package com.journaldev.spring.di.services;

import com.journaldev.spring.di.entity.Employee;

import java.util.List;

public interface IEmployeeService {

     List<Employee> getEmployees() ;

     Employee getEmployee(int id) ;

     Employee addEmployee(Employee employee);

     void updateEmployee(Employee employee);

     void deleteEmployee(int id) ;

    Employee search(String name);
}
