package ch.zli.m223.zli.controller.rest.dto;

import ch.zli.m223.zli.model.UserCountry;

public class UserCountryDto {
    public long id;
    public String countryCode;

    public UserCountryDto(UserCountry userCountry){
        this.id = userCountry.getId();
        this.countryCode = userCountry.getCountryCode();
    }
}
