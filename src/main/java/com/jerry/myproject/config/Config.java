package com.jerry.myproject.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Jerry
 * @Description
 * @createTime 2021年03月03日 09:58:00
 */
@Configurable
public class Config extends WebSecurityConfigurerAdapter {


    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers("/").permitAll();

        http.formLogin();
    }

}
