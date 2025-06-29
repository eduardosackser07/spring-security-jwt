package com.example.spring_security_jwt.entities;

public enum Values{
    BASIC(1),
    ADMIN(2);

    int roleId;

    Values(int roleId) {
        this.roleId = roleId;
    }

    public int getRoleId() {
        return roleId;
    }
}
