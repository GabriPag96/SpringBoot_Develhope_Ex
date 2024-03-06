package it.example.Interceptor01.Configuration;

import it.example.Interceptor01.interceptors.APILoggingInterceptor;
import it.example.Interceptor01.interceptors.LegacyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    APILoggingInterceptor apiLoggingInterceptor;

    @Autowired
    LegacyInterceptor legacyInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(apiLoggingInterceptor).addPathPatterns("/time");

        registry.addInterceptor(legacyInterceptor).addPathPatterns("/legacy");

    }
}
