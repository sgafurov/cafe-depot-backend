package com.cafe_depot.cafe_depot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "cafe_depot_user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "address", nullable = false)
    private String address;

    public UserEntity() {
    }

    public UserEntity(String username, String password, String email, String address) {
        this.username = username;
        // this.password = hashPassword(password);
        this.password = password;
        this.email = email;
        this.address = address;
    }

    // private String hashPassword(String password) {
    //     return new BCryptPasswordEncoder().encode(password);
    // }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    // public void setPassword(String password) {
    //     this.password = hashPassword(password);
    // }

    public void setPassword(String password) {
    this.password = (password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public UserEntity orElseThrow(Object object) {
        return null;
    }
}
