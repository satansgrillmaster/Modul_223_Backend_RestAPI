package ch.zli.m223.zli.model.impl;

import ch.zli.m223.zli.model.UserCountry;
import javax.persistence.*;


@Entity(name = "Country")
public class UserCountryImpl implements UserCountry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String countryCode;

    public UserCountryImpl(String countryCode){
        this.countryCode = countryCode;
    }

    protected UserCountryImpl () {

    }

    @Override
    public long getId(){
        return id;
    }

    @Override
    public String getCountryCode(){return countryCode;}
}
