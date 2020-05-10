package com.journaldev.spring.di.dao.impl;

import com.journaldev.spring.di.dao.IEmployeeDao;
import com.journaldev.spring.di.entity.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("employeeDao")
public class EmployeeDaoImpl implements IEmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Transactional
    public List<Employee> getEmployees() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Employee> employees = session.createQuery("from Employee").list();
        return employees;
    }

    @Transactional
    public Employee getEmployee(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Employee employee = (Employee) session.get(Employee.class, new Integer(id));
        return employee;
    }

    @Transactional
    public Employee addEmployee(Employee employee) {
        Session session = this.sessionFactory.getCurrentSession();
        employee = (Employee) session.merge(employee);
        return employee;
    }

    @Transactional
    public void updateEmployee(Employee employee) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(employee);
    }

    @Transactional
    public void deleteEmployee(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Employee emp = (Employee) session.load(Employee.class, new Integer(id));
        if (null != emp) {
            session.delete(emp);
        }
    }

    @Transactional
    public Employee search(String name) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query=  session.createQuery("from Employee where name = :name");
        query.setParameter("name",name);
        return (Employee) query.uniqueResult();
    }
}
