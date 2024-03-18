package com.naren.career.movieinfoservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptor(InterceptorRegistry registry) {
        registry.addInterceptor(new ApiLogger()).addPathPatterns("/v1/*");
    }

}
