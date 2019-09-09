package com.calisma.spsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired DriverManagerDataSource dataSource;
	
	// authoritiesByUsernameQuery -> checks for mail and role presence
	// usersByUsernameQuery -> password and active user control.
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.authoritiesByUsernameQuery(" select mail, role from admin where mail = ? ")
		.usersByUsernameQuery(" select mail, pass, 1 from admin where mail = ? ");
	}
	// decides which input method the application works with.
	// decides which role will perform which operation depending on the role.
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		.httpBasic()
		.and()
		.authorizeRequests()
		.antMatchers("/login").permitAll() //anyone can visit
		.antMatchers("/admin/**").hasAnyAuthority("ADMIN")
		.antMatchers("/user/**").hasAnyAuthority("USER")
		.antMatchers("/product/").hasAnyRole("ADMIN","USER")
		.anyRequest()
		.authenticated()
		.and()
		.csrf().disable();
		
	}
	
	
	@SuppressWarnings("deprecation")
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
	
	
}
