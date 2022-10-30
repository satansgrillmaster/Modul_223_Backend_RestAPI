package ch.zli.m223.zli.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zli.m223.zli.model.AppUser;
import ch.zli.m223.zli.model.impl.AppUserImpl;
import ch.zli.m223.zli.model.impl.RoleImpl;

public interface RoleRepository extends JpaRepository<RoleImpl, Long>{

    public default AppUser setRoles(AppUser user, List<String> roles) {
        AppUserImpl appUser = (AppUserImpl)user;
        for (String role : roles) {
            RoleImpl dbRole = save(new RoleImpl(role));
            appUser.addRole(dbRole);
        }
        return user;
    }

}