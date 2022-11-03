package ch.zli.m223.zli.service;

import ch.zli.m223.zli.model.UserSalutation;

import java.util.List;

public interface SalutationService {
    List<UserSalutation> getAllSalutations();
    void deleteSalutation(long salutationId);
    void addSalutation(String description);
}
