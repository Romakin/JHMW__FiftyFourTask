package com.example.demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        PasswordEncoder enc = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser("user").password(enc.encode("pass")).roles("READ")
                .and()
                .withUser("manager").password(enc.encode("passw0rd")).roles("READ", "WRITE");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and()
                .formLogin().and()
                .authorizeRequests().antMatchers("/persons/hello").permitAll()
                .and()
                .authorizeRequests()
                    .antMatchers("/persons/get-**").hasRole("READ")
                    .antMatchers("/persons/set", "/persons/delete").hasRole("WRITE")
                    .anyRequest().authenticated();
    }
}
