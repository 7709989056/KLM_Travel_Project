package com.afkl.cases.df.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;

import lombok.Data;
@Data
@Component
@Configuration
@ConfigurationProperties(prefix = "rest.security")
public class SecurityProperties {

  private boolean enabled;
  private String apiMatcher;
  private Cors cors;
  private String issuerUri;
  
 public CorsConfiguration getCorsConfiguration() {
    CorsConfiguration corsConfiguration = new CorsConfiguration();
    corsConfiguration.setAllowedOrigins(cors.getAllowedOrigins());
    corsConfiguration.setAllowedMethods(cors.getAllowedMethods());
    corsConfiguration.setAllowedHeaders(cors.getAllowedHeaders());
    corsConfiguration.setExposedHeaders(cors.getExposedHeaders());
    corsConfiguration.setAllowCredentials(cors.getAllowCredentials());
    corsConfiguration.setMaxAge(cors.getMaxAge());

    return corsConfiguration;
  }

@Data
  public static class Cors {
    private List<String> allowedOrigins;
    private List<String> allowedMethods;
    private List<String> allowedHeaders;
    private List<String> exposedHeaders;
    private Boolean allowCredentials;
    private Long maxAge;
  }
  
  

}