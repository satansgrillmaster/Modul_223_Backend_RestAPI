package ch.zli.m223.zli.service.impl;

import ch.zli.m223.zli.model.Role;
import ch.zli.m223.zli.model.UserCountry;
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
}
