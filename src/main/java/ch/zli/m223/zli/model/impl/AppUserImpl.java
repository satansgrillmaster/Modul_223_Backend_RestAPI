package ch.zli.m223.zli.model.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.*;

import ch.zli.m223.zli.controller.rest.dto.RoleDto;
import ch.zli.m223.zli.model.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ch.zli.m223.zli.model.AppUser;

@Entity(name = "AppUser")
public class AppUserImpl implements AppUser {

    @Id // makes the id to the primary-key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // makes an auto-increment on the id
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @ManyToMany(mappedBy = "users",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Collection<RoleImpl> userRoles = new ArrayList<>();


    //    @OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //    private List<RoleImpl> roles;

    private String hashedPassword;

    public AppUserImpl(String email, String password) {
        this.email = email;
        hashedPassword = new BCryptPasswordEncoder().encode(password);
    }

    public AppUserImpl(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        hashedPassword = new BCryptPasswordEncoder().encode(password);
    }

    protected AppUserImpl() {

    }// For JPA only

    @Override
    public List<String> getRoles() {
        List<String> test = new ArrayList<>();
        for (Role role:getUserRoles()
             ) {
            test.add(role.getRole());
        }
        return test;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public void addRole(RoleImpl role) {
        userRoles.add(role);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles().stream().map((role) -> {
            return new SimpleGrantedAuthority(role);
        }).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return hashedPassword;
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Collection<RoleImpl> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Collection<RoleImpl> userRoles) {
        this.userRoles = userRoles;
    }
}