package com.learning.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class BankingSecurity extends WebSecurityConfigurerAdapter {
	
	
	protected void configure(HttpSecurity http) throws Exception{
	http
	.authorizeRequests()
	/*
	.antMatchers("/admin/**").hasRole("ADMIN")
	.antMatchers("/customer/**").hasRole("CUSTOMER")
	.antMatchers("/staff/**").hasRole("STAFF")
	*/
	.anyRequest()
	.authenticated()
	.and()
	.httpBasic();
	
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication().withUser("Pranav").password(this.passwordEncoder().encode("root")).roles("ADMIN");
		auth.inMemoryAuthentication().withUser("Jack").password(this.passwordEncoder().encode("root")).roles("STAFF");
		auth.inMemoryAuthentication().withUser("Vijaya").password(this.passwordEncoder().encode("root")).roles("CUSTOMER");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
