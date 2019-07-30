package com.zhq.neti.config;

import com.zhq.neti.common.EnumConverterFactory;
import com.zhq.neti.filter.SessionExpireFilter;
import com.zhq.neti.intercepter.SessionIntercepter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zhengquan
 */
@Configuration
public class AppConfiguration implements WebMvcConfigurer {

    @Autowired
    private EnumConverterFactory enumConverterFactory;

    @Bean
    public FilterRegistrationBean sessionExpireFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new SessionExpireFilter());
        registration.addUrlPatterns("/manage/**");
        registration.setOrder(1);
        return registration;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new SessionIntercepter())
                .addPathPatterns("/manage/**")
                .excludePathPatterns("/manage/session");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverterFactory(enumConverterFactory);
    }


}
