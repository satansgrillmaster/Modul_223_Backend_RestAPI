package ch.zli.m223.zli.model.impl;

import ch.zli.m223.zli.model.UserCountry;
import ch.zli.m223.zli.model.UserSalutation;

import javax.persistence.*;


@Entity(name = "Salutation")
public class UserSalutationImpl implements UserSalutation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String description;

    public UserSalutationImpl(String description){
        this.description = description;
    }

    protected UserSalutationImpl() {

    }

    @Override
    public long getId(){
        return id;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
