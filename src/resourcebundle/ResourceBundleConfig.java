package resourcebundle;

import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

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
@Configuration
public class ResourceBundleConfig {
	
	@Bean(name = "messageSource")
	    public ResourceBundleMessageSource configureResourceBundleMessageSource() {
	    ResourceBundleMessageSource resource = new ResourceBundleMessageSource();
	    resource.setBasename("resourcebundle.messages");
	    
	    System.out.println("\n\n\n*******************************************************************************************************");
	    
		System.out.println(resource.getMessage( "login.title", null, Locale.ENGLISH ));
	    return resource;
	 }
	    
	    public void init()
	{
		Resource resource = new ClassPathResource("resourcebundle/messages.properties");
		try
		{
			Properties props = PropertiesLoaderUtils.loadProperties(resource);
			System.out.println("\n\n\n*******************************************************************************************************");
			System.out.println(props.getProperty( "login.title" ));
			
		}
		catch ( IOException e )
		{
			System.err.println("Damn");
			e.printStackTrace();
		}
	}
}