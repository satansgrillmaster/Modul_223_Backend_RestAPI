package ch.zli.m223.zli.model;

import ch.zli.m223.zli.model.impl.AppUserImpl;

public interface Role {
    Long getId();
    String getRole();
    void removeUser(AppUserImpl user);
}