package ch.zli.m223.zli.service.impl;

import ch.zli.m223.zli.controller.rest.dto.RoleInputDto;
import ch.zli.m223.zli.model.Role;
import ch.zli.m223.zli.model.UserCountry;
import ch.zli.m223.zli.model.impl.RoleImpl;
import ch.zli.m223.zli.repository.RoleRepository;
import ch.zli.m223.zli.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getAllRoles(){
        return new ArrayList<>(roleRepository.findAll());
    }

    @Override
    public void addRole(String role) {
        roleRepository.save(new RoleImpl(role));
    }

    @Override
    public void deleteRole(long roleId) {
        RoleImpl role = roleRepository.findById(roleId).orElseThrow();
        roleRepository.delete(role);
    }
}
