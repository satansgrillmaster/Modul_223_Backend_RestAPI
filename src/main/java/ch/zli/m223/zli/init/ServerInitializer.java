package ch.zli.m223.zli.init;

import java.util.*;

import javax.transaction.Transactional;

import ch.zli.m223.zli.model.impl.RoleImpl;
import ch.zli.m223.zli.model.impl.UserCountryImpl;
import ch.zli.m223.zli.repository.UserCountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ch.zli.m223.zli.model.impl.AppUserImpl;
import ch.zli.m223.zli.repository.RoleRepository;
import ch.zli.m223.zli.repository.UserRepository;

@Component
public class ServerInitializer implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserCountryRepository userCountryRepository;

    @Transactional
    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<String> roles = new ArrayList<>();

        AppUserImpl user; // user1 is only a user
        AppUserImpl user2; // user2 is an admin
        AppUserImpl user3; // user3 is superuser
        AppUserImpl user4;

        RoleImpl roleAdmin = new RoleImpl("admin");
        RoleImpl roleUser = new RoleImpl("user");
        RoleImpl roleStaff = new RoleImpl("staff");


        roleRepository.save(roleAdmin);
        roleRepository.save(roleUser);
        roleRepository.save(roleStaff);

        Collection<AppUserImpl> adminUsers = new ArrayList<>();
        Collection<AppUserImpl> staffUsers = new ArrayList<>();
        Collection<AppUserImpl> users = new ArrayList<>();

        UserCountryImpl country1 = userCountryRepository.save(new UserCountryImpl("ch","Schweiz"));

        user = userRepository.save(new AppUserImpl("user@user.ch", "user"));
        users.add(user);
        user.setCountryId(country1.getId());
        staffUsers.add(user);

        user2 = userRepository.save(new AppUserImpl("admin@admin.ch", "admin"));
        adminUsers.add(user2);

        user3 = userRepository.save(new AppUserImpl("staff@staff.ch", "staff"));
        adminUsers.add(user3);
        users.add(user3);
        staffUsers.add(user3);

        user4 = userRepository.save(new AppUserImpl("maetthe_hollenstein@hotmail.com", "password"));
        adminUsers.add(user4);

        roleAdmin.setUsers(adminUsers);
        roleUser.setUsers(users);
        roleStaff.setUsers(staffUsers);

    }

}