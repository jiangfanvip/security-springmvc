package com.jiangfan.security.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * ClassName: ApplicationConfig
 * Description:
 * date: 2020-8-21 0:54
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@Configuration
//相当于applicationContext.xml   不扫描@controller 所修饰的类
@ComponentScan(basePackages = "com.jiangfan.security", excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)})
public class ApplicationConfig {
}
