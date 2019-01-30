package mg.tmr.khr.bara.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class AppSecurity extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/register").permitAll()
				.antMatchers("/login").permitAll()
				.antMatchers("/css/**").permitAll()
	            .antMatchers("/js/**").permitAll()
	            .antMatchers("/webjars/**").permitAll()
				.antMatchers("/confirm").permitAll()
	            .antMatchers("/admin/**").hasAnyRole("ADMIN")
	            .antMatchers("/user/**").hasAnyRole("USER")
	            .anyRequest().authenticated()
	        .and()
            .formLogin()
	            .loginPage("/login")
	            .usernameParameter("email")
	            .permitAll()
            .and()
            .logout()
            	.permitAll();	 
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}	
}