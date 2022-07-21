package com.learning.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

import com.learning.service.CustomUserDetailsService;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class BankingSecurity extends WebSecurityConfigurerAdapter {
	//implements WebMvcConfigurer 
	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
	protected void configure(HttpSecurity http) throws Exception{
	http
	.csrf().disable()
	.cors().and()//disable()
	.authorizeRequests()
	.antMatchers("/api/**").permitAll()
	.antMatchers("/api/customer/register").permitAll()
	//.antMatchers("/api/staff/customer").permitAll()
	.antMatchers("/authenticate").permitAll()
	.antMatchers("/api/admin/**").hasRole("ADMIN")
	.antMatchers("/api/customer/**").hasAnyAuthority("Customer")
	.antMatchers("/api/staff/**").hasAnyAuthority("Staff")
	.anyRequest()
	.authenticated()
	.and()
	.httpBasic();
	//"/api/staff/customer"
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication().withUser("Pranav").password(this.passwordEncoder().encode("root")).roles("ADMIN");
		auth.inMemoryAuthentication().withUser("Jack").password(this.passwordEncoder().encode("root")).authorities("Staff");
		auth.inMemoryAuthentication().withUser("Vijaya").password(this.passwordEncoder().encode("root")).roles("Customer");
		
		auth.userDetailsService(customUserDetailsService).passwordEncoder(this.passwordEncoder());
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		//return new BCryptPasswordEncoder();
		return NoOpPasswordEncoder.getInstance();
	}
	
	
	public void configurePathMatch(PathMatchConfigurer configurer) {
		UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(urlPathHelper);
	}
	
	@Bean
	public AuthenticationManager getAuthenticationManager() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManager();
	}
	
//	@Override
//	public void addCorsMappings(CorsRegistry registry) {
//		
//		registry.addMapping("/api/**").allowedMethods("GET","PUT","POST");
//	}

}
