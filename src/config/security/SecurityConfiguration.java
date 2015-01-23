package config.security;

//import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

/**
 * Any time we annotate a @Configuration class with @EnableWebSecurity or @EnableWebMvcSecurity, 
 * that class must either implement 'WebSecurityConfigurer' or extend 'WebSecurityConfigurerAdapter'.
 * Extending the 'Adapter' is a much simpler approach, and there’s no reason we should ever need to do otherwise.
 * 
 * @author Afshar
 */
//@Configuration
//@EnableWebMvcSecurity	//Enables integration with Spring Web MVC controllers
public class SecurityConfiguration extends WebSecurityConfigurerAdapter 
{
	@Override
	protected void configure(AuthenticationManagerBuilder authManagerBuilder) throws Exception 
	{
		authManagerBuilder
			.inMemoryAuthentication()
					.withUser("aaaa").password("aaaa").authorities("USER")
				.and()
					.withUser("xxxx").password("yyyy").authorities("USER", "ADMIN");
	}

	/**
	 * This method stops Spring Security from evaluating access to resources such as JavaScripts, style sheets, images, etc. 
	 */
	@Override
	public void configure(WebSecurity security) {
		security.ignoring().antMatchers("/images/**"); 
	}

	
	/**
	 * First, it defines several URL
patterns and how they are protected. Again, this is an authorization detail, but it’s necessary
to set up some minimal level of authorization to make Spring Security require users to log in.
The permitAll invocation instructs Spring Security to allow all access to the /signup, /about,
and /policies URLs. Everything under the /secure/ URL requires the user to have the USER
permissions, whereas access to /admin/ and everything under it requires the ADMIN permission. Any
other request simply requires authentication, regardless of permissions.

By default Spring Security redirects user to the URL that he originally requested. So if a user requests \login, after log-in-process he will again be redirected to \login. 
So put 'always-use' param of 'defaultSuccessUrl()' to true. @see http://stackoverflow.com/questions/20924383/incorrect-redirection-of-spring-security-after-login

ne of the most important things is the order of the intercept-urls,
            // the most catch-all type patterns should at the bottom of the list as the matches are executed
            // in the order they are configured below. So /** (anyRequest()) should always be at the bottom of the list
	 */
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
			.authorizeRequests()
				.antMatchers("/signup", "/about", "/policies", "/login**").permitAll()
				.antMatchers("/secure/**").hasAuthority("USER")
				.antMatchers("/admin/**").hasAuthority("ADMIN")
				.anyRequest().authenticated()
			.and().formLogin()
//				.loginPage("/jsp/login.jsp")  .loginProcessingUrl("/login.do").  failureUrl("/jsp/login.jsp?error")
//				.defaultSuccessUrl("/jsp/home.jsp", true)
				//.loginPage("/login").loginProcessingUrl("/login.do").failureUrl("/login?error")
				//.defaultSuccessUrl("/secure/home")
				.usernameParameter("username")
				.passwordParameter("password")
				.permitAll()
			.and()
			.logout()
				//.logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout") //
				.invalidateHttpSession(true).deleteCookies("JSESSIONID")
				.permitAll()
			.and().csrf().disable();
		
		//logger.info(httpSecurity.get);
	}
}
