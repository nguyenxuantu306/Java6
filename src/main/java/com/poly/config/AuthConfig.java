package com.poly.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class AuthConfig {
	@Autowired
	UserDetailsService userDetailsService;
	
	   @Bean
	    public static PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	   
	   @Bean
	   public SecurityFilterChain fillterchain(HttpSecurity http) throws Exception{
		   http.csrf().disable().cors().disable();
		  
	   
		   http.authorizeRequests(authorize -> authorize
				    .requestMatchers("/order/**").authenticated()
					.requestMatchers("/admin/**").hasRole("Administrator")
					.requestMatchers("/rest/authorities").permitAll()
					.anyRequest().permitAll()				   
				   );
			
		

			
		   
		   http.formLogin(form -> form
							.loginPage("/index/login")
							.loginProcessingUrl("/home/index")
							.defaultSuccessUrl("/index/login/success",false) // đăng nhập thành công
							.failureUrl("/index/login/error") // đăng nhập sai thông tin user , pass
		   
						)
		   .logout(
			                    logout -> logout
			                    .logoutRequestMatcher(new AntPathRequestMatcher("/index/logoff"))
			                    .permitAll());
		   return http.build();
	   }
	   
	
	   
	   @Autowired
	   public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		   auth.userDetailsService(userDetailsService)
		   		.passwordEncoder(passwordEncoder());
	   }
}
