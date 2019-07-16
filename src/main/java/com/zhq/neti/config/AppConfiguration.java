package com.zhq.neti.config;

import com.zhq.neti.filter.SessionExpireFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public FilterRegistrationBean sessionExpireFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new SessionExpireFilter());
        registration.addUrlPatterns("/manage/*");
        registration.setOrder(1);
        return registration;
    }
}
