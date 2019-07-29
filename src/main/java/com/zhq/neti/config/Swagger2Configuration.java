package com.zhq.neti.config;

import com.google.common.base.Predicates;
import com.zhq.neti.common.Const;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * @author zhengquan
 * @date 2019/7/26
 */
@Configuration
@EnableSwagger2
public class Swagger2Configuration {

    @Value("${swagger.enable}")
    private boolean enable;

    @Bean
    public Docket manageApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("运营平台")
                .apiInfo(apiInfo())
                .globalOperationParameters(setHeaderToken())
                .select()
                .paths(
                        Predicates.or(
                                regex("/manage/.*")
                        )
                )
                .build().enable(enable);
    }


    private List<Parameter> setHeaderToken() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        tokenPar.name(Const.TOKEN).description("登录后获取到的token")
                .modelRef(new ModelRef("string"))
                .parameterType("header").required(true).build();
        pars.add(tokenPar.build());
        return pars;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("xxxx")
                .description("<h4>接口里pager对象只在查询列表时用到</h4>")
                .termsOfServiceUrl("http://springfox.io")
                .contact(new Contact("名字", "www.baidu.com", "test@163.com"))
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")
                .version("1.0")
                .build();
    }
}
