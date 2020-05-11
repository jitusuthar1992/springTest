package com.journaldev.spring.di.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class Users {



    @Id
    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="active")
    private Boolean active;


/*
    private Set<UserRole> userRoleMapping;
*/

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    /*@OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    public Set<UserRole> getUserRoleMapping() {
        return this.userRoleMapping;
    }

    public void setUserRoleMapping(Set<UserRole> userRoleMapping) {
        this.userRoleMapping = userRoleMapping;
    }*/
}
