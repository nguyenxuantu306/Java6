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
				   .requestMatchers("/assets/css/bootstrap.min.css").permitAll()
				   .requestMatchers("/assets/css/responsive.css").permitAll()
				   .requestMatchers("/assets/css/style.css").permitAll()
				   .requestMatchers("/assets/css/bundle.css").permitAll()
				   .requestMatchers("/assets/css/plugin.css").permitAll()
				   .requestMatchers("/assets/css/bootstrap.min.css.map").permitAll()
				   
				   .requestMatchers("/assets/js/vendor/modernizr-2.8.3.min.js").permitAll()
				   .requestMatchers("https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js").permitAll()
				   .requestMatchers("/assets/js/vendor/jquery-1.12.0.min.js").permitAll()
				   .requestMatchers("/assets/js/popper.js").permitAll()
				   .requestMatchers("/assets/js/bootstrap.min.js").permitAll()
				   .requestMatchers("/assets/js/ajax-mail.js").permitAll()
				   .requestMatchers("/assets/js/main.js").permitAll()
				   .requestMatchers("/assets/js/plugins.js").permitAll()
				   .requestMatchers("/assets/js/bootstrap.min.js.map").permitAll()
				   
				   .requestMatchers("/assets/fonts/*").permitAll()
				   .requestMatchers("/assets/images/*").permitAll()
				   .requestMatchers("/assets/img/*").permitAll()
				   .requestMatchers("/assets/js/*").permitAll()
				   .requestMatchers("/home/index","/index/login","/index/register").permitAll()
				    .requestMatchers("/order/**").authenticated()
					.requestMatchers("/admin/**").hasRole("Administrator")
					.requestMatchers("/rest/authorities").permitAll()
					.anyRequest().authenticated()				   
				   );
			
		
//		http.formLogin(form -> form
//				.loginPage("/security/login/form") // địa chỉ đường dẫn
//				.loginProcessingUrl("/home/index") // [[/login]]
//				.defaultSuccessUrl("/security/login/success",false) // đăng nhập thành công
//				.failureUrl("/security/login/error") // đăng nhập sai thông tin user , pass
//				
//				
//				);
			
		   
		   http.formLogin(form -> form
							.loginPage("/index/login")
							.loginProcessingUrl("//home/index")
							.defaultSuccessUrl("/index/login/success",false) // đăng nhập thành công
							.failureUrl("/index/login/error") // đăng nhập sai thông tin user , pass
		   
						)
		   .logout(
			                    logout -> logout
			                    .logoutRequestMatcher(new AntPathRequestMatcher("/index/logoff"))
			                    .permitAll());
//		   
//		   
//		   
//		   		.oauth2Login().loginPage("/oauth2/login/form")
//		   		.defaultSuccessUrl("/oauth2/login/success",true)
//		   		.failureUrl("/oauth2/login/error")
//		   		.authorizationEndpoint().baseUri("/oauth2/authorization")  ;
						   
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
