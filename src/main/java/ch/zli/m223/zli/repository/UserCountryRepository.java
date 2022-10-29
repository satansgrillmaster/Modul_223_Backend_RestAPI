package ch.zli.m223.zli.repository;

import ch.zli.m223.zli.model.impl.UserCountryImpl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCountryRepository extends JpaRepository<UserCountryImpl, Long> {

}
