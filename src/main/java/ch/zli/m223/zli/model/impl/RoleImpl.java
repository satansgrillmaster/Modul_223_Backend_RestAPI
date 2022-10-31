package ch.zli.m223.zli.model.impl;

import javax.persistence.*;

import ch.zli.m223.zli.model.Role;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Entity(name = "Role")
public class RoleImpl implements Role {

    @Id // makes the id to the primary-key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // makes an auto-increment on the id
    private Long id;

    @Column(nullable = false)
    private String role;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "AppUser_Role",
    joinColumns = @JoinColumn(name = "role_id"),
    inverseJoinColumns = @JoinColumn(name = "appuser_id"))
    private Collection<AppUserImpl> users = new ArrayList<>();


    public RoleImpl(String role) {
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

    public Collection<AppUserImpl> getUsers() {
        return users;
    }

    public void setUsers(Collection<AppUserImpl> users) {
        this.users = users;
    }

    public void addUser(AppUserImpl user){this.users.add(user);}

    public void removeUser(AppUserImpl user){this.users.remove(user);}
}