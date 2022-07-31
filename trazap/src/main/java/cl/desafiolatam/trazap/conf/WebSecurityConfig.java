package cl.desafiolatam.trazap.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import cl.desafiolatam.trazap.app.service.impl.AuthServiceImpl;


@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(auth);

		auth.userDetailsService(userDetailService()).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
	
		http.csrf().disable().authorizeRequests()
												.antMatchers("/ws/**").hasAnyRole("ADMIN", "USER", "PROVEEDOR")
												.antMatchers("/proveedor/**").hasAnyRole("PROVEEDOR")
												.antMatchers("/admin/**").hasRole("ADMIN")
												.antMatchers("/user/**").hasRole("USER")
												.antMatchers("/login").permitAll()
												.and()
												.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
												.authorizeRequests()
												.antMatchers(HttpMethod.POST, "/authenticateUser").permitAll()
												.anyRequest()
												.authenticated()
												.and()
												.formLogin()
												.loginPage("/login")
												.successHandler(customAthenticationSuccessHandler())
												.failureUrl("/login?error=true")
												.usernameParameter("username")
												.passwordParameter("password")
												.and()
												.exceptionHandling()
												.accessDeniedPage("/recurso-prohibido");

												
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationSuccessHandler customAthenticationSuccessHandler() {
		return new CustomAthenticationSuccessHandler();
	}
	
	@Bean
	public UserDetailsService userDetailService() {
		return new AuthServiceImpl();
	}
	
	
}
