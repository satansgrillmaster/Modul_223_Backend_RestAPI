package ch.zli.m223.zli.controller.rest;


import ch.zli.m223.zli.controller.rest.dto.UserCountryDto;
import ch.zli.m223.zli.controller.rest.dto.UserSalutationDto;
import ch.zli.m223.zli.model.UserCountry;
import ch.zli.m223.zli.model.UserSalutation;
import ch.zli.m223.zli.service.SalutationService;
import ch.zli.m223.zli.service.UserCountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v0/salutations")
public class UserSalutationRestController {

    @Autowired
    private SalutationService salutationService;

    @GetMapping("")
    public List<UserSalutationDto> getAllSalutations(){
        List<UserSalutation> salutations = salutationService.getAllSalutations();
        return salutations.stream()
                .map((UserSalutation salutation) -> {
                    return new UserSalutationDto(salutation);
                }).collect(Collectors.toList());
    }
}
