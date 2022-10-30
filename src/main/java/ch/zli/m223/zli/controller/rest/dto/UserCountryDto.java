package ch.zli.m223.zli.controller.rest.dto;

import ch.zli.m223.zli.model.UserCountry;

public class UserCountryDto {
    public long id;
    public String countryCode;
    public String description;

    public UserCountryDto(UserCountry userCountry){
        this.id = userCountry.getId();
        this.countryCode = userCountry.getCountryCode();
        this.description = userCountry.getDescription();
    }
}
