package ch.zli.m223.zli.service;

import ch.zli.m223.zli.model.UserCountry;

import java.util.List;

public interface UserCountryService {
    List<UserCountry> getAllCountrys();
    void deleteCountry(long countryId);
    void addCountry(String countryCode, String description);
}
