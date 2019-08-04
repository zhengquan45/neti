package com.zhq.neti.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SwaggerPrintEvent {

    @Value("${swagger.enable}")
    private boolean enable;

    public void printAddress(){
        if(enable) {
            log.info("swagger address : http://localhost:8080/doc.html");
        }
    }
}
