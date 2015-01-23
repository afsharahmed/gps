package config.security;
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
*/
/**
 * This class is the first step to create our Spring Security Java Configuration. 
 * It creates a Servlet Filter known as the springSecurityFilterChain which is responsible 
 * for all the security (protecting the application URLs, validating submitted username & passwords, 
 * redirecting to the log in form, etc) within your application. 
 * 
 * The name of the configureGlobal method is not important. However, 
 * it is important to only configure AuthenticationManagerBuilder in a class annotated with 
 * either @EnableWebSecurity, @EnableWebMvcSecurity, @EnableGlobalMethodSecurity, or @EnableGlobalAuthentication.
 * 
 * @author Afshar
 * @see http://docs.spring.io/spring-security/site/docs/3.2.5.RELEASE/reference/htmlsingle/#new  (section 3.1.2.) 
 */
//@Configuration
//@EnableWebSecurity
public class SecurityConfig {// extends WebSecurityConfigurerAdapter {
 /*
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		//auth.inMemoryAuthentication().withUser("afshar").password("aaaa").roles("USER");
		auth.jdbcAuthentication().dataSource(dataSource)
            .withDefaultSchema()
	}
 
	//.csrf() is optional, enabled by default, if using WebSecurityConfigurerAdapter constructor
	@Override
	protected void configure(HttpSecurity http) throws Exception {
 
	    http.authorizeRequests().anyRequest().authenticated()
	     	# Ensures that any request to our application requires the user to be authenticated
			# Allows users to authenticate with form based login
			# Allows users to authenticate with HTTP Basic authentication
	     
        	.and()
		    .formLogin().loginPage("/login").failureUrl("/login?error").permitAll()
		    .usernameParameter("username").passwordParameter("password")
		    .and()
		    .logout().logoutSuccessUrl("/login?logout"); 
		
	     http.authorizeRequests()
			.antMatchers("/user/**").access("hasRole('ROLE_USER')")
			.and()
			    .formLogin().loginPage("/login").failureUrl("/login?error")
			    .usernameParameter("username").passwordParameter("password")		
			.and()
			    .logout().logoutSuccessUrl("/login?logout")
			.and()
			    .csrf(); 		
	     
	}*/
}