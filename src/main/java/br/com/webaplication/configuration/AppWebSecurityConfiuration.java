package br.com.webaplication.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.webaplication.DAO.UserDAO;

@EnableWebSecurity
public class AppWebSecurityConfiuration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/task-list").hasRole("USER")
		.antMatchers(HttpMethod.POST, "/task-list").hasRole("USER")
		.antMatchers("/resources/**").permitAll()
		.anyRequest().authenticated()
		.and().formLogin();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDAO).
			passwordEncoder(new BCryptPasswordEncoder());
	}
}
