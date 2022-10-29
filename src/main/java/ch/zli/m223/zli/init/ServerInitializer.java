package ch.zli.m223.zli.init;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import ch.zli.m223.zli.model.UserCountry;
import ch.zli.m223.zli.model.impl.UserCountryImpl;
import ch.zli.m223.zli.repository.UserCountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ch.zli.m223.zli.model.impl.AppUserImpl;
import ch.zli.m223.zli.repository.RoleRepository;
import ch.zli.m223.zli.repository.UserRepository;
import ch.zli.m223.zli.role.Roles;

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

        UserCountryImpl country1;
        country1 = userCountryRepository.save(new UserCountryImpl("ch"));

        roles.clear();
        roles.add(Roles.USER);
        user = userRepository.save(new AppUserImpl("user", "user"));
        roleRepository.setRoles(user, roles);

        roles.clear();
        roles.add(Roles.ADMIN);
        user2 = userRepository.save(new AppUserImpl("admin", "admin"));
        roleRepository.setRoles(user2, roles);

        roles.clear();
        roles.add(Roles.ADMIN);
        roles.add(Roles.USER);
        user3 = userRepository.save(new AppUserImpl("usmin", "usmin"));
        roleRepository.setRoles(user3, roles);

        user4 = userRepository.save(new AppUserImpl("Matthias", "securepassword"));
        roleRepository.setRoles(user4, roles);

        roles.clear();
    }

}