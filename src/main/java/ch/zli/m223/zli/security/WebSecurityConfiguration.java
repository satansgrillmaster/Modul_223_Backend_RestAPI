package ch.zli.m223.zli.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ch.zli.m223.zli.role.Roles;

@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    UserDetailsService userDetailsService;
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public WebSecurityConfiguration(UserDetailsService userDetailsService,
                                    BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        configureRest(http);
    }

    private void configureRest(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/v0/countries/delete/**").hasAuthority(Roles.ADMIN)
                .antMatchers("/api/v0/roles/delete/**").hasAuthority(Roles.ADMIN)
                .antMatchers("/api/v0/salutations/add/**").hasAuthority(Roles.ADMIN)                .antMatchers("/api/v0/countries/delete/**").hasAuthority(Roles.ADMIN)
                .antMatchers("/api/v0/roles/add/**").hasAuthority(Roles.ADMIN)
                .antMatchers("/api/v0/salutations/add/**").hasAuthority(Roles.ADMIN)
                .antMatchers("/").hasAnyAuthority(Roles.ADMIN, Roles.USER)
                .anyRequest().authenticated()
                .and().formLogin().permitAll()
                .and().logout().permitAll()
                .and().csrf().disable();
    }
}