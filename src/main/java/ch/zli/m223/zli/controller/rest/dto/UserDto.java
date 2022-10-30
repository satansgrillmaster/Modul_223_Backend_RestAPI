package ch.zli.m223.zli.controller.rest.dto;

import java.util.ArrayList;
import java.util.List;

import ch.zli.m223.zli.model.AppUser;
import ch.zli.m223.zli.model.impl.RoleImpl;

/**
 * This is an DTO to render the information we want to show of an user
 */
public class UserDto {
    public long id;
    public String email;
    public long countryId;
    public long salutationId;
    public List<String> roles = new ArrayList<>();

    public UserDto(AppUser appUser) {
        this.id = appUser.getId();
        this.email = appUser.getEmail();
        this.countryId = appUser.getCountryId();
        this.salutationId = appUser.getSalutationId();
        for (RoleImpl role: appUser.getUserRoles())
        {
            roles.add(role.getRole());
        }
    }
}