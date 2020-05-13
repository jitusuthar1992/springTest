package com.journaldev.spring.di.dao.impl;

import com.journaldev.spring.di.dao.IEmployeeDao;
import com.journaldev.spring.di.entity.Employee;
import com.journaldev.spring.di.entity.UserRole;
import com.journaldev.spring.di.entity.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Service("employeeDao")
public class EmployeeDaoImpl implements IEmployeeDao, UserDetailsService {

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
        return  (Employee) session.merge(employee);
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

    @Transactional
    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {


        System.out.println("Getting access details from employee dao !!");
        Session session = this.sessionFactory.getCurrentSession();

        Query query = session.createQuery("from Users where username = :username");
        query.setParameter("username",username);

        Users users = (Users) query.uniqueResult();

        if(null == users || !username.equals(users.getUsername())){
            throw new UsernameNotFoundException(username + " not found");
        }


        Query query1 = session.createQuery("from UserRole where username = :username");
        query1.setParameter("username",username);

        UserRole userRole = (UserRole) query1.uniqueResult();
        //creating dummy user details, should do JDBC operations
        return new UserDetails() {

            private static final long serialVersionUID = 2059202961588104658L;

            @Override
            public boolean isEnabled() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public String getUsername() {
                return username;
            }

            @Override
            public String getPassword() {
                return users.getPassword();
            }

            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                List<SimpleGrantedAuthority> auths = new java.util.ArrayList<SimpleGrantedAuthority>();
                auths.add(new SimpleGrantedAuthority(userRole.getRole()));
                return auths;
            }
        };
    }
}
