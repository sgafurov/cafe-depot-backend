package com.cafe_depot.cafe_depot.entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class UserSessionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id; // for the DB

    @Column(name = "session_id", nullable = false)
    private String sessionId; // jwt token. for us.

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "last_modified")
    @LastModifiedDate
    private LocalDateTime lastModified;

    public UserSessionEntity() {
    }

    public UserSessionEntity(String sessionId, UserEntity user) {
        this.sessionId = sessionId;
        this.user = user;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    
    // when user gets a token, we're going to store it in here
    // we check if user is authenticated by checking if their username is present in
    // this table
    // get by session id
    // session id in the header
}
