package com.cognizant.trainingservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cognizant.trainingservice.security.AppUserDetailsService;
import com.cognizant.trainingservice.security.JwtAuthorizationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

	@Autowired
	AppUserDetailsService appUserDetailsService;

	public SecurityConfig() {
		LOGGER.info("Inside Security Config Constructor");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(appUserDetailsService).passwordEncoder(passwordEncoder());

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		LOGGER.info("Start of PasswordEncoder");
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.cors();
		httpSecurity.csrf().disable().httpBasic().and().authorizeRequests().antMatchers("/authenticate").permitAll()
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll().antMatchers("/signup/mentor").permitAll()
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll().antMatchers("/signup/mentor/{name}/{skillName}").permitAll()
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll().antMatchers("/signup/trainee").permitAll()
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll().antMatchers("/signup/mentorskill").permitAll()
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll().antMatchers("/book/{mentorName}/{traineeName}/{techName}").permitAll()
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll().antMatchers("/book/pending/{mentorName}").permitAll()
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll().antMatchers("/book/accepttrainee/{trainingId}").permitAll()
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll().antMatchers("/book/rejecttrainee/{trainingId}").permitAll()
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll().antMatchers("/book/accept/{mentorName}").permitAll()
				
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll().anyRequest().authenticated().and()
				.addFilter(new JwtAuthorizationFilter(authenticationManager()));
	
	}

}
