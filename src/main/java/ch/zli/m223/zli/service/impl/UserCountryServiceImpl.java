package ch.zli.m223.zli.service.impl;

import ch.zli.m223.zli.model.UserCountry;
import ch.zli.m223.zli.model.impl.UserCountryImpl;
import ch.zli.m223.zli.repository.UserCountryRepository;
import ch.zli.m223.zli.service.UserCountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserCountryServiceImpl implements UserCountryService {

    @Autowired
    private UserCountryRepository userCountryRepository;

    public List<UserCountry> getAllCountrys(){
        return new ArrayList<>(userCountryRepository.findAll());
    }

    @Override
    public void deleteCountry(long countryId) {
        UserCountryImpl country = userCountryRepository.findById(countryId).orElseThrow();
        userCountryRepository.delete(country);
    }

    @Override
    public void addCountry(String countryCode, String description) {
        userCountryRepository.save(new UserCountryImpl(countryCode, description));
    }
}
