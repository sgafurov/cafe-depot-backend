package com.cafe_depot.cafe_depot.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserModel {

    private Long id;
    private String username;
    private String email;
    private String address;
    private String sessionId;

    public UserModel(Long id, String username, String email,
            String address, String sessionId) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.address = address;
        this.sessionId = sessionId;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "UserModel [id=" + id + ", username=" + username + ", email=" + email
                + ", address=" + address + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserModel other = (UserModel) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
}
