package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ginger
 */
@Configuration
public class DefaultConfig implements WebMvcConfigurer {
    /**
     * 主页设置
     * @param registry re
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("pages/login.html");
    }
}
