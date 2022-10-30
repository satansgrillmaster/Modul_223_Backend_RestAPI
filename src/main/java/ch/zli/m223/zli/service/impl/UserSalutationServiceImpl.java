package ch.zli.m223.zli.service.impl;

import ch.zli.m223.zli.model.UserCountry;
import ch.zli.m223.zli.model.UserSalutation;
import ch.zli.m223.zli.repository.UserCountryRepository;
import ch.zli.m223.zli.repository.UserSalutationRepository;
import ch.zli.m223.zli.service.SalutationService;
import ch.zli.m223.zli.service.UserCountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserSalutationServiceImpl implements SalutationService {

    @Autowired
    private UserSalutationRepository userSalutationRepository;

    public List<UserSalutation> getAllSalutations(){
        return new ArrayList<>(userSalutationRepository.findAll());
    }
}
