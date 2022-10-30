package ch.zli.m223.zli.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zli.m223.zli.model.AppUser;
import ch.zli.m223.zli.model.impl.AppUserImpl;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<AppUserImpl, Long>, JpaSpecificationExecutor<AppUserImpl> {

    public Optional<AppUserImpl> findUserByEmail(String email);

    public default AppUser add(String email, String password) {
        return save(new AppUserImpl(email, password));
    }

    public default AppUser edit(Long id, String email, String password) {
        return save(new AppUserImpl(id, email, password));
    }

}