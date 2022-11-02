package ch.zli.m223.zli.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import ch.zli.m223.zli.model.impl.RoleImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.zli.m223.zli.exception.InvalidParamException;
import ch.zli.m223.zli.exception.UserAlreadyExistsException;
import ch.zli.m223.zli.exception.UserNotFoundException;
import ch.zli.m223.zli.model.AppUser;
import ch.zli.m223.zli.model.impl.AppUserImpl;
import ch.zli.m223.zli.repository.RoleRepository;
import ch.zli.m223.zli.repository.UserRepository;
import ch.zli.m223.zli.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired // Spring will inject the UserRepository
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<AppUser> getAllUsers() {
        return new ArrayList<>(userRepository.findAll());
    }

    public AppUser getUserById(long id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public void deleteById(long id) {
        getUserById(id);// Parameter
        AppUserImpl user = userRepository.findById(id).orElseThrow();
        for (RoleImpl role: user.getUserRoles()
             ) {
            role.removeUser(user);
        }
        user.getUserRoles().clear();
        userRepository.deleteById(id);
    }

    @Override
    public Optional<AppUserImpl> getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public AppUser addUser(String email, String password, long countryId, long salutationId ) {
        System.out.println(email + "  " + password);
//        if (email == null || password == null) {
//            throw new InvalidParamException();
//        }
//        if (userRepository.findUserByEmail(email).isPresent()) {
//            throw new UserAlreadyExistsException();
//
//        }
        return userRepository.add(email, password, countryId, salutationId);
    }

    @Override
    public AppUser editUser(long id, String email, long countryId, long salutationId) {
        return userRepository.edit(id, email, countryId, salutationId);
    }

    @Override
    public AppUser editUserWithRoles(Long id, String email, long countryId, long salutationId, ArrayList<Long> roles) {

        Collection<RoleImpl> newRoles = new ArrayList<>();
        AppUserImpl user = userRepository.findById(id).orElseThrow();

        for (RoleImpl role: user.getUserRoles()
             ) {
            if(!roles.contains(role.getId())){
                role.removeUser(user);
            }
        }
        newRoles.addAll(roleRepository.findAllById(roles));

        for (RoleImpl role: newRoles
        ) {
            if (!role.getUsers().contains(user)){
                role.addUser(user);
            }
        }

        return userRepository.editWithRoles(id, email, countryId, salutationId, newRoles);
    }

    @Override
    public void deleteRoleFromUser(long userId, long roleId) {
        AppUserImpl user = userRepository.findById(userId).get();
        RoleImpl role = roleRepository.findById(roleId).get();

        role.removeUser(user);
        user.removeRole(role);
        userRepository.save(user);
        roleRepository.save(role);
    }

}