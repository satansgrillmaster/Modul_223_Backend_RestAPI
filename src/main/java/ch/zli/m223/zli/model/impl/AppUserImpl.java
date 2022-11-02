package ch.zli.m223.zli.model.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.persistence.*;

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

    @Column
    private long countryId;

    @Column
    private long salutationId;

    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
    private Collection<RoleImpl> userRoles = new ArrayList<>();

    private String hashedPassword;

    public AppUserImpl(String email, String password, long countryId, long salutationId) {
        this.email = email;
        this.countryId = countryId;
        this.salutationId = salutationId;
        hashedPassword = new BCryptPasswordEncoder().encode(password);
    }

    public AppUserImpl(long id, String email, long countryId, long salutationId) {
        this.id = id;
        this.email = email;
        this.countryId = countryId;
        this.salutationId = salutationId;
    }
    public AppUserImpl(long id, String email, long countryId, long salutationId, Collection<RoleImpl> roles) {
        this.id = id;
        this.email = email;
        this.countryId = countryId;
        this.salutationId = salutationId;
        this.userRoles = roles;
    }

    protected AppUserImpl() {

    }// For JPA only

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

    public void removeRole(RoleImpl role){userRoles.remove(role);}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getUserRoles().stream().map((role) -> {
            return new SimpleGrantedAuthority(role.getRole());
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

    @Override
    public Collection<RoleImpl> getUserRoles() {
        return userRoles;
    }

    @Override
    public Long getCountryId() {
        return countryId;
    }

    @Override
    public Long getSalutationId() {
        return salutationId;
    }
    public void setSalutationId(long salutationId) {
        this.salutationId = salutationId;
    }

    @Override
    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }

}