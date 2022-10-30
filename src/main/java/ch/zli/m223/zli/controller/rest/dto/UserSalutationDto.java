package ch.zli.m223.zli.controller.rest.dto;

import ch.zli.m223.zli.model.UserCountry;
import ch.zli.m223.zli.model.UserSalutation;

public class UserSalutationDto {
    public long id;
    public String description;

    public UserSalutationDto(UserSalutation salutation){
        this.id = salutation.getId();
        this.description = salutation.getDescription();
    }
}
