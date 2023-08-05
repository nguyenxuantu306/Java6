package com.poly.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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
				  // .requestMatchers("/static/css/**", "/static/font/**", "/static/images/**", "/static/img/**", "/static/js/**").permitAll()
				   .requestMatchers("/static/**").permitAll()
				   .requestMatchers("/index/register").permitAll()
				   .requestMatchers("/index/register/save").permitAll()
				   .requestMatchers("/home/index").permitAll()
				   .requestMatchers("/admin/home/index").hasRole("Administrator")
				   .requestMatchers("/product/shop_list").hasRole("Administrator")
				   .anyRequest().authenticated()
				   ).formLogin(form -> form
							.loginPage("/index/login").loginProcessingUrl("/home/index")
							.permitAll()
							.and()
						).logout(
			                    logout -> logout
			                    .logoutRequestMatcher(new AntPathRequestMatcher("/index/logoff"))
			                    .permitAll());
						   
//		    .authorizeHttpRequests((authorize) -> 
//		    authorize  .requestMatchers("static/css/**","static/font/**","/static/images/**","/static/img/**","/static/js/**").permitAll()	  
//		    		.requestMatchers("/index/register").permitAll()
//		    		.requestMatchers("/home/index").permitAll()
//		    		.requestMatchers("/admin/home/index").hasRole("Administrator")
//		    		.requestMatchers("/product/shop_list").hasRole("User")
//		           .anyRequest().authenticated()
//		    );
//		   http
//			.formLogin(form -> form
//				.loginPage("/index/login").loginProcessingUrl("/home/index")
//				.defaultSuccessUrl("/product/shop_list")
//				.permitAll()
//			).logout(
//                    logout -> logout
//                    .logoutRequestMatcher(new AntPathRequestMatcher("/index/logoff"))
//                    .permitAll());
		   return http.build();
	   }
	   
	   @Autowired
	   public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		   auth.userDetailsService(userDetailsService)
		   		.passwordEncoder(passwordEncoder());
	   }
}