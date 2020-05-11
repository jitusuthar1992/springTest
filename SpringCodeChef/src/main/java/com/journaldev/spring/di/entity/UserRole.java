package com.journaldev.spring.di.entity;

import javax.persistence.*;
import java.util.Set;

@Table(name = "user_roles")
@Entity
public class UserRole {

    @Id
    @Column(name="user_role_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int userRoleID;

    @Column(name="username")
    private String username;

    @Column(name="role")
    private  String role;
/*
    private Users user;
*/


    public int getUserRoleID() {
        return userRoleID;
    }

    public void setUserRoleID(int userRoleID) {
        this.userRoleID = userRoleID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }



    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username", nullable = false)
    public Users getUser() {
        return this.user;
    }

    public void setUser(Users user) {
        this.user = user;
    }*/
}
