
package com.AVazquez.PruebaDeltaData.Configuration;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.filter.OncePerRequestFilter;

@Configuration
public class DataSourceConfig {
    
    @Bean
    public DataSource dataSource(){
    
    DriverManagerDataSource dataSource =  new DriverManagerDataSource();
    
    dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
    
    dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
    dataSource.setUsername("AVazquezPruebaDeltaData");
    dataSource.setPassword("password1");
    
    return dataSource;
    }
    
    @Bean
    public JdbcTemplate jdbaTemplate(DataSource dataSource){
    return new JdbcTemplate(dataSource);
    }
    
    @Bean
    public CorsFilter corsFilter(){
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    
    CorsConfiguration config = new CorsConfiguration();
    
    config.addAllowedOrigin("*");
    config.addAllowedMethod("GET");
    config.addAllowedMethod("POST");
    config.addAllowedMethod("PUT");
    config.addAllowedMethod("DELETE");
    
    config.addAllowedHeader("*");
    
    source.registerCorsConfiguration("/**", config);
    
    return new CorsFilter(source);
    
    
    
    }
    
  
    
    
    
}
