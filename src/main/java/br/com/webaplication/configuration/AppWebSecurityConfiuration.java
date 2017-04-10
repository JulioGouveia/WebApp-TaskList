package br.com.webaplication.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import br.com.webaplication.DAO.UserDAO;

@EnableWebSecurity
public class AppWebSecurityConfiuration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/**").permitAll()
		//.antMatchers("/taskList/**").hasRole("USER")
		//.antMatchers(HttpMethod.POST, "/taskList").hasRole("USER")
		//.antMatchers("/resources/**").permitAll()
		//.antMatchers("/login/**").permitAll()
		//.anyRequest().authenticated()
		.and().formLogin().loginPage("/login").permitAll()
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDAO).
			passwordEncoder(new BCryptPasswordEncoder());
	}
}
