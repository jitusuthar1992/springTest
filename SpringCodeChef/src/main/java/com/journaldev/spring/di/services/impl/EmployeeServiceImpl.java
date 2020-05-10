package com.journaldev.spring.di.services.impl;

import com.journaldev.spring.di.dao.IEmployeeDao;
import com.journaldev.spring.di.entity.Employee;
import com.journaldev.spring.di.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements IEmployeeService {


    @Autowired
    private IEmployeeDao employeeDao;

    @Override
    public List<Employee> getEmployees() {
        return employeeDao.getEmployees();
    }

    @Override
    public Employee getEmployee(int id) {
        return employeeDao.getEmployee(id);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeDao.addEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeDao.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeDao.deleteEmployee(id);
    }

    @Override
    public Employee search(String name) {
        return employeeDao.search(name);
    }
}
