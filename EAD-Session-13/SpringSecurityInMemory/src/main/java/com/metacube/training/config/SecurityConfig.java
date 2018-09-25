package com.metacube.training.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("employee").password("123456").roles("EMPLOYEE");
		// auth.inMemoryAuthentication().withUser("dba").password("123456").roles("DBA");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
//		 http.authorizeRequests()
//		 .antMatchers("/admin/*").access("hasRole('ROLE_ADMIN')")
//		 .and().formLogin();

		http.authorizeRequests().
		antMatchers("/","/login").permitAll().antMatchers("/admin/*").access("hasRole('ROLE_ADMIN')")
		        .antMatchers("/employee/*").access("hasRole('ROLE_EMPLOYEE')")
		        .anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
			    .failureUrl("/login?error")
				.loginProcessingUrl("/Login")
				.defaultSuccessUrl("/dashboard")
				.and()
				.logout().logoutUrl("/logout")
				.logoutSuccessUrl("/login?logout");
	}

	/*
	 * @Bean public SavedRequestAwareAuthenticationSuccessHandler
	 * savedRequestAwareAuthenticationSuccessHandler() {
	 * SavedRequestAwareAuthenticationSuccessHandler auth = new
	 * SavedRequestAwareAuthenticationSuccessHandler();
	 * auth.setTargetUrlParameter("targetUrl"); return auth; }
	 */
}