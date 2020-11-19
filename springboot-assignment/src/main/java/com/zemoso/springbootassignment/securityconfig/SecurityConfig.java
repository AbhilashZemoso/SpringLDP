package com.zemoso.springbootassignment.securityconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	/*
	 * Provides a convenient base class for creating a WebSecurityConfigurer instance.
	 *  The implementation allows customization by overriding methods.
	 */

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("john").password("test123").roles("CUSTOMER"))
			.withUser(users.username("mary").password("test123").roles("VIP"))
			.withUser(users.username("susan").password("test123").roles("INSPECTOR"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*http.authorizeRequests()
				.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll()
			.and()
			.logout()
				.permitAll();
		*/
		http.authorizeRequests()
			.antMatchers("/restaurants/showForm*").hasAnyRole("INSPECTOR","VIP")
			.antMatchers("/restaurants/save*").hasAnyRole("INSPECTOR","VIP")
			.antMatchers("/restaurants/delete*").hasRole("INSPECTOR")
			.antMatchers("/restaurants/list").hasAnyRole("VIP", "INSPECTOR","CUSTOMER")
			.antMatchers("/api/**").permitAll()
			.and()
			.formLogin()
				.loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll()
			.and()
			.logout().permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied");
	}
	
	
	
}
