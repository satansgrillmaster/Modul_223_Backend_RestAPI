package ch.zli.m223.zli.controller.rest.dto;

import java.util.ArrayList;
import java.util.List;

import ch.zli.m223.zli.model.AppUser;

/**
 * This is an DTO to render the information we want to show of an user
 */
public class UserDto {
    public long id;
    public String email;
    public List<String> roles = new ArrayList<>();

    public UserDto(AppUser appUser) {
        this.id = appUser.getId();
        this.email = appUser.getEmail();
        roles.addAll(appUser.getRoles());
    }
}