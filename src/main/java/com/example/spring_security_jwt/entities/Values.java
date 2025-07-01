package com.example.spring_security_jwt.entities;

public enum Values{
    basic(2),
    admin(1);

    int roleId;

    Values(int roleId) {
        this.roleId = roleId;
    }

    public int getRoleId() {
        return roleId;
    }
}
