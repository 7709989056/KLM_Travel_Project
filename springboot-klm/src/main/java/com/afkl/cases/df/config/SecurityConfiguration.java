package com.afkl.cases.df.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
@Configuration
@EnableWebSecurity
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
@ConditionalOnProperty(prefix = "rest.security", value = "enabled", havingValue = "true")
@Import({SecurityProperties.class})
public class SecurityConfiguration  extends ResourceServerConfigurerAdapter {
	@Autowired
	  private SecurityProperties securityProperties;
	
	 @Override
	  public void configure(final HttpSecurity http) throws Exception {

	    http.cors()
	        .and()
	        .headers()
	        .frameOptions()
	        .disable()
	        .and()
	        .csrf()
	        .disable()
	        .authorizeRequests()
	        .antMatchers(securityProperties.getApiMatcher()).permitAll();
	  }

	 
	@Bean
	  public UrlBasedCorsConfigurationSource corsConfigurationSource() {
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    if (null != securityProperties.getCorsConfiguration()) {
	      source.registerCorsConfiguration("/**", securityProperties.getCorsConfiguration());
	    }
	    return source;
	  }

	@Configuration
	  @ConditionalOnProperty(prefix = "security.oauth2.client", value = "grant_type", havingValue = "client_credentials")
	  public static class OAuthRestTemplateConfigurer {
		@Bean
	    public OAuth2RestTemplate oauth2RestTemplate(OAuth2ProtectedResourceDetails details) {
	      OAuth2RestTemplate oAuth2RestTemplate = new OAuth2RestTemplate(details);
	      try {
	      oAuth2RestTemplate.getAccessToken();
	      }catch(Exception e) {
	    	  e.printStackTrace();
	      }
	      return oAuth2RestTemplate;
	    }
	    }	
	

}
