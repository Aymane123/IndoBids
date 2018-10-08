package com.indoleads.config;

import com.indoleads.service.CatalogService;
import com.indoleads.tools.Formatter;
import com.indoleads.tools.XmlFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class ApplicationConfig {
    @Bean
    public Formatter formatter()    {
        return new XmlFormatter();
    }
    @Bean
    public CatalogService catalogService()    {
        return new CatalogService();
    }
}
