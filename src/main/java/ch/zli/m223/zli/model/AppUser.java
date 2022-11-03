package ch.zli.m223.zli.model;

import java.util.Collection;
import java.util.List;

import ch.zli.m223.zli.model.impl.RoleImpl;
import org.springframework.security.core.userdetails.UserDetails;

public interface AppUser extends UserDetails{

    Long getId();
    String getEmail();
    Collection<RoleImpl> getUserRoles();
    Long getCountryId();
    void setCountryId(long countryId);
    Long getSalutationId();
}