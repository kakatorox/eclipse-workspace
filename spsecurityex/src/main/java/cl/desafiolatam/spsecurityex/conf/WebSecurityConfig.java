package cl.desafiolatam.spsecurityex.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(auth);
		auth.inMemoryAuthentication().withUser("kakato")
									.password(passwordEncoder().encode("1234"))
									.roles("ADMIN");
		auth.inMemoryAuthentication().withUser("peke")
									.password(passwordEncoder().encode("1234"))
									.roles("USER");
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(web);
//		http.csrf().disable().authorizeHttpRequests()
//													.antMatchers("/login").permitAll()
//													.antMatchers("/loginc").permitAll()
//													.anyRequest().authenticated()
//													.and().formLogin().loginPage("/loginc")
//													.failureUrl("/login?error=true")
//													.usernameParameter("username")
//													.passwordParameter("password")
//													.defaultSuccessUrl("/");
		http.csrf().disable().authorizeHttpRequests()
													 .antMatchers("/admin/**").hasRole("ADMIN")
													 .antMatchers("/user/**").hasRole("USER")
													 .antMatchers("/login").permitAll()
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

}
