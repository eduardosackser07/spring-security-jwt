package com.example.spring_security_jwt.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_roles")
public class Role{

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;

    @Column
    private String name;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
}
