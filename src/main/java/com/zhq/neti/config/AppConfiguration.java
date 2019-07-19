package com.zhq.neti.config;

import com.zhq.neti.filter.SessionExpireFilter;
import com.zhq.neti.intercepter.SessionIntercepter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class AppConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public FilterRegistrationBean sessionExpireFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new SessionExpireFilter());
        registration.addUrlPatterns("/manage/*");
        registration.setOrder(1);
        return registration;
    }

    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new SessionIntercepter())
                .addPathPatterns("/manage/*")
                .excludePathPatterns("/manage/session");
    }
}
