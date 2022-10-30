package ch.zli.m223.zli.repository;

import ch.zli.m223.zli.model.impl.UserCountryImpl;
import ch.zli.m223.zli.model.impl.UserSalutationImpl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSalutationRepository extends JpaRepository<UserSalutationImpl, Long> {

}
