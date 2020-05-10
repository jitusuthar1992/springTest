package com.journaldev.spring.di.services.impl;

import com.journaldev.spring.di.dao.IEmployeeDao;
import com.journaldev.spring.di.entity.Employee;
import com.journaldev.spring.di.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements IEmployeeService {


    @Autowired
    private IEmployeeDao employeeDao;

    @Cacheable("employeeCache")
    @Override
    public List<Employee> getEmployees() {
        return employeeDao.getEmployees();
    }

    @Cacheable("employeeCache")
    @Override
    public Employee getEmployee(int id) {
        return employeeDao.getEmployee(id);
    }

    @CachePut( "employeeCache")
    @Override
    public Employee addEmployee(Employee employee) {
        return employeeDao.addEmployee(employee);
    }

    @CachePut( "employeeCache")
    @Override
    public void updateEmployee(Employee employee) {
        employeeDao.updateEmployee(employee);
    }

    @CacheEvict(value = "employeeCache",allEntries=true)
    @Override
    public void deleteEmployee(int id) {
        employeeDao.deleteEmployee(id);
    }

    @Cacheable(value = "employeeCache")
    @Override
    public Employee search(String name) {
        return employeeDao.search(name);
    }
}
