package ch.zli.m223.zli.controller.rest;

import ch.zli.m223.zli.controller.rest.dto.RoleDto;
import ch.zli.m223.zli.model.Role;
import ch.zli.m223.zli.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v0/roles")
public class UserRoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("")
    public List<RoleDto> getAllRoles(){
        List<Role> roles = roleService.getAllRoles();
        return roles.stream()
                .map((Role role) -> {
                    return new RoleDto(role);
                }).collect(Collectors.toList());
    }
}
