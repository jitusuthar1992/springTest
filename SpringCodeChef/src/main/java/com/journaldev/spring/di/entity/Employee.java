package com.journaldev.spring.di.entity;

import javax.persistence.*;

@Entity
@Table(name="Employee")
public class Employee {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;

    @Column(name="name")
    String name;

    @Column(name="age")
    long age;

    @Column(name="salary")
    long salary;


    //@Transient to denote field to be non persistent
    //static to denote field to be non persistent
    //final to denote field to be non persistent
    //transient to denote field to be non persistent and non transient
    @Column(name = "dept_name")
    String deptName;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }


    public String getDeptName() {
        return deptName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
