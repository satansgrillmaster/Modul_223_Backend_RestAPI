package ch.zli.m223.zli.model.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import ch.zli.m223.zli.model.Role;

@Entity(name = "Role")
public class RoleImpl implements Role {

    @Id // makes the id to the primary-key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // makes an auto-increment on the id
    private Long id;

    @Column(nullable = false)
    private String role;

    @ManyToOne
    private AppUserImpl appUser;

    public RoleImpl(String role, AppUserImpl user) {
        appUser = user;
        this.role = role;
    }

    protected RoleImpl() {

    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getRole() {
        return role;
    }

}