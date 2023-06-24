package com.springboot.myfirstwebapp.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {

	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {

		UserDetails userDetails1 = createnewUser("farhanulla", "tasmiyakhanum");
		UserDetails userDetails2 = createnewUser("tasmiyakhanum", "farhanulla");
		return new InMemoryUserDetailsManager(userDetails1, userDetails2);

	}

	private UserDetails createnewUser(String username, String password) {
		Function<String, String> PasswordEncoder = input -> passEncoder().encode(input);

		UserDetails userDetails = User.builder().passwordEncoder(PasswordEncoder).username(username).password(password)
				.roles("USER", "ADMIN").build();
		return userDetails;
	}

	@Bean
	public PasswordEncoder passEncoder() {
		return new BCryptPasswordEncoder();

	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
		http.formLogin(withDefaults());

		http.csrf().disable();
		http.headers().frameOptions().disable();

		return http.build();

	}

}
