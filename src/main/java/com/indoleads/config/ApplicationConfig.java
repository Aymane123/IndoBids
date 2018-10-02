package com.indoleads.config;

import com.indoleads.tools.Formatter;
import com.indoleads.tools.XmlFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public Formatter formatter()    {
        return new XmlFormatter();
    }
}
