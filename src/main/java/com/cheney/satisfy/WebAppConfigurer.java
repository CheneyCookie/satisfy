package com.cheney.satisfy;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.cheney.satisfy.interceptor.LoginInterceptor;

@Configuration
public class WebAppConfigurer extends WebMvcConfigurerAdapter {

    public WebAppConfigurer() {
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

}
