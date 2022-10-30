package ch.zli.m223.zli.service.impl;

import java.util.ArrayList;
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
        getUserById(id);// Parameter checkf
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
    public AppUser addUser(String email, String password) {
        if (email == null || password == null) {
            throw new InvalidParamException();
        }
        if (userRepository.findUserByEmail(email).isPresent()) {
            throw new UserAlreadyExistsException();

        }
        return userRepository.add(email, password);
    }

    @Override
    public AppUser setRolesForUser(long id, List<String> roles) {
        AppUser user = getUserById(id); // Parameter check
        if (roles == null) {
            throw new InvalidParamException();
        }
        return roleRepository.setRoles(user, roles);
    }

    @Override
    public AppUser editUser(long id, String password, String email) {
        if (email == null || password == null) {
            throw new InvalidParamException();
        }
        if (userRepository.findUserByEmail(email).isPresent()) {
            throw new UserAlreadyExistsException();

        }
        return userRepository.edit(id, email, password);
    }

}