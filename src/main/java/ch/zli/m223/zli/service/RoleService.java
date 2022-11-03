package ch.zli.m223.zli.service;

import ch.zli.m223.zli.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();
    void addRole(String role);
    void deleteRole(long roleId);
}
