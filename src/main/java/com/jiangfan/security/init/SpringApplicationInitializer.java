package com.jiangfan.security.init;

import com.jiangfan.security.config.ApplicationConfig;
import com.jiangfan.security.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * ClassName: SpringApplicationInitializer
 * Description:
 * date: 2020-8-21 1:14
 *
 * @author LENOVO
 * @since JDK 1.8
 */
public class SpringApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    //指定spring ioc 容器配置类  ,相当于加载applicationContext.xml
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ApplicationConfig.class};
    }

    //指定servletContext配置类,相当于加载springmvc.xml
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    //指定URL mapping
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
