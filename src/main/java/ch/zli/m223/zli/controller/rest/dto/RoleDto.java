package ch.zli.m223.zli.controller.rest.dto;

import ch.zli.m223.zli.model.Role;

public class RoleDto {
    public long id;
    public String role;

    public RoleDto (Role role){
        this.id = role.getId();
        this.role = role.getRole();
    }
}
