package ch.zli.m223.zli.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import ch.zli.m223.zli.model.AppUser;
import ch.zli.m223.zli.model.impl.AppUserImpl;
import ch.zli.m223.zli.model.impl.RoleImpl;

public interface UserService {

    List<AppUser> getAllUsers();

    AppUser getUserById(long id);

    void deleteById(long id);

    Optional<AppUserImpl> getUserByEmail(String email);

    AppUser addUser(String email, String password, long countryId, long salutationId);

    AppUser editUserWithRoles(Long id, String email, long countryId, long salutationId, ArrayList<Long> roles);

    void deleteRoleFromUser(long userId, long roleId);

    void addRoleToUser(long userId, long roleId);

    AppUser editUser(long id, String email, long countryId, long salutationId);

}