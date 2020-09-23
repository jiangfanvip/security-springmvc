package com.jiangfan.security.config;

import com.jiangfan.security.interceptor.SimpleAuthenticationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * ClassName: WebConfig
 * Description:
 * date: 2020-8-21 1:03
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@Configuration //相当于springmvc.xml
@EnableWebMvc  //开启spring mvc
@ComponentScan(basePackages = "com.jiangfan.security", includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)})
//只扫描注册所修饰的@controller
public class WebConfig implements WebMvcConfigurer {
    /**
     * 配置视图解析器
     *
     * @return
     */
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
    }

    /**
     * 注册过滤器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SimpleAuthenticationInterceptor()).addPathPatterns("/user/**");
    }
}
