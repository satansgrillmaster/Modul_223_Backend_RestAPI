package ch.zli.m223.zli.model;

import java.util.Collection;
import java.util.List;

import ch.zli.m223.zli.model.impl.RoleImpl;
import org.springframework.security.core.userdetails.UserDetails;

public interface AppUser extends UserDetails{

    public Long getId();
    public String getEmail();
    public Collection<RoleImpl> getUserRoles();
    public Long getCountryId();
    public void setCountryId(long countryId);
    public Long getSalutationId();
    public void setUserRoles(Collection<RoleImpl> userRoles);
}