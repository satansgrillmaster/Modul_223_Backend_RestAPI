package ch.zli.m223.zli.model.impl;

import ch.zli.m223.zli.model.AppUser;
import ch.zli.m223.zli.model.UserCountry;
import javax.persistence.*;


@Entity(name = "Country")
public class UserCountryImpl implements UserCountry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String countryCode;

    @Column(nullable = false)
    private String description;

    public UserCountryImpl(String countryCode, String description){
        this.countryCode = countryCode;
        this.description = description;
    }

    protected UserCountryImpl () {

    }

    @Override
    public long getId(){
        return id;
    }

    @Override
    public String getCountryCode(){return countryCode;}

    @Override
    public String getDescription() {
        return description;
    }
}
