package ch.zli.m223.zli.model;

import ch.zli.m223.zli.model.impl.UserCountryImpl;

public interface UserCountry {
    long getId();
    String getCountryCode();
    String getDescription();
}
