package com.metacube.training.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth)
//			throws Exception {
//		auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
//		auth.inMemoryAuthentication().withUser("employee").password("123456").roles("EMPLOYEE");
//		// auth.inMemoryAuthentication().withUser("dba").password("123456").roles("DBA");
//	}
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
    UserDetailsService userDetailsService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
		/*
		 * Authenticate user from database
		 */
//		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(NoOpPasswordEncoder.getInstance())
//			.usersByUsernameQuery("select email as username,password,is_enable as enabled from employee where email=?")
//			.authoritiesByUsernameQuery("select username, role from roles where username=?");
		
		/*
		 * Custom Authentication
		 */
		 auth.userDetailsService(userDetailsService);
	     auth.authenticationProvider(authenticationProvider());
	}
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		/*
		 * default login form in form based authentication
		 */
//		 http.authorizeRequests()
//		 .antMatchers("/admin/*").access("hasRole('ROLE_ADMIN')")
//		 .and().formLogin();

		/*
		 * custom login page
		 */
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
				.usernameParameter("username")
				.passwordParameter("password")
				.and()
				.logout().logoutUrl("/logout")
				.logoutSuccessUrl("/login?logout");
	}

	 @Bean
	    public DaoAuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
	        authenticationProvider.setUserDetailsService(userDetailsService);
	        //authenticationProvider.setPasswordEncoder(passwordEncoder());
	        return authenticationProvider;
	 }
}