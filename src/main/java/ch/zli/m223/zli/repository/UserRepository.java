package ch.zli.m223.zli.repository;

import java.util.Collection;
import java.util.Optional;

import ch.zli.m223.zli.model.impl.RoleImpl;
import org.springframework.data.jpa.repository.JpaRepository;

import ch.zli.m223.zli.model.AppUser;
import ch.zli.m223.zli.model.impl.AppUserImpl;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<AppUserImpl, Long>, JpaSpecificationExecutor<AppUserImpl> {

    public Optional<AppUserImpl> findUserByEmail(String email);

    public default AppUser add(String email, String password) {
        return save(new AppUserImpl(email, password));
    }

    public default AppUser edit(Long id, String email, long countryId, long salutationId) {
        return save(new AppUserImpl(id, email, countryId, salutationId));
    }
    public default AppUser editWithRoles(Long id, String email, long countryId, long salutationId, Collection<RoleImpl> roles) {
        return save(new AppUserImpl(id, email, countryId, salutationId, roles));
    }

}