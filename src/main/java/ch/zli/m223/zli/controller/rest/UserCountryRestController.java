package ch.zli.m223.zli.controller.rest;


import ch.zli.m223.zli.controller.rest.dto.UserCountryDto;
import ch.zli.m223.zli.model.UserCountry;
import ch.zli.m223.zli.service.UserCountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v0/countries")
public class UserCountryRestController {

    @Autowired
    private UserCountryService userCountryService;

    @GetMapping("")
    public List<UserCountryDto> getAllCountrys(){
        List<UserCountry> countries = userCountryService.getAllCountrys();
        return countries.stream()
                .map((UserCountry country) -> {
                    return new UserCountryDto(country);
                }).collect(Collectors.toList());
    }
}
